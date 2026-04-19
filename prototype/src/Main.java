import java.util.List;

public class Main {
  public static void main(String[] args) {
    Recommendation recommendation = new Recommendation("students fantasy genre");
    Book book1 = new Book("The Name of the Wind","Patrick Rothfuss","Fantasy",2007);
    Book book2 = new Book("A Wizard of Earthsea","Ursula K. Le Guin","Fantasy",1968);
    Book book3 = new Book("Eragon", "Christopher Paolini","Fantasy",2003);

    Book book4 = new Book("George's Secret Key","Lucy & Stephen Hawking","Science",2007);
    Book book5 = new Book("The Way Things Work","David Macaulay","Non-fiction",1988);
    recommendation.addBooks(List.of(book1, book2, book3));

    Recommendation recommendation2 = recommendation.clone();
    recommendation2.changeAudience("students horror");
    recommendation2.addBooks(List.of(book4, book5));
    recommendation2.removeBook(book2.getTitle());
    recommendation.removeBook(book3.getTitle());

    System.out.println("===================" + recommendation.getTargetAudience() + "====================");
    System.out.println(recommendation.getBooks());
    recommendation.display(6);

    System.out.println("===================" + recommendation2.getTargetAudience() + "====================");
    System.out.println(recommendation2.getBooks());
    recommendation2.display(4);
    System.out.println("============================================");



  }
}
