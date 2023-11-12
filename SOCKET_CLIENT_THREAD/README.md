In this example we are going to make the client (SOCKET_CLIENT_THREAD/src/socket_client_thread/SocketClienteThread) send phrases to the server (SOCKET_SERVER_THREAD/src/socket_server_thread/SocketServerThread) and the server will have to count the number of letters in the phrase.

- The connection will remain open until the client sends the word "END" to the server.
- In this case, the same connection will be used for all the exchange of messages from the client to the server.
- As many threads as there are requests will be created, so that the main thread remains listening for new requests.






