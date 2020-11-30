package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Borrowed
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-30T15:30:33.697Z")




@Entity
@Table(name = "borrowed")
@JsonRootName("Borrowed")
public class Borrowed   {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("userId")
  private Long userId = null;

  @JsonProperty("bookId")
  private Long bookId = null;

  @JsonProperty("borrowedDate")
  private OffsetDateTime borrowedDate = null;

  @JsonProperty("returnedDate")
  private OffsetDateTime returnedDate = null;

  @JsonProperty("damageNotes")
  private String damageNotes = null;

  @JsonProperty("placeId")
  private Long placeId = null;

  @JsonProperty("periodId")
  private Long periodId = null;

  public Borrowed id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Borrowed userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(value = "")


  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Borrowed bookId(Long bookId) {
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

  public Borrowed borrowedDate(OffsetDateTime borrowedDate) {
    this.borrowedDate = borrowedDate;
    return this;
  }

  /**
   * Get borrowedDate
   * @return borrowedDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getBorrowedDate() {
    return borrowedDate;
  }

  public void setBorrowedDate(OffsetDateTime borrowedDate) {
    this.borrowedDate = borrowedDate;
  }

  public Borrowed returnedDate(OffsetDateTime returnedDate) {
    this.returnedDate = returnedDate;
    return this;
  }

  /**
   * Get returnedDate
   * @return returnedDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getReturnedDate() {
    return returnedDate;
  }

  public void setReturnedDate(OffsetDateTime returnedDate) {
    this.returnedDate = returnedDate;
  }

  public Borrowed damageNotes(String damageNotes) {
    this.damageNotes = damageNotes;
    return this;
  }

  /**
   * Get damageNotes
   * @return damageNotes
  **/
  @ApiModelProperty(value = "")


  public String getDamageNotes() {
    return damageNotes;
  }

  public void setDamageNotes(String damageNotes) {
    this.damageNotes = damageNotes;
  }

  public Borrowed placeId(Long placeId) {
    this.placeId = placeId;
    return this;
  }

  /**
   * Get placeId
   * @return placeId
  **/
  @ApiModelProperty(value = "")


  public Long getPlaceId() {
    return placeId;
  }

  public void setPlaceId(Long placeId) {
    this.placeId = placeId;
  }

  public Borrowed periodId(Long periodId) {
    this.periodId = periodId;
    return this;
  }

  /**
   * Get periodId
   * @return periodId
  **/
  @ApiModelProperty(value = "")


  public Long getPeriodId() {
    return periodId;
  }

  public void setPeriodId(Long periodId) {
    this.periodId = periodId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Borrowed borrowed = (Borrowed) o;
    return Objects.equals(this.id, borrowed.id) &&
        Objects.equals(this.userId, borrowed.userId) &&
        Objects.equals(this.bookId, borrowed.bookId) &&
        Objects.equals(this.borrowedDate, borrowed.borrowedDate) &&
        Objects.equals(this.returnedDate, borrowed.returnedDate) &&
        Objects.equals(this.damageNotes, borrowed.damageNotes) &&
        Objects.equals(this.placeId, borrowed.placeId) &&
        Objects.equals(this.periodId, borrowed.periodId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, bookId, borrowedDate, returnedDate, damageNotes, placeId, periodId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Borrowed {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    bookId: ").append(toIndentedString(bookId)).append("\n");
    sb.append("    borrowedDate: ").append(toIndentedString(borrowedDate)).append("\n");
    sb.append("    returnedDate: ").append(toIndentedString(returnedDate)).append("\n");
    sb.append("    damageNotes: ").append(toIndentedString(damageNotes)).append("\n");
    sb.append("    placeId: ").append(toIndentedString(placeId)).append("\n");
    sb.append("    periodId: ").append(toIndentedString(periodId)).append("\n");
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

  public Boolean isReturnDelayed(Integer periodDays){
    if(this.getReturnedDate() != null){
      if(this.getReturnedDate().isAfter(this.getBorrowedDate().plusDays(periodDays))){
        return true;
      }
    } else {
      if(OffsetDateTime.now().isAfter(this.getBorrowedDate().plusDays(periodDays))){
        return true;
      }   
    }
    return false;
  }

  public Boolean isReturnedDateValid(){
    if(this.getReturnedDate().isAfter(this.getBorrowedDate())){
      return true;
    }
    return false;
  }
}

