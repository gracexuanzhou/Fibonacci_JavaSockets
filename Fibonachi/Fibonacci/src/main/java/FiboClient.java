import java.io.*;
import java.net.*;
//import java.util.*;



public class FiboClient {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private BufferedReader input;

    public void startConnection(String ip, int port) throws UnknownHostException, IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void sendMessage() throws IOException {

        System.out.println("Server starts work now!");
        
        input = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
        	System.out.println("Write INTEGER to calculate Fibonachi: ");
        	String s = input.readLine();
        	out.println(s);

            String calcResult = in.readLine();
            if(calcResult != null) {
            	System.out.println(calcResult);
            }
        }
      
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
    
    public static void main (String[] args) throws UnknownHostException, IOException {
    	FiboClient client =  new FiboClient();
    	client.startConnection("127.0.0.1", 9991);
    	client.sendMessage();
    	//client.stopConnection();
    }
}


