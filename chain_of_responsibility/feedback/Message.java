package chain_of_responsibility.feedback;

public class Message {
    private final CustomerFeedback messageType;
    private final String content;
    private final String email;

    public Message(CustomerFeedback customerFeedback,String email, String content){
        this.messageType = customerFeedback;
        this.content = content;
        this.email = email;
    }

    public CustomerFeedback getMessageType() {
        return messageType;
    }

    public String getContent() {
        return content;
    }

    public String getEmail() {
        return email;
    }
}
