package pl.mkowalewski.trackerbackend.project.domain;

import org.mapstruct.Mapper;
import pl.mkowalewski.trackerbackend.project.dto.ProjectResponseDto;

@Mapper
abstract class ProjectMapper {

  abstract ProjectResponseDto toResponseDto(ProjectEntity entity);

}
