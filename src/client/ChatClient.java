package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import server.ChatServerIF;

public class ChatClient extends UnicastRemoteObject implements ChatClientIF, Runnable{
	private ChatServerIF chatserver;
	private String name=null;
	protected ChatClient(String name, ChatServerIF chatserver) throws RemoteException {
		this.name = name;
		this.chatserver = chatserver;
		chatserver.registerChatClient(this);
	}

	@Override
	public void retrieveMessage(String message) throws RemoteException {
		System.out.println(message);
		
	}

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		String message;
		while(true)
		{
		message = sc.nextLine();
		try {
			chatserver.broadcastMessage(this.name + " " + message);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}

}
