# Simple Chat Application

**Author:** Vishal Thakur  
**Email:** vishalthakurx@gmail.com  
**GitHub:** [@vishalthakurx](https://github.com/vishalthakurx)

## Description
A simple client-server chat application demonstrating networking, sockets, and multithreading in Java.

## Components
- **ChatServer.java**: Multithreaded server handling multiple clients
- **ChatClient.java**: Client application for connecting to the server

## Features
- Multiple client support
- Real-time message broadcasting
- Thread-safe client management
- Automatic client cleanup on disconnect

## How to Run

### Start the Server
```bash
javac ChatServer.java
java ChatServer
```

### Connect Clients (in separate terminals)
```bash
javac ChatClient.java
java ChatClient
```

## Usage
1. Start the server first
2. Run multiple client instances
3. Type messages in any client - they'll be broadcast to all connected clients
4. Use Ctrl+C to disconnect

## Concepts Demonstrated
- **Socket Programming**: TCP client-server communication
- **Multithreading**: Handling multiple clients concurrently
- **Collections**: Thread-safe collections (Collections.synchronizedSet)
- **I/O Streams**: BufferedReader and PrintWriter
- **Resource Management**: try-with-resources for proper cleanup

## Educational Value
Perfect introduction to network programming, client-server architecture, and concurrent programming in Java.
