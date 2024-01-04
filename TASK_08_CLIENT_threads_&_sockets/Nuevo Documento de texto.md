Requirement 1

It is requested to make two client-server programs with sockets and threads. The program server application will consist of creating an application that manages a series of books from a virtual library, the client application will consume said server application.

Books will have an ISBN, a title, an author and a price. They will be hosted on the server. When said server starts up it will have 5 pre-established books with all the data filled in. The workbooks will be stored in memory in any type of data structure (such as a list). The server must be prepared for several clients to interact with it (a thread must be opened for each client).

The client application will display a menu like the following:

    Consult book by ISBN
    Consult book by title
    Exit application

The application will run until the client decides to press the “exit application” option.

The client must collect all the necessary user data and send it to the server in a single sending.

Requirement 2

It is requested to add another option that is “Check books by author”. In this case, it must be taken into account that there may be several books per author, so the server may return a list of books. It is recommended to think about the format for sending information as a group.

Requirement 3

It is requested to add another option that is “Add book”. In this case, the client will request all the book data and send it to the server so that it can save it on the server. The list on the server must be prepared so that only one book can be added by each thread at a time. If any thread is adding a book, the other threads must wait for the thread to finish.

The client must collect all the user's data and send it to the server in a single sending.