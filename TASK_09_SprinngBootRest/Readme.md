###This is a Spring Boot project with Spring web starter

This exercise is represented by task_09 and task_09.1. The first two requirements are represented in this task and the third requirement will be represented in task_09.1.

In this task, I am going to create a server application, built with Spring Boot, that will be consumed by a client, represented in task_09.1.


#Requirement 1

It is requested to create a REST service that will manage a series of video games.

The video games will have an ID, a name, a company, and a rating. The video games will be hosted on the REST server. When the server starts, it will have 5 pre-established video games with all the data filled in. The video games will be stored in memory using any type of data structure (such as a list).

The REST service will provide a complete CRUD service and can be consumed using a client like Postman, with all message exchanges done through JSON.

Additionally, it is requested to perform the following tasks via Postman and observe the results:

    Create a new video game
    Remove a video game by ID
    Modify a video game by ID
    Retrieve a video game by ID
    List all video games

#Requirement 2

It is required that there cannot be two video games with the same ID or name.


#Requirement 3

It is requested to create a Java application capable of interacting with the video game REST server. The application will display a menu capable of performing all server operations, such as:

    Create a new video game
    Remove a video game by ID
    Modify a video game by ID
    Retrieve a video game by ID
    List all video games
    Exit

For each option, the necessary data will be requested from the user and/or relevant results will be displayed. The application will run until the "exit" option is selected.


#Considerations

For the entire activity, clarity of code, modularity, efficiency of employed algorithms, and explanatory comments on key points of the application (JavaDoc or regular comments, whichever is deemed more appropriate) will be evaluated.

The use of GITHUB for group work is recommended.

For submission, compress the source code and upload it to the platform, including a PDF document with everything necessary to demonstrate the correct functioning of the activity (results, screenshots, files, photos, etc.). The PDF document does not need to be extensive but should include, at a minimum, screenshots of the obtained results and an explanation of the key points of the activity performed. It is also acceptable to submit the PDF with the URL providing access to the GITHUB repository without including the source code.
