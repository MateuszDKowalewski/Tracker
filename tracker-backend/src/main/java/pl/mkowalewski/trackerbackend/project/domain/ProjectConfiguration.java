package pl.mkowalewski.trackerbackend.project.domain;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ProjectConfiguration {

  @Bean
  ProjectFacade projectFacade() {
    ProjectRepository projectRepository = new ProjectRepository();
    ProjectMapper projectMapper = Mappers.getMapper(ProjectMapper.class);
    SaveProjectUseCase saveProjectUseCase = new SaveProjectUseCase(
        projectRepository,
        projectMapper
    );
    GetProjectUseCase getProjectUseCase = new GetProjectUseCase(
        projectRepository
    );
    return new ProjectFacade(
        getProjectUseCase,
        saveProjectUseCase,
        projectMapper
    );
  }

}
