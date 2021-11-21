package pl.mkowalewski.trackerbackend.project.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class SaveProjectUseCase {

  private final ProjectRepository projectRepository;
  private final ProjectMapper projectMapper;

  ProjectEntity createProject(ProjectCreateDto projectCreateDto) {
    // TODO: add validator
    ProjectEntity projectEntity = projectMapper.toEntity(projectCreateDto);
    return projectRepository.save(projectEntity);
  }
}
