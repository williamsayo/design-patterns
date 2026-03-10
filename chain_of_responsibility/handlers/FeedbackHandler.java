package chain_of_responsibility.handlers;
import chain_of_responsibility.feedback.Message;

public abstract class FeedbackHandler {
    private FeedbackHandler nextHandler;

    public void processFeedback(Message feedback){
        if (this.nextHandler != null){
            nextHandler.processFeedback(feedback);
        }
    }
    public void setNextHandler(FeedbackHandler handler){
        this.nextHandler = handler;
    }
}
