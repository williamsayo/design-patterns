public class Book implements Prototype<Book> {
  private String title;
  private String author;
  private String genre;
  private int publicationYear;

  public Book(String title, String author, String genre, int publicationYear) {
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.publicationYear = publicationYear;
  }

  public String getTitle() {return title;}
  public String getAuthor() {return author;}
  public String getGenre() {return genre;}
  public int getPublicationYear() {return publicationYear;}

  public void setTitle(String title) {this.title = title;}
  public void setAuthor(String author) {this.author = author;}
  public void setGenre(String genre) {this.genre = genre;}
  public void setPublicationYear(int publicationYear) {this.publicationYear = publicationYear;}

  @Override
  public Book clone() {
    return new Book(this.title, this.author, this.genre, this.publicationYear);
  }

  public String toString() {
    return String.format("\"%s\" by %s  [%s, %d]", title, author, genre, publicationYear);
  }
}
