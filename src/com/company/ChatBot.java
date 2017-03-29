package com.company;

public class ChatBot {
    String requestBuffer;

    public ChatBot(){

    }

    public void Ask(String request) {
        requestBuffer = request;
    }

    public String GetResponce() {
        if(requestBuffer == "2+2")
            return "4";
        return "38";
    }
}
