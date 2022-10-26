package echoserver;
import java.net.*;
import java.io.*;
import java.util.*;

public class EchoClient {
	public static final int portNumber = 6013;

	public static void main(String[] args) throws IOException {
		String hostname;
		if(args.length == 0) {
			hostname = "127.0.0.1";
		} else {
			hostname = args[0];
		}

		try {
			// Create a one way connection to the server
			Socket socker = new Socket(hostname, portNumber);

			// Read the standard input stream
                        // What the user is inputting
                        // Reads a single char and returns the ASCII table value of that char
                        // Returns -1 if no character has been read(end i think)
                        socker.getInputStream().write(System.in);
			OutputStream output = socker.getOutputStream();

			while (output.read() != -1){
				System.out.print(output.read());
			}


			// Close the socket when we're done reading from it
			socker.close();

			// Provide some minimal error handling.
    		} catch (ConnectException ce) {
      			System.out.println("We were unable to connect to " + hostname);
      			System.out.println("You should make sure the server is running.");
    		} catch (IOException ioe) {
      			System.out.println("We caught an unexpected exception");
      			System.err.println(ioe);
    		}		
	}
}
