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
 * Token
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-01T08:48:51.072Z")




@Entity
@Table(name = "token")
@JsonRootName("Token")
public class Token   {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("addDatatime")
  private OffsetDateTime addDatatime = null;

  @JsonProperty("tokenName")
  private String tokenName = null;

  @JsonProperty("userId")
  private Long userId = null;

  @JsonProperty("expireDatatime")
  private OffsetDateTime expireDatatime = null;

  public Token id(Long id) {
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

  public Token addDatatime(OffsetDateTime addDatatime) {
    this.addDatatime = addDatatime;
    return this;
  }

  /**
   * Get addDatatime
   * @return addDatatime
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getAddDatatime() {
    return addDatatime;
  }

  public void setAddDatatime(OffsetDateTime addDatatime) {
    this.addDatatime = addDatatime;
  }

  public Token tokenName(String tokenName) {
    this.tokenName = tokenName;
    return this;
  }

  /**
   * Get tokenName
   * @return tokenName
  **/
  @ApiModelProperty(value = "")


  public String getTokenName() {
    return tokenName;
  }

  public void setTokenName(String tokenName) {
    this.tokenName = tokenName;
  }

  public Token userId(Long userId) {
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

  public Token expireDatatime(OffsetDateTime expireDatatime) {
    this.expireDatatime = expireDatatime;
    return this;
  }

  /**
   * Get expireDatatime
   * @return expireDatatime
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getExpireDatatime() {
    return expireDatatime;
  }

  public void setExpireDatatime(OffsetDateTime expireDatatime) {
    this.expireDatatime = expireDatatime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Token token = (Token) o;
    return Objects.equals(this.id, token.id) &&
        Objects.equals(this.addDatatime, token.addDatatime) &&
        Objects.equals(this.tokenName, token.tokenName) &&
        Objects.equals(this.userId, token.userId) &&
        Objects.equals(this.expireDatatime, token.expireDatatime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, addDatatime, tokenName, userId, expireDatatime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Token {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    addDatatime: ").append(toIndentedString(addDatatime)).append("\n");
    sb.append("    tokenName: ").append(toIndentedString(tokenName)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    expireDatatime: ").append(toIndentedString(expireDatatime)).append("\n");
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

