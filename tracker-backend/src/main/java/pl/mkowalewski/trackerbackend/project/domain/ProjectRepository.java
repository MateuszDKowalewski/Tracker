package pl.mkowalewski.trackerbackend.project.domain;

import java.util.LinkedList;
import java.util.List;

class ProjectRepository {

  private List<ProjectEntity> entities;
  private Long nextId = 1L;

  List<ProjectEntity> getAll() {
    return entities;
  }

  public ProjectRepository() {
    entities = new LinkedList<>();
    entities.add(ProjectEntity.builder().id(nextId++).name("Projekt 1").build());
    entities.add(ProjectEntity.builder().id(nextId++).name("Projekt 2").build());
  }
}
