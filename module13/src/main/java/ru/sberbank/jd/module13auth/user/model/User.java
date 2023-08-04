package ru.sberbank.jd.module13auth.user.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "auth_user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String password;
    private String fullName;
    @ManyToMany
    private List<Role> roles;
}
