package pl.bykowski.springbootjdbc;

import java.time.LocalDate;

public class Book {

  private long id;
  private String title;
  private String author;
  private LocalDate year;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public LocalDate getYear() {
    return year;
  }

  public void setYear(LocalDate year) {
    this.year = year;
  }

  @Override
  public String toString() {
    return "Book{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", year=" + year +
            '}';
  }
}
