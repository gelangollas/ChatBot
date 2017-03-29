package tests;
import com.company.ChatBot;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TalkingWithChatBot {

    @Test
    public void Ask_2_plus_2(){
        ChatBot bot = new ChatBot();
        bot.Ask("2+2");
        String responce = bot.GetResponce();
        assertEquals("4", responce);
    }

    @Test
    public void Ask_18_plus_20(){
        ChatBot bot = new ChatBot();
        bot.Ask("18+20");
        String responce = bot.GetResponce();
        assertEquals("38", responce);
    }

    @Test
    public void InitialHelloResponce(){
        ChatBot bot = new ChatBot();
        String responce = bot.GetResponce();
        assertEquals("Hello! I am stupid chat bot who can only fold two positive integers. Stupid, right?", responce);
    }

    @Test
    public void Ask_x_plus_y(){
        Random rand = new Random();
        Integer x = rand.nextInt(), y = rand.nextInt();
        if(x < 0) x = -x;
        if(y < 0) y = -y;

        ChatBot bot = new ChatBot();
        bot.Ask(x.toString()+"+"+y.toString());
        String responce = bot.GetResponce();
        BigInteger expected = new BigInteger(x.toString());
        expected = expected.add(new BigInteger(y.toString()));

        assertEquals(expected.toString(), responce);
    }

    @Test
    public void AskWrongRequest(){
        ChatBot bot = new ChatBot();
        bot.Ask("Can you do something else than only folding number???");
        String responce = bot.GetResponce();
        assertEquals("Are you stupid? " +
                "I told you what i can only fold two positive integers. " +
                "So, behave yourself and ask me to fold two integers)))", responce);
    }

}
