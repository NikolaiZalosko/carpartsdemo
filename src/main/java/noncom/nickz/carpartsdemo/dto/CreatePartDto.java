package noncom.nickz.carpartsdemo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class CreatePartDto {

  @NotBlank
  private String number;

  @NotBlank
  private String name;

  @Positive
  private float price;

  @Positive
  private float weight;
}
