package org.example.mediator.ui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.mediator.chat.ChatClient;
import org.example.mediator.chat.ChatHandler;
import org.example.mediator.chat.Message;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ChatController implements ChatClient {
  @FXML private TextField messageField;
  @FXML private Button sendButton;
  @FXML private ComboBox<String> recipientBox;
  @FXML private ScrollPane messageScrollPane;
  @FXML private TextArea messageArea;
  @FXML private Label usernameLabel;
  private ChatHandler chatHandler;
  private static final DateTimeFormatter TIME_FMT =
      DateTimeFormatter.ofPattern("HH:mm");

  @FXML
  public void initialize() throws IOException {



  }



  public void setUsername(String username) {
    usernameLabel.setText(username);
  }

  @Override
  public String getUsername() {
    return usernameLabel.getText();
  }

  public void setRecipients(List<String> recipients) {
    recipientBox.getItems().addAll(recipients);
  }

  @Override
  public void receiveMessage(String message, String sender, Message direction) {
    String timestamp = LocalTime.now().format(TIME_FMT);
    String formattedMessage;
    if (direction == Message.INCOMING) {
      formattedMessage = String.format("[%s] %s: %s", timestamp, sender, message);
    }else {
      formattedMessage = String.format("[%s] Me → %s: %s", timestamp, recipientBox.getValue(), message);
    }

    String prefix = (direction == Message.OUTGOING) ? "▶ " : "◀ ";
    messageArea.appendText(prefix + formattedMessage + "\n");
    messageArea.setScrollTop(Double.MAX_VALUE);
  }

  @Override
  public void setChatHandler(ChatHandler chatHandler) {
    this.chatHandler = chatHandler;
  }

  @FXML
  public void handleSend() {
    String message = messageField.getText().trim();
    String recipient = recipientBox.getValue();

    if (message.isEmpty()) return;
    if (recipient == null || recipient.isBlank()) {
      this.chatHandler.systemError("Please select a recipient first.",this);
      return;
    }

    this.chatHandler.sendMessage(message,this,recipient);
    messageField.clear();
    messageField.requestFocus();
  }

}
