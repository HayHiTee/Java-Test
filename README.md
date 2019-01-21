# Java-Test

**A JAVA FILE PROCESSOR TEST APPLICAION**



The sample test file is located in the project directory (sample.txt)


**FILE PROCESSOR**
This program takes a command line that performs two search operations and reads two different Formats
 (F1 and F2) of an input file to STDOUT

**Sample input file**
F1 
D Erica Burns,BARCELONA,93654902Y
D Lucy Mcgee,LONDON,51011156P
D Mitchell Newton,SAN FRANCISCO,25384390A
D Margarita Richards,LAS VEGAS,09877359D
F2
D Mitchell Newton ; LAS VEGAS ; 25384390-A
D Margarita Richards ; NEW YORK ; 09877359-D
D Rhonda Hopkins ; BARCELONA ; 54315871-Z
D Taylor Matthews ; LISBOA ; 58202263-G

**Commands Supported**

1. java -jar application.jar {FILE} CITY {CITY_NAME} 
→ Will print the list of names and ID's belonging to people that have been in that city

2. java -jar application.jar {FILE} ID {ID_VALUE} (ID format example for input: 12345678Z)
→ Will print the list of cities that this person has been to.

Note: Commands are case-insensitive

**Output examples**

java -jar application.jar input.txt CITY CARTAGENA must output an unordered unrepeated list of people and IDs that have been to CARTAGENA.
Mitchell Newton,25384390A
Rhonda Hopkins,54315871Z
Alexander Arnold,21743514G
Susan Holland,04810023X
Jake Salazar,38399984N
java -jar application.jar ID 54808168L must output an unordered unrepeated list of cities that Shelley Payne have been to.
MADRID
BARCELONA
OVIEDO

**Getting Started**

These instructions will get you a copy of the project up
and running on your local machine for development and testing purposes.

**Prerequisites**

You need to have JDK 1.8 or higher installed on your system.
You need to set your system variables(If you would be using your terminal) 
Check online on how to set JAVA_HOME and Path variable for your OS. To set Maven system variable check here
A robust IDE for development(IntelliJ or netbeans)[optional].

**Usage**

Clone or download this repository.
cd to project folder
Download dependencies with your IDE or in the terminal using
mvn dependency:resolve
Compile using
javac {path for application.java} 
and run any of the supported commands without -jar flag.

**OR**

build to jar with your IDE or maven and run any of the supported commands

You can also run the unit tests with your IDE or in the terminal with the command
mvn test

**Built With**

Maven - Dependency Management

**Author**

Iyanuoluwa Temitope Akintilebo



