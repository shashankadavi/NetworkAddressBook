

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
		System.out.println("read request");
		String itr = (String)input.readObject();
		System.out.println(itr);
		int temp = Integer.parseInt(itr);
		Object id=(Object) input.readObject();
	System.out.println("sdsfsf" + id);
		System.out.println("getting element");
	    AddressBook obj= adBook.get(temp);
	    System.out.println("");
	    output=new ObjectOutputStream(Server_Socket.getOutputStream());
	    
	    System.out.println("writing");
	    output.writeObject(obj);
			
	}
	public void write() throws IOException, ClassNotFoundException{
		
		System.out.println("write request");
		AddressBook obj=(AddressBook)input.readObject();
		pos++;
		System.out.println("going to write");
		output=new ObjectOutputStream(Server_Socket.getOutputStream());
		System.out.println("saved at "+pos);
		adBook.add(pos, obj);
		output.writeObject(new String(""+pos));
		System.out.println("sent pos");
		
	}
	
	public void run() {
		//while(true){
			try {
				input=new ObjectInputStream(Server_Socket.getInputStream());
				
				String request=(String)input.readObject();
				System.out.println(request);
				if(request.equals("read")){
					read(input);
					
				}else{
					synchronized (adBook) {
						write();
								
					}
					
					
				}
				
				 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
		
	
	public static void main(String[] args) throws IOException {
		Main_Socket=new ServerSocket(9999);
		System.out.println("--Server started--");
	while(true)
		new Server().start();
		
	}

}
