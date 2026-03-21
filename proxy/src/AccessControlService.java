import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AccessControlService {
    private final Map<Integer, List<String>> permissions = new HashMap<>();
    static AccessControlService accessControlService;

    private AccessControlService() {
    }

    public static AccessControlService getInstance(){
        if (accessControlService == null) {
            accessControlService = new AccessControlService();
        }

        return accessControlService;
    }

    public boolean isAllowed(int Id, String username){
        List<String> users = permissions.get(Id);
        return users.contains(username);
    }

    public void grantAccess(int documentId, String username) {
        permissions.computeIfAbsent(documentId, id -> new ArrayList<>()).add(username);
    }

    public void revokeAccess(int documentId, String username) {
        List<String> users = permissions.get(documentId);
        if (users != null) {
            users.remove(username);
        }
    }
}
