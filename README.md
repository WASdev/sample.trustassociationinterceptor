# sample.trustassociationinterceptor

This repository contains a class that serves as an implementation of the Trust Association Interceptor (TAI) interface. The purpose of this class is to facilitate the desired TAI behavior. This project aims to create a sample TAI jar file that is compatible with the following runtimes:
- Open Liberty
- WebSphere Liberty
- WebSphere Application Server traditional 

In order to ensure that the file behaves as intended, please follow the steps outlined below:


## How to create a sample TAI jar 

`1.` Update the following file.  
Make the necessary modifications to the SampleTAI.java file to reflect the desired behavior. This may involve implementing specific methods, modifying existing functionality, or adding additional logic as required. 
```
./src/main/java/com/ibm/ws/samples/tai/SampleTAI.java
```
`2.` Ensure that you have Maven installed on your system. If not, you can download it from the official Maven website and follow the installation instructions. Open a terminal or command prompt and navigate to the root directory of your project where the pom.xml file is located. Run the following command to build and package the project using Maven:
```
mvn package
```
`3.` After the build process completes successfully, the JAR file will be created in the target directory of your project.
```
./target/sampletai-1.0-SNAPSHOT.jar
```

## How to configure TAI jar 

The following articles provide instructions on how to configure the JAR file for the WebSphere runtimes. 

- [WebSphere Liberty or OpenLiberty](https://www.ibm.com/docs/en/was-liberty/core?topic=liberty-configuring-tai)
- [WebSphere Application Server traditional](https://www.ibm.com/docs/en/was/8.5.5?topic=associations-trust-association-interceptor-settings) 

## Contributing 
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change. 

## License
Unless otherwise noted in a script:<br/>
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)
