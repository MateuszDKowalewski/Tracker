package pl.mkowalewski.trackerbackend.project.domain;

import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class GetProjectUseCase {

  private final ProjectRepository projectRepository;

  List<ProjectEntity> getAll() {
    return projectRepository.getAll();
  }

  public ProjectEntity getById(Long id) {
    return projectRepository.getById(id);
  }
}
