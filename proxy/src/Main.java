import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();
        AccessControlService acs = AccessControlService.getInstance();

        User guest = new User("floor worker");
        User nasaDirector   = new User("nasa director");
        User nasaManager = new User("nasa manager");

        List<User> users = new ArrayList<>(List.of(guest, nasaDirector, nasaManager));

        library.addUnprotectedDocument(
                1,
                LocalDate.now(),
                "Welcome to the public Nasa document library!");


        library.addProtectedDocument(
                2,
                LocalDate.now(),
                "CONFIDENTIAL: Nasa Project.");

        library.addProtectedDocument(
                3,
                LocalDate.now(),
                "TOP SECRET: Project Nasa (no man has been on the moon).");

        acs.grantAccess(2, nasaManager.username);
        acs.grantAccess(2, nasaDirector.username);
        acs.grantAccess(3, nasaDirector.username);

        for (int index = 1; index <= 3; index++) {
            for (User user : users) {
                read(library,index,user);
                System.out.println("================");
            }
        }
    }


    private static void read(Library library, int id, User user) {
        IDocument doc = library.getDocument(id);
        if (doc == null) {
            System.out.println("Document not found: " + id);
            return;
        }

        try {
            String content = doc.getContent(user);
            System.out.printf("ACCESS GRANTED - User '%s' \n", user.getUsername());
            System.out.println("Content: " + content);
        } catch (CustomAccessDeniedException e) {
            System.out.printf("ACCESS DENIED - User '%s' %s \n",user.getUsername(), e.getMessage());
        }
    }
}