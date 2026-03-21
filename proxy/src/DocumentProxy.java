import java.nio.file.AccessDeniedException;
import java.time.LocalDate;

public class DocumentProxy implements IDocument {
    private final Document realDocument;
    private final AccessControlService accessControlService;

    public DocumentProxy(Document realDocument) {
        this.realDocument = realDocument;
        this.accessControlService = AccessControlService.getInstance();
    }

    @Override
    public int getId() {
        return this.realDocument.getId();
    }

    @Override
    public LocalDate getCreationDate() {
        return this.realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) throws CustomAccessDeniedException {
        if (accessControlService.isAllowed(realDocument.getId(), user.getUsername())) {
            System.out.println("[Proxy] Access granted for user '" + user.getUsername()
                    + "' to document '" + realDocument.getId() + "'.");
            return realDocument.getContent(user);
        } else {
            throw new CustomAccessDeniedException(user.getUsername(),realDocument.getId());
        }
    }
}
