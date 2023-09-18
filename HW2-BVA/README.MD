# Homework 2 - Boundary Value Analysis
## Compilation and Usage
* Clone the git repository into a directory with the following command:
```
git clone https://github.com/coradora/SENG3020.git
```
* Navigate to the HW2 directory and compile the code.
```
cd SENG3020/HW2-BVA/
javac -cp .:testng-7.8.0.jar eost/Insurance.java eost/InsuranceTest.java
```
* Run the TestNG suite with the appropriate dependencies.
```
java -cp .:testng-7.8.0.jar:jcommander.jar:slf4j-api-2.0.9.jar:slf4j-simple-2.0.9.jar org.testng.TestNG -testclass eost.InsuranceTest
```
* Expected output:
```
[main] INFO org.testng.internal.Utils - [TestNG] Running:
  Command line suite


===============================================
Command line suite
Total tests run: 20, Passes: 20, Failures: 0, Skips: 0
===============================================
```
