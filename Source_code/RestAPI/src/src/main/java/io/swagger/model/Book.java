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
 * Book
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-22T18:11:08.474Z[GMT]")


public class Book   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("isbn")
  private Integer isbn = null;

  @JsonProperty("authorId")
  private Long authorId = null;

  @JsonProperty("pageCount")
  private Integer pageCount = null;

  @JsonProperty("coverTypeId")
  private Long coverTypeId = null;

  @JsonProperty("genreId")
  private Long genreId = null;

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

  public Book isbn(Integer isbn) {
    this.isbn = isbn;
    return this;
  }

  /**
   * Get isbn
   * @return isbn
  **/
  @ApiModelProperty(value = "")
  
    public Integer getIsbn() {
    return isbn;
  }

  public void setIsbn(Integer isbn) {
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
        Objects.equals(this.genreId, book.genreId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, isbn, authorId, pageCount, coverTypeId, genreId);
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
