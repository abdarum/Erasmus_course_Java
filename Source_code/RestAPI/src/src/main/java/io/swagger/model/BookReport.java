package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Book;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BookReport
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-09T16:01:46.842Z")




public class BookReport extends Book  {
  @JsonProperty("authorTypeName")
  private String authorTypeName = null;

  @JsonProperty("coverTypeName")
  private String coverTypeName = null;

  @JsonProperty("genreName")
  private String genreName = null;

  @JsonProperty("sugeredPeriodName")
  private String sugeredPeriodName = null;

  @JsonProperty("sugeredPlaceName")
  private String sugeredPlaceName = null;

  @JsonProperty("statusName")
  private String statusName = null;

  public BookReport authorTypeName(String authorTypeName) {
    this.authorTypeName = authorTypeName;
    return this;
  }

  /**
   * Get authorTypeName
   * @return authorTypeName
  **/
  @ApiModelProperty(value = "")


  public String getAuthorTypeName() {
    return authorTypeName;
  }

  public void setAuthorTypeName(String authorTypeName) {
    this.authorTypeName = authorTypeName;
  }

  public BookReport coverTypeName(String coverTypeName) {
    this.coverTypeName = coverTypeName;
    return this;
  }

  /**
   * Get coverTypeName
   * @return coverTypeName
  **/
  @ApiModelProperty(value = "")


  public String getCoverTypeName() {
    return coverTypeName;
  }

  public void setCoverTypeName(String coverTypeName) {
    this.coverTypeName = coverTypeName;
  }

  public BookReport genreName(String genreName) {
    this.genreName = genreName;
    return this;
  }

  /**
   * Get genreName
   * @return genreName
  **/
  @ApiModelProperty(value = "")


  public String getGenreName() {
    return genreName;
  }

  public void setGenreName(String genreName) {
    this.genreName = genreName;
  }

  public BookReport sugeredPeriodName(String sugeredPeriodName) {
    this.sugeredPeriodName = sugeredPeriodName;
    return this;
  }

  /**
   * Get sugeredPeriodName
   * @return sugeredPeriodName
  **/
  @ApiModelProperty(value = "")


  public String getSugeredPeriodName() {
    return sugeredPeriodName;
  }

  public void setSugeredPeriodName(String sugeredPeriodName) {
    this.sugeredPeriodName = sugeredPeriodName;
  }

  public BookReport sugeredPlaceName(String sugeredPlaceName) {
    this.sugeredPlaceName = sugeredPlaceName;
    return this;
  }

  /**
   * Get sugeredPlaceName
   * @return sugeredPlaceName
  **/
  @ApiModelProperty(value = "")


  public String getSugeredPlaceName() {
    return sugeredPlaceName;
  }

  public void setSugeredPlaceName(String sugeredPlaceName) {
    this.sugeredPlaceName = sugeredPlaceName;
  }

  public BookReport statusName(String statusName) {
    this.statusName = statusName;
    return this;
  }

  /**
   * Get statusName
   * @return statusName
  **/
  @ApiModelProperty(value = "")


  public String getStatusName() {
    return statusName;
  }

  public void setStatusName(String statusName) {
    this.statusName = statusName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookReport bookReport = (BookReport) o;
    return Objects.equals(this.authorTypeName, bookReport.authorTypeName) &&
        Objects.equals(this.coverTypeName, bookReport.coverTypeName) &&
        Objects.equals(this.genreName, bookReport.genreName) &&
        Objects.equals(this.sugeredPeriodName, bookReport.sugeredPeriodName) &&
        Objects.equals(this.sugeredPlaceName, bookReport.sugeredPlaceName) &&
        Objects.equals(this.statusName, bookReport.statusName) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authorTypeName, coverTypeName, genreName, sugeredPeriodName, sugeredPlaceName, statusName, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookReport {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    authorTypeName: ").append(toIndentedString(authorTypeName)).append("\n");
    sb.append("    coverTypeName: ").append(toIndentedString(coverTypeName)).append("\n");
    sb.append("    genreName: ").append(toIndentedString(genreName)).append("\n");
    sb.append("    sugeredPeriodName: ").append(toIndentedString(sugeredPeriodName)).append("\n");
    sb.append("    sugeredPlaceName: ").append(toIndentedString(sugeredPlaceName)).append("\n");
    sb.append("    statusName: ").append(toIndentedString(statusName)).append("\n");
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

