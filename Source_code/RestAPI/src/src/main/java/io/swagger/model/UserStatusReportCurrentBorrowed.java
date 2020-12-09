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
 * UserStatusReportCurrentBorrowed
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-09T16:01:46.842Z")




public class UserStatusReportCurrentBorrowed   {
  @JsonProperty("bookId")
  private Long bookId = null;

  @JsonProperty("bookName")
  private String bookName = null;

  public UserStatusReportCurrentBorrowed bookId(Long bookId) {
    this.bookId = bookId;
    return this;
  }

  /**
   * Get bookId
   * @return bookId
  **/
  @ApiModelProperty(value = "")


  public Long getBookId() {
    return bookId;
  }

  public void setBookId(Long bookId) {
    this.bookId = bookId;
  }

  public UserStatusReportCurrentBorrowed bookName(String bookName) {
    this.bookName = bookName;
    return this;
  }

  /**
   * Get bookName
   * @return bookName
  **/
  @ApiModelProperty(value = "")


  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserStatusReportCurrentBorrowed userStatusReportCurrentBorrowed = (UserStatusReportCurrentBorrowed) o;
    return Objects.equals(this.bookId, userStatusReportCurrentBorrowed.bookId) &&
        Objects.equals(this.bookName, userStatusReportCurrentBorrowed.bookName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookId, bookName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserStatusReportCurrentBorrowed {\n");
    
    sb.append("    bookId: ").append(toIndentedString(bookId)).append("\n");
    sb.append("    bookName: ").append(toIndentedString(bookName)).append("\n");
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

