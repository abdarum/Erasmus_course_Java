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
 * UserLoginBody
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-09T16:01:46.842Z")




public class UserLoginBody   {
  @JsonProperty("email")
  private String email = null;

  @JsonProperty("password")
  private String password = null;

  public UserLoginBody email(String email) {
    this.email = email;
    return this;
  }

  /**
   * The email for login
   * @return email
  **/
  @ApiModelProperty(value = "The email for login")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserLoginBody password(String password) {
    this.password = password;
    return this;
  }

  /**
   * The password for login in clear text
   * @return password
  **/
  @ApiModelProperty(value = "The password for login in clear text")


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserLoginBody userLoginBody = (UserLoginBody) o;
    return Objects.equals(this.email, userLoginBody.email) &&
        Objects.equals(this.password, userLoginBody.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserLoginBody {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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
