package echoserver;
import java.net.*;
import java.io.*;

public class EchoClient {
	public static final int portNumber = 420;

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
                        Reader stdIn = new StringReader(new InputStreamReader(System.in));

			// Send a single byte to the server

			// Read a single byte from the server
			// What the server is sending back to the client
			// Reads a single char and converts to ASCII table value of that char
			// Returns -1 if no character has been read(end i think)
			DataOutputStream out = new DataOutputStream(socker.getOutputStream());
			Reader fromServer = new StringReader(out);
			int read = fromServer.read();

			// Write out the output of the server that we received
			// Using read means that the output is in binary
			// Need to convert back to a char
			// Example uses writer.flush(), look into what it does
			// Also can't use PrintWriter
			System.out.println((char)read);
			/* Don't think we need this; goes on server side maybe?
			Writer output = new PrintWriter(read);
			while(read != -1) {
				output.write((char)(read));
			}
			output.flush();
			*/
			//out.write(System.in.read());

			// Get the input stream of the socket
			InputStream input = socker.getInputStream();

			// Close the socket when we're done reading from it
			socker.close();

			// Provide some minimal error handling.
    		} catch (ConnectException ce) {
      			System.out.println("We were unable to connect to " + server);
      			System.out.println("You should make sure the server is running.");
    		} catch (IOException ioe) {
      			System.out.println("We caught an unexpected exception");
      			System.err.println(ioe);
    		}		
	}
}
