package com.ibm.ws.samples.tai;

import com.ibm.wsspi.security.tai.TAIResult;
import com.ibm.wsspi.security.tai.TrustAssociationInterceptor;
import javax.servlet.http.HttpServletResponse;
import com.ibm.websphere.security.WebTrustAssociationException;

import java.util.Enumeration;

import javax.security.auth.Subject;

public class SampleTAI implements TrustAssociationInterceptor {

  public SampleTAI() {

  }

  public boolean isTargetInterceptor(javax.servlet.http.HttpServletRequest arg0)
      throws com.ibm.websphere.security.WebTrustAssociationException {
    return true;
  }

  public com.ibm.wsspi.security.tai.TAIResult negotiateValidateandEstablishTrust(
      javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse arg1)
      throws com.ibm.websphere.security.WebTrustAssociationFailedException {

    System.out.println("Method:" + request.getMethod());

    Enumeration<String> headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String headerName = headerNames.nextElement();
      System.out.println("Header Name - " + headerName + ", Value - " + request.getHeader(headerName));
    }

    Enumeration<String> params = request.getParameterNames();
    while (params.hasMoreElements()) {
      String paramName = params.nextElement();
      System.out.println("Parameter Name - " + paramName + ", Value - " + request.getParameter(paramName));
    }

    return TAIResult.create(HttpServletResponse.SC_OK, "notused", new Subject());
  }

  public int initialize(java.util.Properties arg0)
      throws com.ibm.websphere.security.WebTrustAssociationFailedException {
    return 1;
  }

  @Override
  public void cleanup() {
    // TODO Auto-generated method stub

  }

  @Override
  public String getType() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getVersion() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String toString() {
    return "SampleTAI []";
  }

}
