Specifications for exercise 1:

To manage an educational center, a program needs to consider the teacher, student and administrative entities, taking into account that all, in turn, are people.

    1. Create the class structure that corresponds to the following instructions:


    The Person class will be abstract.
    All properties will be private and accessible via get/set methods.
    The call() method will return a string similar to this: “Alicia Torres calling Carlos Robles.” As part of the chain, the property name of the object to which it is applied and of the object passed as an argument will be used.
    The work() method will be specialized in each subclass to return a string indicating the type of task each person profile performs. For example:
        Teacher: “Professor Carlos Robles is going to teach his class.” As part of the string you will use the name property.
        Student: “The student Alicia Torres is going to study for the 1st Baccalaureate course.” As part of the chain you will use the name and course properties.
        Administrative: “The administrative officer Rosa Torres is going to carry out these tasks: make registrations, control attendance.” As part of the chain you will use the name and tasks properties.
    In addition, the derived classes will expand their specialization with their own methods such as putNotes(), makeExam() or manageMatricula(). Each of these methods will return a string of this type:
        putNotes(): “Professor Carlos Robles is going to correct the exams.” As part of the string you have to use the name property.
        doExamen(): “The student Alicia Torres is going to take her exam.” As part of the chain you must use the name property.
        administrateMatricula(): “The administrator Rosa Torres is going to manage a registration.” As part of the string you will use the name property.
    In addition to what is specified in the class diagram, you must override the toString() method in each of the classes so that it displays all possible information. You can do it automatically with the help of Eclipse (right click /
    Source / Generate toString…).

    To finish, create the Main class with main method and perform the following actions:

    Create a Teacher object, a Student object, and an Administrative object.
    Run the toString() method on each of them.
    Execute the work() method on each of them.
    Execute the call(Person p) method to have the student call the teacher.
    Executes the putNotes() method of the Teacher object.
    Executes the doExamen() method of the Student object.
    Executes the manageMatricula() method of the Administrative object.







