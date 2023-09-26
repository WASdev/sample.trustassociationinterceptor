package com.ibm.ws.samples.tai;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import java.security.PrivilegedAction;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.websphere.security.WebTrustAssociationException;
import com.ibm.websphere.security.WebTrustAssociationFailedException;
import com.ibm.ws.security.util.AccessController;
import com.ibm.wsspi.security.tai.TAIResult;
import com.ibm.wsspi.security.tai.TrustAssociationInterceptor;
import com.ibm.wsspi.security.token.AttributeNameConstants;

// This custom TAI intercepts any inbound HTTP request that
// includes a custom header.  The default for the custom header name is 
// CUSTOM_HEADER.  The user name is the value for the custom header.
// The custom header name can be customized with a TAI property 
// called headerName.
// 
public class SampleTAI implements TrustAssociationInterceptor {

  private static String _headerName = "CUSTOM_HEADER";

  public SampleTAI() {}

  public int initialize(Properties props) throws WebTrustAssociationFailedException {
    //initialize the implementation. If successful return 0, else return 1.
    if (props!=null) {
      String value = props.getProperty("headerName");
      if (value!=null && value.length()!=0) {
        _headerName = value;
      }
    }
    return 1;
  }
  public boolean isTargetInterceptor(HttpServletRequest req) throws WebTrustAssociationException {
    // Example: 
    // use attributes of the HTTP request to determine if you want your interceptor 
    // to handle the request
    // return true if this is the target interceptor, else return false.
    // 
    if (req!=null && req.getHeader(_headerName) != null) {
      return true;
    }
    return false;
  }
  public TAIResult negotiateValidateandEstablishTrust(HttpServletRequest req, HttpServletResponse resp)
  throws WebTrustAssociationFailedException {
    //validate the request and establish trust.
    //create and return a TAIResult object

    Enumeration<String> headers = req.getHeaders(_headerName);      
    if (Collections.list(headers).size() > 1) {
      throw new WebTrustAssociationFailedException("Too many "+_headerName+" headers");
    }
    String username = req.getHeader(_headerName);
    // now you can either do extra processing to validate the user or transform the value
    // to something that is more friendly to the current registry

    //this code requires that the user be in the WebSphere registry
    TAIResult taiResult = TAIResult.create(HttpServletResponse.SC_OK, username);

    /*
    //the following code does not require that the user be in the WebSphere registry:
    Hashtable<String, Object> credentials = new Hashtable<String, Object>();
    
    String realmName = null;       //set the realm name to the realm name of your user -or-
    realmName = getDefaultRealm(); //set the realm to the default WebSphere realm. This can prevent many processing problems

    String uniqueId = "user:" + realmName + "/" + username; 
    
    credentials.put(AttributeNameConstants.WSCREDENTIAL_UNIQUEID, uniqueId);
    credentials.put(AttributeNameConstants.WSCREDENTIAL_SECURITYNAME, username);     
    credentials.put(AttributeNameConstants.WSCREDENTIAL_REALM, realmName);
    
    //there are other attributes that you can set, like perhaps some groups:
    credentials.put(AttributeNameConstants.WSCREDENTIAL_GROUPS, (List<String>)java.util.Arrays.asList(new String[] {"group1","group2"}));
    
    //new up a Subject, then put the hashtable in the private credentials
    Subject subject = new Subject();
    AccessController.doPrivileged(new PrivilegedAction<Object>() {
        public Object run() {
          subject.getPrivateCredentials().add(credentials);
          return null;
        }
      });
      
    TAIResult taiResult = TAIResult.create(HttpServletResponse.SC_OK, username, subject);
    */
    
    return taiResult;
  }
  
  //get the WebSphere default realm name
  private String getDefaultRealm() {
    String realm = null;
    com.ibm.ws.security.core.ContextManager ctx = com.ibm.ws.security.core.ContextManagerFactory.getInstance();
    if (ctx != null) {
      realm = ctx.getDefaultRealm();
    }
    return realm;
  }
  @Override
  public String getVersion() {
    //Return a version specific to your implementation
    return "1.0";
  }
  @Override
  public String getType() {
    //Return a type specific to your implementation
    return "SampleTAI";
  }
  @Override
  public void cleanup() {
    //Cleanup code specific to your implementation
  }
  @Override
  public String toString() {
    return "SampleTAI []";
  }

}

