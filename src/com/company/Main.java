package com.company;

public class Main {

    public static void main(String[] args) {
        ChatBot bot = new ChatBot();
        //greeting
        System.out.print('\n' + bot.GetResponce() + '\n');

        //dialog
        while(true){
            String request = System.console().readLine();
            bot.Ask(request);
            System.out.print(bot.GetResponce() + '\n');
            if(request.equals(ChatBot.FAREWELL_REQUEST))
                break;
        }

    }
}
