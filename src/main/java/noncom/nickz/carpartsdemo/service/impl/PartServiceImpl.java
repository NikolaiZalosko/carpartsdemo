package noncom.nickz.carpartsdemo.service.impl;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.RequiredArgsConstructor;
import noncom.nickz.carpartsdemo.dto.CreatePartDto;
import noncom.nickz.carpartsdemo.dto.SearchPartResponse;
import noncom.nickz.carpartsdemo.dto.SearchPartsRequest;
import noncom.nickz.carpartsdemo.exception.DuplicateRequestException;
import noncom.nickz.carpartsdemo.mapper.PartMapper;
import noncom.nickz.carpartsdemo.model.Part;
import noncom.nickz.carpartsdemo.repository.PartRepository;
import noncom.nickz.carpartsdemo.service.PartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PartServiceImpl implements PartService {

  private final PartRepository partRepository;
  private final PartMapper partMapper;

  @Override
  public List<Part> getParts() {
    return partRepository.findAll();
  }

  @Override
  public List<Part> createParts(List<CreatePartDto> parts) {
    List<Part> existingParts = partRepository.findByNumberIn(parts.stream()
        .map(CreatePartDto::getNumber)
        .collect(Collectors.toList()));
    if (!existingParts.isEmpty()) {
      List<String> existingNumbers = existingParts.stream()
          .map(Part::getNumber)
          .collect(Collectors.toList());
      throw new DuplicateRequestException("Parts with these numbers already exist: " + existingNumbers);
    }

    List<Part> partsToSave = parts.stream()
        .map(dto -> {
          Part part = partMapper.toEntity(dto);
          part.setId(Uuids.timeBased());
          return part;
        })
        .collect(Collectors.toList());
    return partRepository.saveAll(partsToSave);
  }

  @Override
  public List<SearchPartResponse> searchParts(SearchPartsRequest search) {
    List<Part> foundParts = partRepository.findByNumberIn(search.getPartNumbers());
    List<String> foundNumbers = foundParts.stream()
        .map(Part::getNumber)
        .collect(Collectors.toList());
    List<SearchPartResponse> result =  foundParts.stream()
        .map(part -> {
          SearchPartResponse dto = partMapper.toSearchResponseDto(part);
          dto.setFound(true);
          return dto;
        })
        .collect(Collectors.toList());

    List<String> notFoundNumbers = search.getPartNumbers().stream()
        .filter(number -> !foundNumbers.contains(number))
        .collect(Collectors.toList());
    notFoundNumbers.forEach(number -> result.add(SearchPartResponse.builder().number(number).found(false).build()));

    return result;
  }

  @Override
  public void deleteParts(SearchPartsRequest request) {
    partRepository.deleteAllByNumberIn(request.getPartNumbers());
  }
}
