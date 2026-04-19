import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Prototype<Recommendation> {
  private String targetAudience;
  private final List<Book> books =  new ArrayList<>();

  public Recommendation(String targetAudience) {
    this.targetAudience = targetAudience;
  }

  public List<Book> getBooks() {return this.books;}

  public String getTargetAudience() {return this.targetAudience;}

  public void addBook(Book book) {
    this.books.add(book);
  }

  public void addBooks(List<Book> books) {
    this.books.addAll(books);
  }

  public void removeBook(String title) {
    this.books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
  }

  public void changeAudience(String targetAudience) {
    this.targetAudience = targetAudience;
  }

  @Override
  public Recommendation clone() {
    Recommendation recommendation = new Recommendation(this.targetAudience);
    for (Book book : this.books) {
      recommendation.addBook(book.clone());
    }
    return recommendation;
  }

  @Override
  public String toString() {
    return this.targetAudience;
  }

  public void display(int quantity) {
    int recommendationSize = books.size();
    System.out.printf("%ndisplaying [%d] from Audience: %s%n", Math.min(recommendationSize,quantity), targetAudience);
    if (books.isEmpty()) {
      System.out.println("(no books yet)");
    } else {
      for (int index = 0; index < recommendationSize; index++)
        System.out.printf("%d. %s%n", index + 1, books.get(index));
    }
  }
}
