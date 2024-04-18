In this folder there is a Thread class and a server application


1. In Thread class will count the number of letters in the phrase that the client sends.

- The connection will remain open until the client sends the word "END" to the server.

- Receives the socket that the server opens with the client and with which it will maintain the conversation


2. In Server program, a thread will be opened for each request made by the server in order to process several simultaneous requests from different clients.




