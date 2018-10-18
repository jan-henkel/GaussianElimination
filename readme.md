# Gaussian elimination solver

This Gaussian elimination solver takes as input a matrix, transforms it into row echelon form and outputs all the steps in a LaTeX file, making it suitable for tedious homework assignments.

## Compilation

Just open the .iml file as an IntelliJ IDEA project and build the project.  
You will find the runnable Gauss.jar in the "out" directory.

## Usage

On the command line, run

```
java -jar Gauss.jar
```

Specify the number of rows, columns. Then enter the position of the vertical dash (the one separating the left hand and right hand side of the linear equation). Finally enter the type of arithmetic (modular arithmetic or rational numbers).  
Then enter the matrix row-wise, separating the entries by spaces, like so (for rational numbers):  
1/2 1/3 1/4  
4/5 3/5 2/5  

The Application will then generate a file "out.tex" in the same directory.
