package jcd10;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server extends Thread {
	static LinkedList<AddressBook> adBook=new LinkedList<AddressBook>();
	static int pos=0;
static 	ServerSocket Main_Socket;
	Socket Server_Socket;
	ObjectInputStream input;
	ObjectOutputStream output;
	
	Server() throws IOException{
		
		Server_Socket=Main_Socket.accept();
		
	}
	public void read(ObjectInputStream input) throws IOException, ClassNotFoundException{
		Integer id=(Integer) input.readObject();
	    AddressBook obj= adBook.get(id);
   	   output.writeObject(obj);
			
	}
	public void write() throws IOException, ClassNotFoundException{
		
		AddressBook obj=(AddressBook)input.readObject();
		pos++;
		output.writeInt(pos);
		
	}
	
	public void run() {
		while(true){
			try {
				input=new ObjectInputStream(Server_Socket.getInputStream());
				output=new ObjectOutputStream(Server_Socket.getOutputStream());
				
				String request=(String)input.readObject();
				if(request.equals("read")){
					read(input);
					
				}else{
					
					write();
					
					
					
					
				}
				
				 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
		
	}
	public static void main(String[] args) throws IOException {
		Main_Socket=new ServerSocket(9999);
		System.out.println("--Server started--");
		new Server().start();
		
	}

}
