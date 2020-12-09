package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.BookReport;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * LibraryBooksReport
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-09T16:01:46.842Z")




public class LibraryBooksReport   {
  @JsonProperty("numberOfBooks")
  private Integer numberOfBooks = null;

  @JsonProperty("numberOfAvailableBooks")
  private Integer numberOfAvailableBooks = null;

  @JsonProperty("books")
  @Valid
  private List<BookReport> books = null;

  public LibraryBooksReport numberOfBooks(Integer numberOfBooks) {
    this.numberOfBooks = numberOfBooks;
    return this;
  }

  /**
   * Get numberOfBooks
   * @return numberOfBooks
  **/
  @ApiModelProperty(value = "")


  public Integer getNumberOfBooks() {
    return numberOfBooks;
  }

  public void setNumberOfBooks(Integer numberOfBooks) {
    this.numberOfBooks = numberOfBooks;
  }

  public LibraryBooksReport numberOfAvailableBooks(Integer numberOfAvailableBooks) {
    this.numberOfAvailableBooks = numberOfAvailableBooks;
    return this;
  }

  /**
   * Get numberOfAvailableBooks
   * @return numberOfAvailableBooks
  **/
  @ApiModelProperty(value = "")


  public Integer getNumberOfAvailableBooks() {
    return numberOfAvailableBooks;
  }

  public void setNumberOfAvailableBooks(Integer numberOfAvailableBooks) {
    this.numberOfAvailableBooks = numberOfAvailableBooks;
  }

  public LibraryBooksReport books(List<BookReport> books) {
    this.books = books;
    return this;
  }

  public LibraryBooksReport addBooksItem(BookReport booksItem) {
    if (this.books == null) {
      this.books = new ArrayList<BookReport>();
    }
    this.books.add(booksItem);
    return this;
  }

  /**
   * Get books
   * @return books
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<BookReport> getBooks() {
    return books;
  }

  public void setBooks(List<BookReport> books) {
    this.books = books;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LibraryBooksReport libraryBooksReport = (LibraryBooksReport) o;
    return Objects.equals(this.numberOfBooks, libraryBooksReport.numberOfBooks) &&
        Objects.equals(this.numberOfAvailableBooks, libraryBooksReport.numberOfAvailableBooks) &&
        Objects.equals(this.books, libraryBooksReport.books);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numberOfBooks, numberOfAvailableBooks, books);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LibraryBooksReport {\n");
    
    sb.append("    numberOfBooks: ").append(toIndentedString(numberOfBooks)).append("\n");
    sb.append("    numberOfAvailableBooks: ").append(toIndentedString(numberOfAvailableBooks)).append("\n");
    sb.append("    books: ").append(toIndentedString(books)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

