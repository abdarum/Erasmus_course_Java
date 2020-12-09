package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.User;
import io.swagger.model.UserStatus;
import io.swagger.model.UserStatusReportCurrentBorrowed;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserStatusReport
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-09T16:01:46.842Z")




public class UserStatusReport extends User  {
  @JsonProperty("numberOfAllBorrowedBooks")
  private Integer numberOfAllBorrowedBooks = null;

  @JsonProperty("numberOfAllDamagedBooks")
  private Integer numberOfAllDamagedBooks = null;

  @JsonProperty("numberOfCurrentBorrowedBooks")
  private Integer numberOfCurrentBorrowedBooks = null;

  @JsonProperty("numberOfDelayedBooks")
  private Integer numberOfDelayedBooks = null;

  @JsonProperty("userTypeName")
  private String userTypeName = null;

  @JsonProperty("currentBorrowed")
  @Valid
  private List<UserStatusReportCurrentBorrowed> currentBorrowed = null;

  public UserStatusReport numberOfAllBorrowedBooks(Integer numberOfAllBorrowedBooks) {
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

  public UserStatusReport numberOfAllDamagedBooks(Integer numberOfAllDamagedBooks) {
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

  public UserStatusReport numberOfCurrentBorrowedBooks(Integer numberOfCurrentBorrowedBooks) {
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

  public UserStatusReport numberOfDelayedBooks(Integer numberOfDelayedBooks) {
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

  public UserStatusReport userTypeName(String userTypeName) {
    this.userTypeName = userTypeName;
    return this;
  }

  /**
   * Get userTypeName
   * @return userTypeName
  **/
  @ApiModelProperty(value = "")


  public String getUserTypeName() {
    return userTypeName;
  }

  public void setUserTypeName(String userTypeName) {
    this.userTypeName = userTypeName;
  }

  public UserStatusReport currentBorrowed(List<UserStatusReportCurrentBorrowed> currentBorrowed) {
    this.currentBorrowed = currentBorrowed;
    return this;
  }

  public UserStatusReport addCurrentBorrowedItem(UserStatusReportCurrentBorrowed currentBorrowedItem) {
    if (this.currentBorrowed == null) {
      this.currentBorrowed = new ArrayList<UserStatusReportCurrentBorrowed>();
    }
    this.currentBorrowed.add(currentBorrowedItem);
    return this;
  }

  /**
   * Get currentBorrowed
   * @return currentBorrowed
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<UserStatusReportCurrentBorrowed> getCurrentBorrowed() {
    return currentBorrowed;
  }

  public void setCurrentBorrowed(List<UserStatusReportCurrentBorrowed> currentBorrowed) {
    this.currentBorrowed = currentBorrowed;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserStatusReport userStatusReport = (UserStatusReport) o;
    return Objects.equals(this.numberOfAllBorrowedBooks, userStatusReport.numberOfAllBorrowedBooks) &&
        Objects.equals(this.numberOfAllDamagedBooks, userStatusReport.numberOfAllDamagedBooks) &&
        Objects.equals(this.numberOfCurrentBorrowedBooks, userStatusReport.numberOfCurrentBorrowedBooks) &&
        Objects.equals(this.numberOfDelayedBooks, userStatusReport.numberOfDelayedBooks) &&
        Objects.equals(this.userTypeName, userStatusReport.userTypeName) &&
        Objects.equals(this.currentBorrowed, userStatusReport.currentBorrowed) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numberOfAllBorrowedBooks, numberOfAllDamagedBooks, numberOfCurrentBorrowedBooks, numberOfDelayedBooks, userTypeName, currentBorrowed, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserStatusReport {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    numberOfAllBorrowedBooks: ").append(toIndentedString(numberOfAllBorrowedBooks)).append("\n");
    sb.append("    numberOfAllDamagedBooks: ").append(toIndentedString(numberOfAllDamagedBooks)).append("\n");
    sb.append("    numberOfCurrentBorrowedBooks: ").append(toIndentedString(numberOfCurrentBorrowedBooks)).append("\n");
    sb.append("    numberOfDelayedBooks: ").append(toIndentedString(numberOfDelayedBooks)).append("\n");
    sb.append("    userTypeName: ").append(toIndentedString(userTypeName)).append("\n");
    sb.append("    currentBorrowed: ").append(toIndentedString(currentBorrowed)).append("\n");
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

