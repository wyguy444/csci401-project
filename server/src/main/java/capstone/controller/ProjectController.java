package capstone.controller;



import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import capstone.model.Project;
import capstone.model.users.Stakeholder;
import capstone.model.users.Student;
import capstone.model.users.User;
import capstone.service.ProjectService;
import capstone.service.UserService;

@RestController
@RequestMapping("/projects")
public class ProjectController 
{
	@Autowired
	private ProjectService projectService;
	@Autowired
	private UserService userService;
	
	public ProjectController()
	{
	}
	
	@GetMapping("")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Project> getProjects()
	{
		return projectService.findAll();
	}	

	@PostMapping("/assignment")
	@CrossOrigin(origins = "http://localhost:3000")
	public String projectAssignment()
	{
		return projectService.runAlgorithm((Vector<Project>)getProjects(), (Vector<Student>)userService.getStudents());
	}
	
	@GetMapping("/{email:.+}")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Project> getProjectsByEmail(@PathVariable("email") String email) {
		Stakeholder user = userService.findStakeholderByEmail(email);
		List<Project> projects = userService.getStakeholderProjects(user);
		return projects;
	}
	
	@GetMapping("/{email:.+}/{projectId}")
	@CrossOrigin(origins = "http://localhost:3000")
	public Project getProjectByEmailAndId(@PathVariable("email") String email,
			@PathVariable("projectId") Long projectId) {
		Stakeholder user = userService.findStakeholderByEmail(email);
		List<Project> projects = userService.getStakeholderProjects(user);
		for (Project project : projects) {
			if (project.getProjectId() == projectId) {
				return project;
			}
		}
		return null;
	}
	
	@PostMapping("/save/{email:.+}")
	@CrossOrigin(origins = "http://localhost:3000")
	public @ResponseBody Project saveData(@PathVariable("email") String email, 
			@RequestBody Project project)
	{
		System.out.println("Received HTTP POST");
		System.out.println(project);
		System.out.println(project.getName());

	    projectService.save(project);
	    User user = userService.findUserByEmail(email);
	    userService.saveProject(user, project);
		return project; //new ResponseEntity<Boolean>(uiRequestProcessor.saveData(a),HttpStatus.OK);
	}
}

	

