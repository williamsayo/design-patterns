package chain_of_responsibility.handlers;

import chain_of_responsibility.feedback.CustomerFeedback;
import chain_of_responsibility.feedback.Message;

public class CompensationClaimHandler extends FeedbackHandler {

    @Override
    public void processFeedback(Message feedback) {
        if (feedback.getMessageType() == CustomerFeedback.COMPENSATION_CLAIM) {
            validateClaim(feedback);
        } else {
            super.processFeedback(feedback);
        }
    }

    public void validateClaim(Message feedback){
        if (isValidClaim(feedback.getContent())){
            System.out.println("Your Compensation Claim is being processed, you would be compensated within 3 business days");
        }else {
            System.out.println("Your Compensation Claim could not be resolved, sorry for the inconvenience");
        }
    }

    public boolean isValidClaim(String claim) {
        return claim.contains("faulty");
    }
}