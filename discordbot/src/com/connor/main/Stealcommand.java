package com.connor.main;

import java.util.concurrent.ExecutionException;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.User;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class Stealcommand implements CommandExecutor {
	private final DiscordAPI api;

    public Stealcommand(DiscordAPI api) {
        this.api = api;
    }
	@Command(aliases ="&STEAL", description = "Steals another users avatar - ADMIN ONLY!", usage ="&steal @username")
    public String onChangeNameCommand(Object[] args, User user) throws InterruptedException, ExecutionException{
    if(args.length == 0){
    	return "Need More Arguments";
    }
    if (user.getId().equals("145281504283459584")){
    if (args.length == 1 && args[0] instanceof User){
    	User target = (User)args[0];
    	try {
    		  api.updateAvatar(target.getAvatar().get());
    		  return "Stole the avatar of your target: "+target.getName();
    		} catch (InterruptedException | ExecutionException e) {
    		  e.printStackTrace();
    		}
    }
    }
    return null;
    }
}
