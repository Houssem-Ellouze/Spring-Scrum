package tn.esprit.springscrum.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.springscrum.entity.Project;
import tn.esprit.springscrum.entity.Role;
import tn.esprit.springscrum.entity.Sprint;
import tn.esprit.springscrum.entity.User;
import tn.esprit.springscrum.repository.ProjectRepository;
import tn.esprit.springscrum.repository.SprintRepository;
import tn.esprit.springscrum.repository.UserRepository;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ServiceImpl implements IService{

    private ProjectRepository projectRepository;
    private SprintRepository sprintRepository;
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    public void assignProjectToDeveloper(int projectId, int devId) {
        Project p = projectRepository.findById(projectId).orElse(null);
        User userDeveloper = userRepository.findById(devId).orElse(null);
        userDeveloper.getProjects ().add(p);
        userRepository.save(userDeveloper);
    }

    public void assignProjectToScrumMaster(int projectId, String fName, String lName) {
        Project p = projectRepository.findById(projectId).orElse(null);
        User scrum = (User) userRepository.findByFNameAndLNameAndRole ( fName, lName , Role.SCRUM_MASTER);
        scrum.getProjects ().add(p);
        userRepository.save(scrum);
    }


    public List<Project> getProjectsByScrumMaster(String fName, String lName) {
        User scrummaster= (User) userRepository.findByFNameAndLNameAndRole ( fName , lName , Role.SCRUM_MASTER);
        return scrummaster.getProjectList ();
    }

    public void addSprintAndAssignToProject(Sprint sprint, int idProject) {
        Project project = projectRepository.findById(idProject).orElse(null);
        sprintRepository.save(sprint);
    }

    @Scheduled(cron = "*/30 * * * * *")
    public void getProjectsCurrentSprints() {
        List<Project> projects = projectRepository.findAll();
        for (Project project : projects) {
            for (Sprint sprint : sprintRepository.findAll()) {
                if (sprint.getStartDate ().before (new Date ())) {
                    log.info ( project.getTitle () );
                }

            }
        }

    }


}
