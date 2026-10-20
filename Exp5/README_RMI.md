# Java Remote Method Invocation (RMI)

## Overview
Java RMI allows a Java program in one JVM to invoke methods on a remote Java object in another JVM. The practical demonstrates a remote addition operation.

## Main Components
- **Remote interface**: Extends `java.rmi.Remote` and declares remotely callable methods, usually with `RemoteException`.
- **Remote object**: Implements the remote interface and contains the method implementation.
- **RMI Registry**: Maps a name to a remote object reference.
- **Server**: Creates and registers the remote object.
- **Client**: Looks up the object in the registry and calls its remote method.
- **Stub**: Client-side representative that communicates with the remote object. Modern Java RMI handles the dispatch mechanism at runtime.

## Example Flow
1. Start the RMI registry as required by the project.
2. Start the server so it exports and registers the remote object.
3. Run the client.
4. The client looks up the service (for example, `rmi://localhost/Add`).
5. The client invokes `add(10, 20)` and receives `30`.

## Requirements
- Java JDK
- Terminal or command prompt
- Java source files for the remote interface, implementation, server, and client

## Notes
- Use `localhost` when testing on one machine.
- If client and server run on different computers, configure network access and use the server's reachable hostname/IP.
- Follow the source code and run commands provided in the practical document, since filenames and registry startup details depend on the exact implementation.
