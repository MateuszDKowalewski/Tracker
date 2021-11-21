package pl.mkowalewski.trackerbackend.project.domain;

import lombok.AllArgsConstructor;
import pl.mkowalewski.trackerbackend.project.dto.ProjectCreateDto;
import pl.mkowalewski.trackerbackend.project.dto.ProjectUpdateDto;

@AllArgsConstructor
class SaveProjectUseCase {

  private final ProjectRepository projectRepository;
  private final ProjectMapper projectMapper;

  ProjectEntity createProject(ProjectCreateDto projectCreateDto) {
    // TODO: add validator
    ProjectEntity projectEntity = projectMapper.toEntity(projectCreateDto);
    return projectRepository.save(projectEntity);
  }

  public ProjectEntity updateProject(ProjectUpdateDto projectUpdateDto) {
    // TODO: add validator
    ProjectEntity projectEntity = projectMapper.toEntity(projectUpdateDto);
    return projectRepository.save(projectEntity);
  }
}
