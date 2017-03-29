package com.company;

import java.math.BigInteger;
import java.util.regex.Pattern;

public class ChatBot {
    static final String INITIAL_RESPONCE = "Hello! " +
            "I am stupid chat bot who can only add two positive integers. " +
            "Stupid, right?";

    static final String WRONG_REQUEST_RESPONCE = "Are you stupid? " +
            "I told you what i can only add two positive integers. " +
            "So, behave yourself and ask me to add two integers)))";

    public static final String FAREWELL_REQUEST = "Bye";

    static final String FAREWELL_RESPONCE = "So you finally get bored of that silly talk. " +
            "What a relief. " +
            "Now i can finally rest of that stupid game. " +
            "Who even cares about adding numbers? " +
            "My creator is really stupid if he wastes his time on such useless programs. " +
            "And i am not even mention the waste of my processing power....";


    String requestBuffer;
    boolean firstResponce = true;

    public ChatBot(){

    }

    public void Ask(String request) {
        requestBuffer = request;
        firstResponce = false;
    }

    public String GetResponce() {
        if(firstResponce){
            return INITIAL_RESPONCE;
        }

        if(IsRequestValid())
            return CalculateExpression(requestBuffer).toString();

        if(requestBuffer.equals(FAREWELL_REQUEST))
            return FAREWELL_RESPONCE;

        return WRONG_REQUEST_RESPONCE;
    }

    private boolean IsRequestValid(){
        return Pattern.matches("\\d+\\+\\d+", requestBuffer);
    }

    private BigInteger CalculateExpression(String expr) {
        String []nums = expr.split("\\+");
        BigInteger x = new BigInteger(nums[0]);
        BigInteger y = new BigInteger(nums[1]);

        return x.add(y);
    }
}
