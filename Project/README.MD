# Project - Print Cost Calculator
This application computes the total cost of print orders where the quantity of prints are less than 100. It provides varying prices depending on the customer's size, finish, and processing time preferences, and whether they have a discount code.

## Compilation and Usage
1. **Clone/download**: Clone the git repository into a directory with the following command:
```
git clone https://github.com/coradora/SENG3020.git
```
2. **Compile the program**: Navigate into the project directory and compile the code with the following command:
```
cd SENG3020/Project
javac group1/Main.java group1/Print.java group1/PrintConstants.java
```
3. **Run the Program**: If compiling was successful, type the following command to run the program:
```
java group1.Main
```
4. **Input Selections**: Follow the on-screen prompts to input your print order details.
5. **Review Total Cost**: After all inputs are provided, the program calculates and displays the total cost.

## Example

```plaintext
Enter the number of 4x6 prints: 
0 
Enter the number of 4x6 prints that should be matte: 
0
Enter the number of 5x7 prints: 
30
Enter the number of 5x7 prints that should be matte: 
15
Enter the number of 8x10 prints: 
0
Enter the number of 8x10 prints that should be matte: 
0
Should the prints be processed in 1 hour? (yes/no): 
yes
Enter the discount code (if any, otherwise just press enter): 

The total cost is: $14.60```plaintext


## Group Members
Brannon McCutcheon
Cora Spruill
Luis Vazquez
