import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<Integer, IDocument> documents = new HashMap<>();

    public void addUnprotectedDocument(int id, LocalDate creationDate, String content) {
        Document doc = new Document(id, creationDate, content);
        documents.put(id, doc);
        System.out.println("[Library] Added unprotected document: " + id);
    }

    public void addProtectedDocument(int id, LocalDate creationDate, String content) {
        Document realDoc = new Document(id, creationDate, content);
        DocumentProxy proxy = new DocumentProxy(realDoc);
        documents.put(id, proxy);
        System.out.println("[Library] Added protected document:   " + id);
    }

    public IDocument getDocument(int id) {
        return documents.get(id);
    }
}
