package pl.mkowalewski.trackerbackend.project;

import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mkowalewski.trackerbackend.project.dto.ProjectCreateDto;
import pl.mkowalewski.trackerbackend.project.domain.ProjectFacade;
import pl.mkowalewski.trackerbackend.project.dto.ProjectResponseDto;
import pl.mkowalewski.trackerbackend.project.dto.ProjectUpdateDto;

@RestController
@RequestMapping("/project")
@AllArgsConstructor
class ProjectController {

  private final ProjectFacade projectFacade;

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  private ResponseEntity<ProjectResponseDto> getProjectById(@PathVariable Long id) {
    ProjectResponseDto response = projectFacade.getById(id);
    return ResponseEntity.ok(response);
  }

  @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
  private ResponseEntity<List<ProjectResponseDto>> getAllProjects() {
    List<ProjectResponseDto> response = projectFacade.getAll();
    return ResponseEntity.ok(response);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  private ResponseEntity<ProjectResponseDto> createProject(
      @RequestBody @Valid  ProjectCreateDto projectCreateDto
  ) {
    ProjectResponseDto response = projectFacade.createProject(projectCreateDto);
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(response);
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  private ResponseEntity<ProjectResponseDto> updateProject(
      @RequestBody @Valid ProjectUpdateDto projectUpdateDto
  ) {
    ProjectResponseDto response = projectFacade.updateProject(projectUpdateDto);
    return ResponseEntity.ok(response);
  }

}
