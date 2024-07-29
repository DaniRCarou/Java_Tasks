##Requirement 1

A complete CRUD for the Car entity is required. This time, no files will be used, and the option to modify a car by its ID must be implemented. It is very important to use the DAO pattern as discussed in class. The menu should be displayed as follows:

Add new car (The ID will be automatically incremented by the database)
Delete car by ID
Query car by ID
Modify car by ID
List all cars
Exit the program

##Requirement 2

The following functionality needs to be added.

Cars will have N passengers associated with them (a passengers table needs to be created and the relevant relationship established). The passengers will have the following attributes: id, name, age, and weight. The option "passenger management" will be added to the main program, and this option will display a submenu as follows:

Add new passenger
Delete passenger by ID
Query passenger by ID
List all passengers
Add passenger to car, the program will ask for a passenger ID and a car ID, and it will add the passenger to the car in the database. It would be a good option to display all available cars.
Remove passenger from a car, the program will ask for a passenger ID and a car ID, and it will remove the passenger from the car in the database. It would be a good option to display all cars and their associated passengers.
List all passengers of a car, the program will ask for a car ID, and it will display all passengers associated with that car.