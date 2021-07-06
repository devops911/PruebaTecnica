package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DevOpsRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-05T23:36:27.329Z[GMT]")


public class DevOpsRequest   {
  @JsonProperty("message")
  private String message = null;

  @JsonProperty("to")
  private String to = null;

  @JsonProperty("from")
  private String from = null;

  @JsonProperty("timeToLifeSec")
  private Integer timeToLifeSec = null;

  public DevOpsRequest message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   **/
  @Schema(example = "This is a test", description = "")
  
    public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public DevOpsRequest to(String to) {
    this.to = to;
    return this;
  }

  /**
   * Get to
   * @return to
   **/
  @Schema(example = "Juan Perez", description = "")
  
    public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public DevOpsRequest from(String from) {
    this.from = from;
    return this;
  }

  /**
   * Get from
   * @return from
   **/
  @Schema(example = "Rita Asturia", description = "")
  
    public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public DevOpsRequest timeToLifeSec(Integer timeToLifeSec) {
    this.timeToLifeSec = timeToLifeSec;
    return this;
  }

  /**
   * Get timeToLifeSec
   * @return timeToLifeSec
   **/
  @Schema(example = "45", description = "")
  
    public Integer getTimeToLifeSec() {
    return timeToLifeSec;
  }

  public void setTimeToLifeSec(Integer timeToLifeSec) {
    this.timeToLifeSec = timeToLifeSec;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DevOpsRequest devOpsRequest = (DevOpsRequest) o;
    return Objects.equals(this.message, devOpsRequest.message) &&
        Objects.equals(this.to, devOpsRequest.to) &&
        Objects.equals(this.from, devOpsRequest.from) &&
        Objects.equals(this.timeToLifeSec, devOpsRequest.timeToLifeSec);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, to, from, timeToLifeSec);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DevOpsRequest {\n");
    
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    timeToLifeSec: ").append(toIndentedString(timeToLifeSec)).append("\n");
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
