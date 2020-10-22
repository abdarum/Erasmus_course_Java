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
 * Author
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-22T18:11:08.474Z[GMT]")


public class Author   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("userTypeId")
  private Long userTypeId = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("birthdate")
  private Integer birthdate = null;

  @JsonProperty("gender")
  private String gender = null;

  @JsonProperty("adress")
  private String adress = null;

  @JsonProperty("city")
  private String city = null;

  public Author id(Long id) {
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

  public Author userTypeId(Long userTypeId) {
    this.userTypeId = userTypeId;
    return this;
  }

  /**
   * Get userTypeId
   * @return userTypeId
  **/
  @ApiModelProperty(value = "")
  
    public Long getUserTypeId() {
    return userTypeId;
  }

  public void setUserTypeId(Long userTypeId) {
    this.userTypeId = userTypeId;
  }

  public Author firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  **/
  @ApiModelProperty(value = "")
  
    public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Author lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  **/
  @ApiModelProperty(value = "")
  
    public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Author birthdate(Integer birthdate) {
    this.birthdate = birthdate;
    return this;
  }

  /**
   * Timestamp in UTC
   * @return birthdate
  **/
  @ApiModelProperty(value = "Timestamp in UTC")
  
    public Integer getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(Integer birthdate) {
    this.birthdate = birthdate;
  }

  public Author gender(String gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   * @return gender
  **/
  @ApiModelProperty(value = "")
  
    public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Author adress(String adress) {
    this.adress = adress;
    return this;
  }

  /**
   * Get adress
   * @return adress
  **/
  @ApiModelProperty(value = "")
  
    public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

  public Author city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
  **/
  @ApiModelProperty(value = "")
  
    public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Author author = (Author) o;
    return Objects.equals(this.id, author.id) &&
        Objects.equals(this.userTypeId, author.userTypeId) &&
        Objects.equals(this.firstName, author.firstName) &&
        Objects.equals(this.lastName, author.lastName) &&
        Objects.equals(this.birthdate, author.birthdate) &&
        Objects.equals(this.gender, author.gender) &&
        Objects.equals(this.adress, author.adress) &&
        Objects.equals(this.city, author.city);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userTypeId, firstName, lastName, birthdate, gender, adress, city);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Author {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userTypeId: ").append(toIndentedString(userTypeId)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    adress: ").append(toIndentedString(adress)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
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
