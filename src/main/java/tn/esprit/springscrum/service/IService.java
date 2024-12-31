package tn.esprit.springscrum.service;

import tn.esprit.springscrum.entity.Project;
import tn.esprit.springscrum.entity.Sprint;
import tn.esprit.springscrum.entity.User;

import java.util.List;

public interface IService {
    User addUser (User user);
    Project addProject (Project project);
    void assignProjectToDeveloper (int projectId, int devId);
    void assignProjectToScrumMaster(int projectId, String fName, String lName);
    List<Project> getProjectsByScrumMaster(String fName, String lName);
    void addSprintAndAssignToProject(Sprint sprint, int idProject);
    void getProjectsCurrentSprints();



}
