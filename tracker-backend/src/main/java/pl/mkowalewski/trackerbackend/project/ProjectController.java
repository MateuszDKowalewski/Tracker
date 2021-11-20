package pl.mkowalewski.trackerbackend.project;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mkowalewski.trackerbackend.project.domain.ProjectFacade;
import pl.mkowalewski.trackerbackend.project.dto.ProjectResponseDto;

@RestController
@RequestMapping("/project")
@AllArgsConstructor
class ProjectController {

  private final ProjectFacade projectFacade;

  @GetMapping(path = "/all")
  private ResponseEntity<List<ProjectResponseDto>> getAllProjects() {
    List<ProjectResponseDto> response = projectFacade.getAll();
    return ResponseEntity.ok(response);
  }

}
