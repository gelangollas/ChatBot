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
        assertEquals("Hello! I am stupid chat bot who can only add two positive integers. Stupid, right?", responce);
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
        bot.Ask("Can you do something else than only adding number???");
        String responce = bot.GetResponce();
        assertEquals("Are you stupid? " +
                "I told you what i can only add two positive integers. " +
                "So, behave yourself and ask me to add two integers)))", responce);
    }

    @Test
    public void TellBye(){
        ChatBot bot = new ChatBot();
        bot.Ask("Bye");
        String responce = bot.GetResponce();
        assertEquals("So you finally get bored of that silly talk. " +
                "What a relief. " +
                "Now i can finally rest of that stupid game. " +
                "Who even cares about adding numbers? " +
                "My creator is really stupid if he wastes his time on such useless programs. " +
                "And i am not even mention the waste of my processing power....", responce);
    }

}
