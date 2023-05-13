package com.spotMeApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;


    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "userCategory_id")
    private UserCategory userCategory;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonBackReference
    private Set<Appointment> appointments;

    public User(String name, String surname, String password, String phoneNumber) {

    }
}
