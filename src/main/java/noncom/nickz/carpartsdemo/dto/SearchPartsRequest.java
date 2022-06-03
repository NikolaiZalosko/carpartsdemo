package noncom.nickz.carpartsdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class SearchPartsRequest {

  @JsonProperty("parts")
  private List<String> partNumbers;
}
