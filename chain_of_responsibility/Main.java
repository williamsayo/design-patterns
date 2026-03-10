package chain_of_responsibility;

import chain_of_responsibility.feedback.CustomerFeedback;
import chain_of_responsibility.feedback.Message;
import chain_of_responsibility.handlers.*;

public class Main {
    public static void main(String[] args) {
        FeedbackHandler primaryHandler;
        FeedbackHandler compensationHandler = new CompensationClaimHandler();
        FeedbackHandler contactRequestHandler = new ContactRequestHandler();
        FeedbackHandler developmentSuggestionHandler = new DevelopmentSuggestion();
        FeedbackHandler generalFeedbackHandler = new GeneralFeedbackHandler();

        compensationHandler.setNextHandler(contactRequestHandler);
        contactRequestHandler.setNextHandler(developmentSuggestionHandler);
        developmentSuggestionHandler.setNextHandler(generalFeedbackHandler);

        primaryHandler = compensationHandler;

        Message customerMessage = new Message(CustomerFeedback.COMPENSATION_CLAIM,"williamsayo24@gmail.com","I had a bad customer experience with a faulty tool");

        primaryHandler.processFeedback(customerMessage);
    }
}
