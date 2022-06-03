package noncom.nickz.carpartsdemo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchPartResponse {

  private String number;
  private String name;
  @JsonProperty("status")
  private boolean found;
  private Float price;
  private Float weight;
}
