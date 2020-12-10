package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.User;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SubmitUserReport
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-09T16:01:46.842Z")




public class SubmitUserReport extends User  {
  @JsonProperty("userTypeName")
  private String userTypeName = null;

  public SubmitUserReport userTypeName(String userTypeName) {
    this.userTypeName = userTypeName;
    return this;
  }

  public SubmitUserReport(){

  }

  public SubmitUserReport(User user){
    super(user);
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubmitUserReport submitUserReport = (SubmitUserReport) o;
    return Objects.equals(this.userTypeName, submitUserReport.userTypeName) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userTypeName, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubmitUserReport {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    userTypeName: ").append(toIndentedString(userTypeName)).append("\n");
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

