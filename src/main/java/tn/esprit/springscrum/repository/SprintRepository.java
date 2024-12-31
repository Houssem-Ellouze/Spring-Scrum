package tn.esprit.springscrum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springscrum.entity.Sprint;

public interface SprintRepository extends JpaRepository<Sprint, Integer> {
}
