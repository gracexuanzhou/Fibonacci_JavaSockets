import java.net.*;
import java.io.*;


public class FiboServer {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private static PrintWriter output;
    private static BufferedReader input;
    
    public void startServer(int port) throws IOException {
    	//创建一个serverSocket object, binding端口
    	serverSocket = new ServerSocket(port);
    	//调用accept()方法,监听客户端请求
    	clientSocket = serverSocket.accept();
    	//获取输入流,读取客户端信息
    	output = new PrintWriter(clientSocket.getOutputStream(),true);
    	input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//获取输入流
       	System.out.println("The server succussful started!");
    	
    	}     	   	
    
    
    public void stop() throws IOException {
        input.close();
        output.close();
        clientSocket.close();
        serverSocket.close();
    }
    
    public static void main(String[] args) throws IOException {
        FiboServer server=new FiboServer();
        server.startServer(9991);
        while(true) {
            String in = input.readLine();
            Integer value = Integer.valueOf(in);
            System.out.println(value);
            output.println("Your fibonachi number is: " + Fibonachi.fibonachi(value));
        }
        
//        server.stop();
    }
	
}



