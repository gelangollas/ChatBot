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

}
