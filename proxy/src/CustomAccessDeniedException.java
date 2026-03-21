public class CustomAccessDeniedException extends Exception {

    public CustomAccessDeniedException(String username, int documentId) {
        super("Access denied: user '" + username + "' is not allowed to access document '" + documentId + "'.");
    }
}