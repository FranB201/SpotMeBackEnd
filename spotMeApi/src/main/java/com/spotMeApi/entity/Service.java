package com.spotMeApi.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serviceId")
    private Long serviceId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;




    @ManyToMany(mappedBy = "services")
    private Set<Store> stores = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "service")
    @JsonIgnore
    private Set<Appointment> appointments;



}
