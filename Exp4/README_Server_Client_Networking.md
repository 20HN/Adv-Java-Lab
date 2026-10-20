# Java TCP Client–Server Programming

## Overview
This practical demonstrates basic network programming in Java using a TCP client and server. The client sends `Hello Server`; the server prints the message and responds with `Hello Client`.

## Concepts
- **Client**: Initiates a connection and sends a request.
- **Server**: Listens for client connections and responds.
- **IP address**: Identifies a device on a network.
- **Port**: Identifies a service; this example uses port `5000`.
- **Socket**: Endpoint used for communication.
- **TCP**: Connection-oriented, reliable, and ordered communication.

## Files
- `Server.java`: Opens a `ServerSocket` on port 5000, accepts a client, reads a line, sends a response, and closes the connection.
- `Client.java`: Connects to `localhost:5000`, sends a line, reads the response, and closes the connection.

## Run
Open a terminal in the directory containing both files:
```bash
javac Server.java Client.java
```
Start the server first:
```bash
java Server
```
In a second terminal, run:
```bash
java Client
```

## Expected Interaction
- Client sends: `Hello Server`
- Server displays: `Client says: Hello Server`
- Client displays: `Server says: Hello Client`

## Troubleshooting
- Start the server before the client.
- If port 5000 is already in use, choose an available port and change it in both programs.
- `localhost` is appropriate when both programs run on the same computer.
