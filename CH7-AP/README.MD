# Homework 7 - All Paths Tables
## Compilation and Usage
* Clone the git repository into a directory with the following command:
```
git clone https://github.com/coradora/SENG3020.git
```
* Navigate to the Chapter 7 directory and compile the code.
```
cd SENG3020/CH7-AP/
javac -cp .:libs/testng-7.8.0.jar eost/Insurance.java eost/InsuranceTest.java
```
* Run the TestNG suite with the appropriate dependencies.
```
java -cp .:libs/testng-7.8.0.jar:libs/jcommander.jar:libs/slf4j-api-2.0.9.jar:libs/slf4j-simple-2.0.9.jar org.testng.TestNG -testclass eost.InsuranceTest
```
* Expected output:
```
[main] INFO org.testng.internal.Utils - [TestNG] Running:
  Command line suite

===============================================
Command line suite
Total tests run: 25, Passes: 25, Failures: 0, Skips: 0
===============================================

```
