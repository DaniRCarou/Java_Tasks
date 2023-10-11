Specifications

- To solve the proposed problem you will create the Student class as a composite, whose components are: name, enrollment and grades, with grades being an ArrayList object of Grade type objects.

- You must finish implementing the Rating class by completing the missing code in the comments position:


public class Rating {

              private String subject;

              private int note; // Value from 0 to 100

              // Constructor that receives arguments for the two properties

            // get/set methods

            @Override

            public String toString() {

                                // Return a string of type: “Language: 55”

            }

}




- You must finish implementing the Student class by completing the missing code in the comments position:


import java.util.ArrayList;

public class Student {

              private String name;

              private int registration;

              private ArrayList<Rating> ratings;

              public Student(String name, int enrollment) {

                           // Assign name and license plate to properties

                          // the parameter values.

                         // Construct ArrayList object qualifications.

              }

             // Add get methods for the three properties

            // which will be read-only.

           public void grade(String subject, int grade) {

                        // Add the new rating

                       // to the ratings collection.

           }

           @Override

           public String toString() {

                        // Return a string similar to this example:

                       // “Student enrollment: 31553 - Carmen Torres”

           }

}

In a Main class, within the main method, you must create a Student object, add 6 grades to it and then display the student's data, the list of grades and the average grade on the screen. The output on the screen once the program is executed will be something like this:
        Student registration: 31553 - Carmen Torres
        Mathematics: 70
        Language: 55
        English: 93
        Physics: 82
        Physical education: 82
        Biology and geology: 58
        AVERAGE GRADE: 73

















