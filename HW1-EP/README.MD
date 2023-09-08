# Homework 1 - Equivalence Partitions
## Compilation and Usage
* Clone the git repository into a directory with the following command:
```
git clone https://github.com/coradora/SENG3020.git
```
* Navigate to the HW1 directory and compile the code.
```
cd SENG3020/HW1-EP/
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
Total tests run: 9, Passes: 9, Failures: 0, Skips: 0
===============================================
```
