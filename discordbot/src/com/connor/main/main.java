package com.connor.main;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;

import de.btobastian.javacord.entities.Server;

import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

import de.btobastian.sdcf4j.CommandExecutor;
import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.JavacordHandler;

public class main implements CommandExecutor{

	public static void main(String[] args) {
		
		DiscordAPI api = Javacord.getApi("MTcxNjgyNTk1NDIyMDc2OTI4.Cfvh4A.lROVRdP-G2gr5rqGyLKwreSbTBQ", true);
		CommandHandler handler = new JavacordHandler(api);
		handler.registerCommand(new Commands());
		handler.registerCommand(new HelpCommand(handler));
		handler.registerCommand(new Stealcommand(api));
		handler.registerCommand(new ExecuteCommand());
		String token = api.getToken();
		api.setToken(token, false);
		api.connectBlocking();
		api.registerListener(new MessageCreateListener() {
			@Override
			public void onMessageCreate(DiscordAPI api, Message message) {
			if (!message.isPrivateMessage()) {
				  Server server = message.getChannelReceiver().getServer();
				  if (server.getId().equals("81384788765712384")){
				    System.out.println("User: " + message.getAuthor()+ " Has sent a message in the " + message.getChannelReceiver().getServer()+ message.getChannelReceiver() + " Saying \""+message.getContent()+"\"");
				    System.out.println(message.getAuthor().getRoles(server));
				  }
				  
			}
		}

	});
}
}
