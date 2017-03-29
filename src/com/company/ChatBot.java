package com.company;

import java.math.BigInteger;

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

        return CalculateExpression(requestBuffer).toString();
    }

    private BigInteger CalculateExpression(String expr) {
        String []nums = expr.split("\\+");
        BigInteger x = new BigInteger(nums[0]);
        BigInteger y = new BigInteger(nums[1]);

        return x.add(y);
    }
}
