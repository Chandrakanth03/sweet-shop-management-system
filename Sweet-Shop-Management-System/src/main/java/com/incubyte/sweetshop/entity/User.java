package com.incubyte.sweetshop.entity;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(unique = true, nullable = false)
    private String username;

    @Setter
    @Column(nullable = false)
    private String password;

    public Long getId() { return id; }

    public String getUsername() { return username; }

    public String getPassword() { return password; }
}
