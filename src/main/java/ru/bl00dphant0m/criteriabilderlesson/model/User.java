package ru.bl00dphant0m.criteriabilderlesson.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private int age;

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

}
