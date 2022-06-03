package noncom.nickz.carpartsdemo.service;

import noncom.nickz.carpartsdemo.dto.CreatePartDto;
import noncom.nickz.carpartsdemo.dto.SearchPartResponse;
import noncom.nickz.carpartsdemo.dto.SearchPartsRequest;
import noncom.nickz.carpartsdemo.model.Part;

import java.util.List;

public interface PartService {

  List<Part> getParts();

  List<Part> createParts(List<CreatePartDto> parts);

  List<SearchPartResponse> searchParts(SearchPartsRequest search);

  void deleteParts(SearchPartsRequest request);
}
