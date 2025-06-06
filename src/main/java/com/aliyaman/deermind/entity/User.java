package com.aliyaman.deermind.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name" , unique = true)
    private String username;

    @Column(name = "mail" , unique = true)
    private String email;

    @Column(name = "password")
    private String password;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Note> notes = new ArrayList<>();

}
