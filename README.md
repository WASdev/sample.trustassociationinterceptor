# sample.trustassociationinterceptor

This repository contains a class that serves as a sample implementation of a Trust Association Interceptor (TAI) interface. This project aims to create a sample TAI jar file that is compatible with the following runtimes:
- Open Liberty
- WebSphere Liberty
- WebSphere Application Server traditional 

In order to make sure that the file behaves as intended, follow the steps outlined below:


## Create the sample TAI jar 

1. Obtain the source tree that contains the TAI sample source file:
   - [src/main/java/com/ibm/ws/samples/tai/SampleTAI.java](https://github.com/WASdev/sample.trustassociationinterceptor/blob/main/src/main/java/com/ibm/ws/samples/tai/SampleTAI.java) 
1. Make the necessary modifications to the `SampleTAI.java` file to reflect the desired behavior.
   - This might involve implementing new methods, modifying existing functionality, or adding additional logic as required. 
1. Make sure that you have Maven installed on your system.
   - If you do not have Maven installed, you can download it from the official Maven website and follow the installation instructions.
1. Open a terminal or command prompt and navigate to the root directory of your project where the [pom.xml](https://github.com/WASdev/sample.trustassociationinterceptor/blob/main/pom.xml) file is located.
2. Run the following command to build and package the project using Maven:
   ```
   mvn package
   ```
1. After the build process completes successfully, a `JAR` file is created in the target directory of your project.
   ```
   ./target/sampletai-1.0-SNAPSHOT.jar
   ```

## Configure the TAI jar 

The following articles provide instructions on how to configure the JAR file for the WebSphere runtimes. 

- [WebSphere Liberty or OpenLiberty](https://www.ibm.com/docs/en/was-liberty/core?topic=liberty-configuring-tai)
- [WebSphere Application Server traditional](https://www.ibm.com/docs/en/was/8.5.5?topic=associations-trust-association-interceptor-settings)
  - An end-to-end example for configuring a TAI on WebSphere Application traditional can be found in IBM DOCs at [Developing a custom trust association interceptor](https://www.ibm.com/docs/en/was/9.0.5?topic=SSEQTP_9.0.5/com.ibm.websphere.base.doc/ae/tsec_waci.html)

## Contributing 
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change. 

## License
Unless otherwise noted in a script:<br/>
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)
