package org.example.mediator.chat;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ChatHandler implements ChatMediator {
  String applicationName = "System";
  private final Map<String, ChatClient> chatClients;

  public ChatHandler() {
    this.chatClients = new LinkedHashMap<>();
  }

  @Override
  public void registerClient(ChatClient client) {
    String username = client.getUsername();
    if (chatClients.containsKey(username)) {
      client.receiveMessage(
          "A client with username '" + username + "' is already registered.",applicationName,Message.INCOMING);
    }
    chatClients.put(username, client);
    client.setChatHandler(this);
  }

  @Override
  public void sendMessage(String message, ChatClient sender, String recipient) {
    if (message == null || message.isBlank()) return;
    ChatClient recipientClient = chatClients.get(recipient);
    if (recipientClient == null) {
      sender.receiveMessage("User '" + recipient + "' is not online or does not exist.",applicationName,Message.INCOMING);
      return;
    }

    if (recipientClient == sender) {
      sender.receiveMessage("You cannot send a message to yourself.",applicationName,Message.INCOMING);
      return;
    }

    String senderUsername = sender.getUsername();

    sender.receiveMessage(message, senderUsername, Message.OUTGOING);
    recipientClient.receiveMessage(message, senderUsername, Message.INCOMING);
  }

  @Override
  public void broadcastMessage(String message, ChatClient sender) {
    for (ChatClient recipient : chatClients.values()) {
      recipient.receiveMessage(message, applicationName, Message.INCOMING);
    }
  }

  public void systemError(String message, ChatClient recipient) {
    recipient.receiveMessage(message,applicationName,Message.INCOMING);
  }

  @Override
  public List<String> getRegisteredUsernames() {
    return new ArrayList<>(chatClients.keySet());
  }

  public void setRecipients(){
    for (ChatClient recipient : chatClients.values()) {
      recipient.receiveMessage("Welcome to room",applicationName,Message.INCOMING);
      recipient.setRecipients(getRegisteredUsernames());
    }
  }
}
