package tn.esprit.springscrum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springscrum.entity.Role;
import tn.esprit.springscrum.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByFNameAndLNameAndRole(String fName, String lName , Role role);

}
