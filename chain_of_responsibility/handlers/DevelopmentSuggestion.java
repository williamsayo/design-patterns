package chain_of_responsibility.handlers;

import chain_of_responsibility.feedback.CustomerFeedback;
import chain_of_responsibility.feedback.Message;

import java.util.ArrayList;

public class DevelopmentSuggestion extends FeedbackHandler{
    private static ArrayList<String> suggestions;

    @Override
    public void processFeedback(Message feedback) {
        if (feedback.getMessageType() == CustomerFeedback.DEVELOPMENT_SUGGESTION) {
            suggestions.add(feedback.getContent());
            System.out.println("Development suggestion Received");
        } else {
            super.processFeedback(feedback);
        }
    }
}
