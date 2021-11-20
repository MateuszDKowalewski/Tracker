package pl.mkowalewski.trackerbackend.project.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class ProjectRepository {

  private Map<Long, ProjectEntity> entities;
  private Long nextId = 1L;

  public ProjectEntity getById(Long id) {
    return entities.get(id);
  }

  List<ProjectEntity> getAll() {
    return entities.values()
        .stream()
        .collect(Collectors.toList());
  }

  public ProjectRepository() {
    entities = Map.of(
        nextId, ProjectEntity.builder().id(nextId++).name("Projekt 1").build(),
        nextId, ProjectEntity.builder().id(nextId++).name("Projekt 2").build()
    );
  }
}
