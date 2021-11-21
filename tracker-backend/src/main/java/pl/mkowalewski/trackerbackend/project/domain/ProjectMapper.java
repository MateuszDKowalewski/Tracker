package pl.mkowalewski.trackerbackend.project.domain;

import org.mapstruct.Mapper;
import pl.mkowalewski.trackerbackend.project.dto.ProjectCreateDto;
import pl.mkowalewski.trackerbackend.project.dto.ProjectResponseDto;
import pl.mkowalewski.trackerbackend.project.dto.ProjectUpdateDto;

@Mapper
abstract class ProjectMapper {

  abstract ProjectResponseDto toResponseDto(ProjectEntity entity);

  abstract ProjectEntity toEntity(ProjectCreateDto createDto);

  abstract ProjectEntity toEntity(ProjectUpdateDto projectUpdateDto);
}
