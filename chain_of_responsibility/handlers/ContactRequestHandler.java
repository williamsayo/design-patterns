package chain_of_responsibility.handlers;

import chain_of_responsibility.feedback.CustomerFeedback;
import chain_of_responsibility.feedback.Message;

public class ContactRequestHandler extends FeedbackHandler{
    @Override
    public void processFeedback(Message feedback) {
        if (feedback.getMessageType() == CustomerFeedback.CONTACT_REQUEST) {
            System.out.println("Contact Request Received, You would be contacted by a customer care service shortly");
        } else {
            super.processFeedback(feedback);
        }
    }
}
