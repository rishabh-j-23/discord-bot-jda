package com.ryxke.yelan.commands;

import com.ryxke.yelan.Main;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Ping extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getMessage().getContentRaw().equalsIgnoreCase(Main.prefix + "ping")){
            event.getChannel().sendMessage("pong! " + System.currentTimeMillis()).queue();
        }
    }
    
}
