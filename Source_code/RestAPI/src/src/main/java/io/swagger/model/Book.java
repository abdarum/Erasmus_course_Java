package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Book
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-09T16:01:46.842Z")




@Entity
@Table(name = "book")
@JsonRootName("Book")
public class Book   {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("isbn")
  private String isbn = null;

  @JsonProperty("authorId")
  private Long authorId = null;

  @JsonProperty("pageCount")
  private Integer pageCount = null;

  @JsonProperty("coverTypeId")
  private Long coverTypeId = null;

  @JsonProperty("genreId")
  private Long genreId = null;

  @JsonProperty("sugeredPeriodId")
  private Long sugeredPeriodId = null;

  @JsonProperty("sugeredPlaceId")
  private Long sugeredPlaceId = null;

  /**
   * Book Status
   */
  public enum StatusEnum {
    AVAILABLE("available"),
    
    IN_USE("in use"),
    
    ARCHIVED("archived");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  public Book id(Long id) {
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

  public Book name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Book isbn(String isbn) {
    this.isbn = isbn;
    return this;
  }

  /**
   * Get isbn
   * @return isbn
  **/
  @ApiModelProperty(value = "")


  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Book authorId(Long authorId) {
    this.authorId = authorId;
    return this;
  }

  /**
   * Get authorId
   * @return authorId
  **/
  @ApiModelProperty(value = "")


  public Long getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Long authorId) {
    this.authorId = authorId;
  }

  public Book pageCount(Integer pageCount) {
    this.pageCount = pageCount;
    return this;
  }

  /**
   * Get pageCount
   * @return pageCount
  **/
  @ApiModelProperty(value = "")


  public Integer getPageCount() {
    return pageCount;
  }

  public void setPageCount(Integer pageCount) {
    this.pageCount = pageCount;
  }

  public Book coverTypeId(Long coverTypeId) {
    this.coverTypeId = coverTypeId;
    return this;
  }

  /**
   * Get coverTypeId
   * @return coverTypeId
  **/
  @ApiModelProperty(value = "")


  public Long getCoverTypeId() {
    return coverTypeId;
  }

  public void setCoverTypeId(Long coverTypeId) {
    this.coverTypeId = coverTypeId;
  }

  public Book genreId(Long genreId) {
    this.genreId = genreId;
    return this;
  }

  /**
   * Get genreId
   * @return genreId
  **/
  @ApiModelProperty(value = "")


  public Long getGenreId() {
    return genreId;
  }

  public void setGenreId(Long genreId) {
    this.genreId = genreId;
  }

  public Book sugeredPeriodId(Long sugeredPeriodId) {
    this.sugeredPeriodId = sugeredPeriodId;
    return this;
  }

  /**
   * Get sugeredPeriodId
   * @return sugeredPeriodId
  **/
  @ApiModelProperty(value = "")


  public Long getSugeredPeriodId() {
    return sugeredPeriodId;
  }

  public void setSugeredPeriodId(Long sugeredPeriodId) {
    this.sugeredPeriodId = sugeredPeriodId;
  }

  public Book sugeredPlaceId(Long sugeredPlaceId) {
    this.sugeredPlaceId = sugeredPlaceId;
    return this;
  }

  /**
   * Get sugeredPlaceId
   * @return sugeredPlaceId
  **/
  @ApiModelProperty(value = "")


  public Long getSugeredPlaceId() {
    return sugeredPlaceId;
  }

  public void setSugeredPlaceId(Long sugeredPlaceId) {
    this.sugeredPlaceId = sugeredPlaceId;
  }

  public Book status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Book Status
   * @return status
  **/
  @ApiModelProperty(value = "Book Status")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(this.id, book.id) &&
        Objects.equals(this.name, book.name) &&
        Objects.equals(this.isbn, book.isbn) &&
        Objects.equals(this.authorId, book.authorId) &&
        Objects.equals(this.pageCount, book.pageCount) &&
        Objects.equals(this.coverTypeId, book.coverTypeId) &&
        Objects.equals(this.genreId, book.genreId) &&
        Objects.equals(this.sugeredPeriodId, book.sugeredPeriodId) &&
        Objects.equals(this.sugeredPlaceId, book.sugeredPlaceId) &&
        Objects.equals(this.status, book.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, isbn, authorId, pageCount, coverTypeId, genreId, sugeredPeriodId, sugeredPlaceId, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Book {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    isbn: ").append(toIndentedString(isbn)).append("\n");
    sb.append("    authorId: ").append(toIndentedString(authorId)).append("\n");
    sb.append("    pageCount: ").append(toIndentedString(pageCount)).append("\n");
    sb.append("    coverTypeId: ").append(toIndentedString(coverTypeId)).append("\n");
    sb.append("    genreId: ").append(toIndentedString(genreId)).append("\n");
    sb.append("    sugeredPeriodId: ").append(toIndentedString(sugeredPeriodId)).append("\n");
    sb.append("    sugeredPlaceId: ").append(toIndentedString(sugeredPlaceId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

  public Book(){
    
  }

  public Book(Book book){
    id = book.getId();
    name = book.getName();
    isbn = book.getIsbn();
    authorId = book.getAuthorId();
    pageCount = getPageCount();
    coverTypeId = getCoverTypeId();
    genreId = getGenreId();
    sugeredPeriodId = book.getSugeredPeriodId();
    sugeredPlaceId = book.getSugeredPlaceId();
    status = book.getStatus();
  }
}

