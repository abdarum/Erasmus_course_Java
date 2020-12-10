package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.UsersRatingReportLoyal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UsersRatingReport
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-10T15:20:50.943Z")




public class UsersRatingReport   {
  @JsonProperty("loyal")
  @Valid
  private List<UsersRatingReportLoyal> loyal = null;

  @JsonProperty("disloyal")
  @Valid
  private List<UsersRatingReportLoyal> disloyal = null;

  public UsersRatingReport loyal(List<UsersRatingReportLoyal> loyal) {
    this.loyal = loyal;
    return this;
  }

  public UsersRatingReport addLoyalItem(UsersRatingReportLoyal loyalItem) {
    if (this.loyal == null) {
      this.loyal = new ArrayList<UsersRatingReportLoyal>();
    }
    this.loyal.add(loyalItem);
    return this;
  }

  /**
   * Get loyal
   * @return loyal
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<UsersRatingReportLoyal> getLoyal() {
    return loyal;
  }

  public void setLoyal(List<UsersRatingReportLoyal> loyal) {
    this.loyal = loyal;
  }

  public UsersRatingReport disloyal(List<UsersRatingReportLoyal> disloyal) {
    this.disloyal = disloyal;
    return this;
  }

  public UsersRatingReport addDisloyalItem(UsersRatingReportLoyal disloyalItem) {
    if (this.disloyal == null) {
      this.disloyal = new ArrayList<UsersRatingReportLoyal>();
    }
    this.disloyal.add(disloyalItem);
    return this;
  }

  /**
   * Get disloyal
   * @return disloyal
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<UsersRatingReportLoyal> getDisloyal() {
    return disloyal;
  }

  public void setDisloyal(List<UsersRatingReportLoyal> disloyal) {
    this.disloyal = disloyal;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsersRatingReport usersRatingReport = (UsersRatingReport) o;
    return Objects.equals(this.loyal, usersRatingReport.loyal) &&
        Objects.equals(this.disloyal, usersRatingReport.disloyal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(loyal, disloyal);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UsersRatingReport {\n");
    
    sb.append("    loyal: ").append(toIndentedString(loyal)).append("\n");
    sb.append("    disloyal: ").append(toIndentedString(disloyal)).append("\n");
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

