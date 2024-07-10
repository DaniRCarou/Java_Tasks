##Requirement 1

This task involves the implementation of a Java program for managing the car inventory in a dealership. The cars will have the following attributes: id, license plate, make, model, and color.

The user will interact with the program through the following menu, which will serve as the interface.

Add new car
Delete car by id
Query car by id
List cars
Exit the program

Upon starting the program, it should check if the file coches.dat exists (a file that will contain Car objects). If it exists, you should read it to fill an ArrayList collection with all the Car objects from the file. If the coches.dat file does not exist, there will be nothing to do at the moment, but you must leave the ArrayList collection available, even if it is empty.

Menu options 0 to 4 will operate on the ArrayList collection to add, delete, query, or list cars, and not directly on the coches.dat file.

When the user decides to end the program by selecting option 0, the program must create the coches.dat file, overwriting the previous one if it exists. The file should contain as many cars as there are elements in the ArrayList you created.

Score: 6 points out of 10

##Requirement 2

A new option will be added to the menu: "Export cars to CSV file", which will create a file (coches.csv) that will save the car information in CSV format, i.e., values separated by the ";" character. Ensure that this file can be opened with a program like Excel or some online tool.

Score: 3 points out of 10

##Requirement 3

Duplicate ids or license plates are not allowed.

Score: 1 point out of 10