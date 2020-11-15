package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * LibraryStats
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-15T16:11:11.651Z")




public class LibraryStats   {
  @JsonProperty("numberOfBooks")
  private Integer numberOfBooks = null;

  @JsonProperty("numberOfAvailableBooks")
  private Integer numberOfAvailableBooks = null;

  public LibraryStats numberOfBooks(Integer numberOfBooks) {
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

  public LibraryStats numberOfAvailableBooks(Integer numberOfAvailableBooks) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LibraryStats libraryStats = (LibraryStats) o;
    return Objects.equals(this.numberOfBooks, libraryStats.numberOfBooks) &&
        Objects.equals(this.numberOfAvailableBooks, libraryStats.numberOfAvailableBooks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numberOfBooks, numberOfAvailableBooks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LibraryStats {\n");
    
    sb.append("    numberOfBooks: ").append(toIndentedString(numberOfBooks)).append("\n");
    sb.append("    numberOfAvailableBooks: ").append(toIndentedString(numberOfAvailableBooks)).append("\n");
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

