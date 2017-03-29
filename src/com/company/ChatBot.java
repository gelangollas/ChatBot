package com.company;

public class ChatBot {
    static final String INITIAL_RESPONCE = "Hello! " +
            "I am stupid chat bot who can only fold two positive integers. " +
            "Stupid, right?";

    String requestBuffer;
    boolean firstResponce = true;

    public ChatBot(){

    }

    public void Ask(String request) {
        requestBuffer = request;
        firstResponce = false;
    }

    public String GetResponce() {
        //TODO write normal responser
        if(firstResponce){
            return INITIAL_RESPONCE;
        }

        if(requestBuffer == "2+2")
            return "4";
        return "38";
    }
}
