import java.time.Instant;
import java.time.LocalDate;

public interface IDocument {
    int getId();
    LocalDate getCreationDate();
    String getContent(User user) throws CustomAccessDeniedException;
}
