package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import server.ChatServerIF;

public class ChatClientDriver {

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException{
		// TODO Auto-generated method stub
		String chatServerURL = "rmi://localhost/RMIChatServer";	
		ChatServerIF chatserver = (ChatServerIF) Naming.lookup(chatServerURL);
		new Thread(new ChatClient(args[0],chatserver)).start();
	}

}
