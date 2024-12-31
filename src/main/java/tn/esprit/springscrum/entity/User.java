package tn.esprit.springscrum.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String pwd;
    private String fName;
    private String lName;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany
    List<Project> projects;
    @ManyToMany(mappedBy = "users")
    List<Project> projectList;
}
