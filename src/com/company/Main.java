package com.company;

public class Main {

    public static void main(String[] args) {
        ChatBot bot = new ChatBot();
        while(true){
            System.out.print(bot.GetResponce() + '\n');
            String request = System.console().readLine();
            bot.Ask(request);
        }
    }
}
