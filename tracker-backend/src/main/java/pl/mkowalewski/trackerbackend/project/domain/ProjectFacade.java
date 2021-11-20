package pl.mkowalewski.trackerbackend.project.domain;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import pl.mkowalewski.trackerbackend.project.dto.ProjectResponseDto;

@AllArgsConstructor
public class ProjectFacade {

  private final GetProjectUseCase getProjectUseCase;
  private final ProjectMapper projectMapper;

  public ProjectResponseDto getById(Long id) {
    return projectMapper.toResponseDto(getProjectUseCase.getById(id));
  }

  public List<ProjectResponseDto> getAll() {
    return getProjectUseCase.getAll()
        .stream()
        .map(projectMapper::toResponseDto)
        .collect(Collectors.toList());
  }
}
