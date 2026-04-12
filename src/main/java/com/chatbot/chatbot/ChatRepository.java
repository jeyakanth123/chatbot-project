
package com.chatbot.chatbot;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ChatRepository extends JpaRepository<ChatLog, Integer> {
	
	List<ChatLog> findByUserId(int userId);
}
