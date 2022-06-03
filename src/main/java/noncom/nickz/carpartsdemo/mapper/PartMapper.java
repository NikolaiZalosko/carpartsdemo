package noncom.nickz.carpartsdemo.mapper;

import noncom.nickz.carpartsdemo.dto.CreatePartDto;
import noncom.nickz.carpartsdemo.dto.SearchPartResponse;
import noncom.nickz.carpartsdemo.model.Part;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PartMapper {

  @Mapping(target = "found", ignore = true)
  SearchPartResponse toSearchResponseDto(Part source);

  Part toEntity(CreatePartDto dto);
}
