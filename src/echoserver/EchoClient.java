package echoserver;
import java.net.*;
import java.io.*;

public class EchoClient {
	public static final int portNumber =420;

	public static void main(String[] args) throws IOException {
		String server;
		if(args.length == 0) {
			server 	= "127.0.0.1";
		} else {
			server = args[0];
		}

		try {
			// Connect to the server
			Socket socker = new Socket(server, portNumber);

			DataOutputStream out = new DataOutputStream(socker.getOutputStream());
			out.write(System.in.read());

			// Get the input stream so we can read from that socket
			InputStream input = socker.getInputStream();

			// Print all the input we recieve from the server
			int line;
			while ((line = input.read()) != 0) {
				System.out.println(line);
			}

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
