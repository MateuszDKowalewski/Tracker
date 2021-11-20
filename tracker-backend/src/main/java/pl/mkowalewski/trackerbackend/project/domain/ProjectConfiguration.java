package pl.mkowalewski.trackerbackend.project.domain;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ProjectConfiguration {

  @Bean
  ProjectFacade projectFacade() {
    ProjectRepository projectRepository = new ProjectRepository();
    GetProjectUseCase getProjectUseCase = new GetProjectUseCase(
        projectRepository
    );
    ProjectMapper projectMapper = Mappers.getMapper(ProjectMapper.class);
    return new ProjectFacade(
        getProjectUseCase,
        projectMapper
    );
  }

}
