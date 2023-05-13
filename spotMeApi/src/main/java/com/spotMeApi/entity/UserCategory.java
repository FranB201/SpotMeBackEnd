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
@Table(name = "userCategory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userCategoryId")
    private Long userCategoryId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userCategory")
    @JsonBackReference
    private Set<User> users;
}
