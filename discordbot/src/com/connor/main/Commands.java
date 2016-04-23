package com.connor.main;


import java.util.Collection;

import de.btobastian.javacord.entities.Server;
import de.btobastian.javacord.entities.User;
import de.btobastian.javacord.entities.permissions.Role;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class Commands implements CommandExecutor  {

	@Command(aliases = "&info", description = "Gets the info of the Bot", usage = "&info")
    public String onInfoCommand(String[] args){
    	if (args.length > 1){
    		return "Too many arguments";
    	}
    	if (args.length == 0){//&info
    		return "**Author** Connor Harkness\n"+
    			   "**Language** Java \n"+
    		       "**Command-Lib** SDCF4J";
    	}
    	return "Unknown argument"; 
    }
	@Command(aliases = "&userinfo", description = "Gets the information of the user", usage ="&userinfo Self|@<insert username here>")
	public String onUserInfoCommand(Object[] args, User author, Server server){

	if(args.length == 0){
		Collection<Role> userroles = author.getRoles(server);
	    StringBuilder builder = new StringBuilder();
	    for(Role role : userroles)
	    {
	    builder.append("\n"+role); // or whatever
	    }
		return "**Name: **"+author.getName()+"\n"+
			   "**User ID:** "+author.getId()+"\n"+
			   "**User Discriminator:** "+author.getDiscriminator()+"\n"+
	    	   "**User Roles:** "+builder.toString()+"\n"+
	           "**Avatar: **"+author.getAvatarUrl();
	}
	if (args.length == 1 && args[0] instanceof User) {
		
	    User target = (User)args[0];
	    Collection<Role> userroles = target.getRoles(server);
	    StringBuilder builder = new StringBuilder();
	    for(Role role : userroles)
	    {
	    builder.append("\n"+role); // or whatever
	    }
	    return "**Name: **"+target.getName() +"\n"+
	    	   "**User ID:** "+target.getId()+"\n"+
	    	   "**User Discriminator:** "+target.getDiscriminator()+"\n"+
	    	   "**User Roles:** "+builder.toString()+"\n"+
	    	   "**Avatar: **" + target.getAvatarUrl();
	}
	if(args.length>1){
		
	}
		return null;
	}
  
	@Command(aliases = "&fite", description = "GET READY TO RUMBLE", usage ="&fite <user1> <user2>")
	public String onFiteCommand(String[] args, User user, Server server){
	if(args.length == 0){
		return "More arguments are needed";
	}
	if(args.length>=2){
		if (!args[0].equals("")){
		if(!args[1].equals("")){
			return "**GET READY TO RUMBLE, In the right corner we have: "+args[0]+"\nAnd in the left corner we have: "+args[1]+"**";
	}
		}
		return"Need more arguments";
	}
		return null;
		

	}
	@Command(aliases = "&Blame", description = "Blames the person you specify", usage ="&blame <user>")
	public String onBlameCommand(String[] args){
	if(args.length == 1){
		return "Blame "+args[0]+" Its their fault obviously!";
	}
	if(args.length>1){
		return "TOO MANY!!! NO, READ THE &help COMMAND!";
	}
		return null;
		

	}
    
}

