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
 * NotificationForm
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-15T16:11:11.651Z")




public class NotificationForm   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("event")
  private String event = null;

  @JsonProperty("data")
  private Object data = null;

  public NotificationForm id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * my event id
   * @return id
  **/
  @ApiModelProperty(value = "my event id")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public NotificationForm event(String event) {
    this.event = event;
    return this;
  }

  /**
   * my event type
   * @return event
  **/
  @ApiModelProperty(value = "my event type")


  public String getEvent() {
    return event;
  }

  public void setEvent(String event) {
    this.event = event;
  }

  public NotificationForm data(Object data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")


  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotificationForm notificationForm = (NotificationForm) o;
    return Objects.equals(this.id, notificationForm.id) &&
        Objects.equals(this.event, notificationForm.event) &&
        Objects.equals(this.data, notificationForm.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, event, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificationForm {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

