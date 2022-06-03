package noncom.nickz.carpartsdemo.controller;

import lombok.RequiredArgsConstructor;
import noncom.nickz.carpartsdemo.dto.CreatePartDto;
import noncom.nickz.carpartsdemo.dto.SearchPartResponse;
import noncom.nickz.carpartsdemo.dto.SearchPartsRequest;
import noncom.nickz.carpartsdemo.model.Part;
import noncom.nickz.carpartsdemo.service.PartService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/parts")
@RequiredArgsConstructor
public class PartController {

  private final PartService partService;

  @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public List<Part> createParts(@RequestBody @Valid List<CreatePartDto> parts) {
    return partService.createParts(parts);
  }

  @GetMapping
  public List<Part> getParts() {
    return partService.getParts();
  }

  @PostMapping(value = "/search", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public List<SearchPartResponse> searchParts(@RequestBody SearchPartsRequest search) {
    return partService.searchParts(search);
  }

  @DeleteMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public void deleteParts(@RequestBody SearchPartsRequest request) {
    partService.deleteParts(request);
  }
}
