
package com.chatbot.chatbot;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ChatController {

    @Autowired
    ChatRepository repo; // 🔥 DB connect

    @GetMapping("/chat")
    public String chat(@RequestParam String message,@RequestParam int userId) {

        String msg = message.toLowerCase();
        String reply;
        if(msg.contains("hi") || msg.contains("hello")) {
            reply = "Hey bro! 👋 எப்படி இருக்க?";
        }
        else if(msg.contains("how are you")) {
            reply = "I'm doing great bro 😄 நீ எப்படி?";
        }
        else if(msg.contains("java")) {
            reply = "Java is powerful bro 💪 Backend ku super 🔥";
        }
        else if(msg.contains("spring")) {
            reply = "Spring Boot na life easy bro 😎";
        }
        else if(msg.contains("name")) {
            reply = "I'm your AI chatbot bro 🤖";
        }
        else if(msg.contains("bye")) {
            reply = "Bye bro 👋 see you soon!";
        }
        else {
            String[] responses = {
                "Interesting bro 🤔 சொல்லு continue...",
                "Nice 😄 இன்னும் detail ah சொல்லு",
                "I see bro 👀",
                "Super da 🔥",
                "Hmm... explain pannunga 🤓"
            };

            reply = responses[(int)(Math.random() * responses.length)];
        }


        // 🔥 SAVE TO DATABASE
        ChatLog log = new ChatLog();
        log.setUserMessage(msg);
        log.setBotReply(reply);
        log.setUserId(userId);

        repo.save(log);

        return reply;
    }
    @GetMapping("/history")
    public java.util.List<ChatLog> getHistory(@RequestParam int userId) {
    	return repo.findByUserId(userId);
    }
    @DeleteMapping("/clear")   // ✅ FINAL
    public String clearChat() {
        repo.deleteAll();
        return "Chat cleared!";
    }
}