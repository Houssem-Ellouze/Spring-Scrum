package tn.esprit.springscrum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springscrum.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
