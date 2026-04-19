package org.example.mediator.chat;

import java.util.List;

public interface ChatMediator {
  void registerClient(ChatClient client);
  void sendMessage(String message, ChatClient sender, String recipient);
  void broadcastMessage(String message, ChatClient sender);
  List<String> getRegisteredUsernames();
}
