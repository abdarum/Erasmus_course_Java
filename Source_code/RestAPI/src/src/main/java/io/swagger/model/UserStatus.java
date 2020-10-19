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
 * UserStatus
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-14T17:03:29.621Z[GMT]")


public class UserStatus   {
  @JsonProperty("numberOfAllBorrowedBooks")
  private Integer numberOfAllBorrowedBooks = null;

  @JsonProperty("numberOfAllDamagedBooks")
  private Integer numberOfAllDamagedBooks = null;

  @JsonProperty("numberOfCurrentBorrowedBooks")
  private Integer numberOfCurrentBorrowedBooks = null;

  @JsonProperty("numberOfDelayedBooks")
  private Integer numberOfDelayedBooks = null;

  public UserStatus numberOfAllBorrowedBooks(Integer numberOfAllBorrowedBooks) {
    this.numberOfAllBorrowedBooks = numberOfAllBorrowedBooks;
    return this;
  }

  /**
   * Get numberOfAllBorrowedBooks
   * @return numberOfAllBorrowedBooks
  **/
  @ApiModelProperty(value = "")
  
    public Integer getNumberOfAllBorrowedBooks() {
    return numberOfAllBorrowedBooks;
  }

  public void setNumberOfAllBorrowedBooks(Integer numberOfAllBorrowedBooks) {
    this.numberOfAllBorrowedBooks = numberOfAllBorrowedBooks;
  }

  public UserStatus numberOfAllDamagedBooks(Integer numberOfAllDamagedBooks) {
    this.numberOfAllDamagedBooks = numberOfAllDamagedBooks;
    return this;
  }

  /**
   * Get numberOfAllDamagedBooks
   * @return numberOfAllDamagedBooks
  **/
  @ApiModelProperty(value = "")
  
    public Integer getNumberOfAllDamagedBooks() {
    return numberOfAllDamagedBooks;
  }

  public void setNumberOfAllDamagedBooks(Integer numberOfAllDamagedBooks) {
    this.numberOfAllDamagedBooks = numberOfAllDamagedBooks;
  }

  public UserStatus numberOfCurrentBorrowedBooks(Integer numberOfCurrentBorrowedBooks) {
    this.numberOfCurrentBorrowedBooks = numberOfCurrentBorrowedBooks;
    return this;
  }

  /**
   * Get numberOfCurrentBorrowedBooks
   * @return numberOfCurrentBorrowedBooks
  **/
  @ApiModelProperty(value = "")
  
    public Integer getNumberOfCurrentBorrowedBooks() {
    return numberOfCurrentBorrowedBooks;
  }

  public void setNumberOfCurrentBorrowedBooks(Integer numberOfCurrentBorrowedBooks) {
    this.numberOfCurrentBorrowedBooks = numberOfCurrentBorrowedBooks;
  }

  public UserStatus numberOfDelayedBooks(Integer numberOfDelayedBooks) {
    this.numberOfDelayedBooks = numberOfDelayedBooks;
    return this;
  }

  /**
   * Get numberOfDelayedBooks
   * @return numberOfDelayedBooks
  **/
  @ApiModelProperty(value = "")
  
    public Integer getNumberOfDelayedBooks() {
    return numberOfDelayedBooks;
  }

  public void setNumberOfDelayedBooks(Integer numberOfDelayedBooks) {
    this.numberOfDelayedBooks = numberOfDelayedBooks;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserStatus userStatus = (UserStatus) o;
    return Objects.equals(this.numberOfAllBorrowedBooks, userStatus.numberOfAllBorrowedBooks) &&
        Objects.equals(this.numberOfAllDamagedBooks, userStatus.numberOfAllDamagedBooks) &&
        Objects.equals(this.numberOfCurrentBorrowedBooks, userStatus.numberOfCurrentBorrowedBooks) &&
        Objects.equals(this.numberOfDelayedBooks, userStatus.numberOfDelayedBooks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numberOfAllBorrowedBooks, numberOfAllDamagedBooks, numberOfCurrentBorrowedBooks, numberOfDelayedBooks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserStatus {\n");
    
    sb.append("    numberOfAllBorrowedBooks: ").append(toIndentedString(numberOfAllBorrowedBooks)).append("\n");
    sb.append("    numberOfAllDamagedBooks: ").append(toIndentedString(numberOfAllDamagedBooks)).append("\n");
    sb.append("    numberOfCurrentBorrowedBooks: ").append(toIndentedString(numberOfCurrentBorrowedBooks)).append("\n");
    sb.append("    numberOfDelayedBooks: ").append(toIndentedString(numberOfDelayedBooks)).append("\n");
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
