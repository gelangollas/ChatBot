package tests;
import com.company.ChatBot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


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

}
