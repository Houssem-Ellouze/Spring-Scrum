package tn.esprit.springscrum.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.springscrum.entity.Project;
import tn.esprit.springscrum.entity.Sprint;
import tn.esprit.springscrum.entity.User;
import tn.esprit.springscrum.service.IService;

import java.util.List;

@RestController
@RequestMapping("/ctrl")
public class ScrumController {
    private IService service;

    @PostMapping("/addUser")
    public User addUser (@RequestBody User user){
        return service.addUser(user);
    }
    @PostMapping("/addProject")
    public Project addProject (@RequestBody Project project){
        return service.addProject(project);
    }
    @PostMapping("/assignProjectToDeveloper/{projet-id}/{dev-id}")
    public void assignProjectToDeveloper (@PathVariable("projet-id") int projectId,@PathVariable("dev-id") int devId){
        service.assignProjectToDeveloper(projectId, devId);
    }
    @PostMapping("/assignProjectToScrumMaster/{projet-id}")
    public void assignProjectToScrumMaster(@PathVariable("projet-id") int projectId,@RequestBody String fName,@RequestBody String lName){
        service.assignProjectToScrumMaster(projectId, fName, lName);
    }
    @GetMapping("/getProjectsByScrumMaster")
    public List<Project> getProjectsByScrumMaster(@RequestBody String fName,@RequestBody String lName){
        return service.getProjectsByScrumMaster(fName, lName);
    }
    @PostMapping("/addSprintAndAssignToProject/{id-project}")
    public void addSprintAndAssignToProject(@RequestBody Sprint sprint, @PathVariable("id-project") int idProject){
        service.addSprintAndAssignToProject(sprint, idProject);
    }
    @GetMapping("/getProjectsCurrentSprints")
    public void getProjectsCurrentSprints(){
        service.getProjectsCurrentSprints();
    }



}
