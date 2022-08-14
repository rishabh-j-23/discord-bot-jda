package com.ryxke.yelan;

import javax.security.auth.login.LoginException;

import com.ryxke.yelan.commands.Ping;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main implements EventListener{

    private static String TOKEN = System.getenv("TOKEN");
    public static String prefix = "!!";
    public static void main(String[] args) throws LoginException {

        JDA api = JDABuilder.createDefault(TOKEN)
        .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MEMBERS)
        .build();
    

        addCommands(api);

    }
    public static void addCommands(JDA api){
        api.addEventListener(new Main());
        api.addEventListener(new Ping());
    }

    @Override
    public void onEvent(GenericEvent event) {

        if (event instanceof ReadyEvent) {

            System.out.println("Logged in");
            
        }
        
    }
}
