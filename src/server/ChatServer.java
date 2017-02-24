package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import client.ChatClientIF;

public class ChatServer extends UnicastRemoteObject implements ChatServerIF{
	private static final long serialVersionUID = 1L;
	private ArrayList<ChatClientIF> chatclients;
	protected ChatServer() throws RemoteException {
		chatclients = new ArrayList<ChatClientIF>();
	}

	public synchronized void registerChatClient(ChatClientIF chatClient) throws RemoteException {
		this.chatclients.add(chatClient);
	}

	public void broadcastMessage(String message) throws RemoteException {
		// TODO Auto-generated method stub
		int i=0;
		while(i<chatclients.size())
		{
			chatclients.get(i++).retrieveMessage(message);
		}	
	}

}
