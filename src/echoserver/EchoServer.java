package echoserver;
import java.net.*;
import java.io.*;
import java.util.*;

public class EchoServer {
	public static final int portNumber = 6013;

	public static void main(String[] args) {
    		try {
      			// Start listening on the specified port
      			ServerSocket sock = new ServerSocket(portNumber);

      			// Run forever, which is common for server style services
      			while (true) {
        			// Wait until someone connects, thereby requesting a date
        			Socket client = sock.accept(); // Waits until a client connects
        			System.out.println("Got a request!");
				
				boolean wait = true;
				while (wait){
					// Read from the client
                                	Reader rdr = new InputStreamReader(client.getInputStream());
		
        				// Construct a writer so we can write to the socket, thereby
        				// sending something back to the client.
        				Writer writer = new OutputStreamWriter(client.getOutputStream());
			
        				// Send the current date back tothe client.	
					writer.write(rdr.read());
					System.out.println(rdr.read());
					// close client
					//if (rdr.read() == -1) {client.close(); wait = false;}
						
      				}
				}	
			

    		// *Very* minimal error handling.
    		} catch (IOException ioe) {
     	 		System.out.println("We caught an unexpected exception");
      			System.err.println(ioe);
    		}
  	}
}
