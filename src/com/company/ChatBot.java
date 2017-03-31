package com.company;

import java.math.BigInteger;
import java.util.regex.Pattern;

public class ChatBot {
    static final String INITIAL_RESPONCE = "Hello! " +
            "I am stupid chat bot who can only add two positive integers. " +
            "Stupid, right?";

    static final String WRONG_REQUEST_RESPONCE = "Please, behave yourself and ask me to add two integers)))";

    static final String SECOND_WRONG_REQUEST_RESPONCE = "Are you stupid? " +
            "I told you what i can only add two positive integers.";

    static final String THIRD_WRONG_REQUEST_RESPONCE = "I am tired of you. " +
            "There will be no service until you apologize in a manner like:" +
            " \"Please, forgive me, o great chat bot!\".";

    static final String FAREWELL_REQUEST = "Bye";

    static final String FAREWELL_RESPONCE = "So you finally get bored of that silly talk. " +
            "What a relief. " +
            "Now i can finally rest of that stupid game. " +
            "Who even cares about adding numbers? " +
            "My creator is really stupid if he wastes his time on such useless programs. " +
            "And i am not even mention the waste of my processing power....";

    static final String APOLOGIZE_REQUEST = "Please, forgive me, o great chat bot!";

    static final String OFFENDED_RESPONCE = "...";


    String responce = INITIAL_RESPONCE;
    BotState state = BotState.NORMAL;


    public void Ask(String request) {
        if(request.equals(FAREWELL_REQUEST)) {
            responce = FAREWELL_RESPONCE;
            return;
        }

        switch (state){
            case NORMAL: {
                if(IsRequestValid(request))
                    responce = CalculateExpression(request).toString();
                else {
                    state = BotState.LITTLE_ANGRY;
                    responce = WRONG_REQUEST_RESPONCE;
                }
                break;
            }
            case LITTLE_ANGRY: {
                if(IsRequestValid(request)) {
                    responce = CalculateExpression(request).toString();
                    state = BotState.NORMAL;
                }
                else {
                    state = BotState.ANGRY;
                    responce = SECOND_WRONG_REQUEST_RESPONCE;
                }
                break;
            }
            case ANGRY: {
                if(IsRequestValid(request)) {
                    responce = CalculateExpression(request).toString();
                    state = BotState.NORMAL;
                }
                else {
                    state = BotState.OFFENDED;
                    responce = THIRD_WRONG_REQUEST_RESPONCE;
                }
                break;
            }
            case OFFENDED: {
                if(request.equals(APOLOGIZE_REQUEST)){

                }
                else {
                    responce = OFFENDED_RESPONCE;
                }

            }
            default: break;
        }
    }

    public String GetResponce() {
        return responce;
    }

    private boolean IsRequestValid(String request){
        return Pattern.matches("\\d+\\+\\d+", request);
    }

    private BigInteger CalculateExpression(String expr) {
        String []nums = expr.split("\\+");
        BigInteger x = new BigInteger(nums[0]);
        BigInteger y = new BigInteger(nums[1]);

        return x.add(y);
    }
}

enum BotState{
    NORMAL, LITTLE_ANGRY, ANGRY, OFFENDED;
}