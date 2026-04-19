package org.example.mediator.chat;

import java.util.List;

public interface ChatClient {
  String getUsername();
  void receiveMessage(String message, String sender, Message direction);
  void setChatHandler(ChatHandler chatHandler);
  void setRecipients(List<String> recipients);
}