package pl.mkowalewski.trackerbackend.project.domain;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import pl.mkowalewski.trackerbackend.project.dto.ProjectCreateDto;
import pl.mkowalewski.trackerbackend.project.dto.ProjectResponseDto;
import pl.mkowalewski.trackerbackend.project.dto.ProjectUpdateDto;

@AllArgsConstructor
public class ProjectFacade {

  private final GetProjectUseCase getProjectUseCase;
  private final SaveProjectUseCase saveProjectUseCase;
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

  public ProjectResponseDto createProject(ProjectCreateDto projectCreateDto) {
    return projectMapper.toResponseDto(saveProjectUseCase.createProject(projectCreateDto));
  }

  public ProjectResponseDto updateProject(ProjectUpdateDto projectUpdateDto) {
    return projectMapper.toResponseDto(saveProjectUseCase.updateProject(projectUpdateDto));
  }
}
