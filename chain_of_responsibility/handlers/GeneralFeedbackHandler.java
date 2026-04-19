package chain_of_responsibility.handlers;

import chain_of_responsibility.feedback.CustomerFeedback;
import chain_of_responsibility.feedback.Message;

public class GeneralFeedbackHandler extends FeedbackHandler{
    @Override
    public void processFeedback(Message feedback) {
        if (feedback.getMessageType() == CustomerFeedback.GENERAL_FEEDBACK) {
            System.out.println("Thank you for the feedback, your feedbacks help improve our service");
        } else {
            super.processFeedback(feedback);
        }
    }
}
