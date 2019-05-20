# RPN calculator

Rpn is a command line RPN(reverse polish notation) calculator. 

# Supported function

- Basic math operators(+, -, *, / and sqrt)
- Undo and clear functionality

# How to build

You require the following to build rpn:

* Latest stable [Oracle JDK 8](http://www.oracle.com/technetwork/java/)
* Latest stable [Apache Maven](http://maven.apache.org/)

Turn to the root directory of this project, run the following command, then you could get a runnable jar named "rpn-1.0-SNAPSHOT.jar"
```bash
mvn clean install
```

# How to run

Turn to the target directory, run the following command to start the calculator and try it!
```bash
java -jar rpn-1.0-SNAPSHOT.jar
```
#Examples for input and output
##Example 1
```bash
5 2
stack: 5 2
```
##Example 2
```bash
2 sqrt 
stack: 1.4142135623
clear 9 sqrt
stack: 3
```
##Example 3
```bash
5 4 3 2
stack: 5 4 3 2
undo undo *
stack: 20
5 *
stack: 100
undo
stack: 20 5
```
