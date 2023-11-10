# Homework 9 - Combination Decision Table
## Compilation and Usage
* Clone the git repository into a directory with the following command:
```
git clone https://github.com/coradora/SENG3020.git
```
* Navigate to the Chapter 9 directory and compile the code.
```
cd SENG3020/CH9-DTCombo/
javac -cp .:libs/testng-7.8.0.jar example/SpaceOrder.java example/SpaceOrderTest.java
```
* Run the TestNG suite with the appropriate dependencies.
```
java -cp .:libs/testng-7.8.0.jar:libs/jcommander.jar:libs/slf4j-api-2.0.9.jar:libs/slf4j-simple-2.0.9.jar org.testng.TestNG -testclass example.SpaceOrderTest
```
* Expected output:
```
===============================================
Default Suite
Total tests run: 6, Passes: 6, Failures: 0, Skips: 0
===============================================
```
