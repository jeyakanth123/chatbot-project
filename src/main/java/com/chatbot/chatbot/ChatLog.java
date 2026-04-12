
package com.chatbot.chatbot;

import jakarta.persistence.*;

@Entity
@Table(name = "chat_logs")
public class ChatLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_message")
    private String userMessage;
    
    @Column(name = "user_id")
    private int userId;
    
    @Column(name = "bot_reply")
    private String botReply;
      
    @Column(name = "created_at", insertable = false, updatable = false)
    private java.sql.Timestamp createdAt;

    // 🔥 GETTERS & SETTERS

    public int getId() {
        return id;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }
    public int getUserId() { 
    	return userId; 
    	}
    public void setUserId(int userId) { 
    	this.userId = userId; 
    	}

    public String getBotReply() {
        return botReply;
    }

    public void setBotReply(String botReply) {
        this.botReply = botReply;
    }
    public java.sql.Timestamp getCreatedAt() {
        return createdAt;
    }
    
}