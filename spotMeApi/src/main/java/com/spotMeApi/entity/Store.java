package com.spotMeApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "store")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storeId")
    private Long storeId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Store_StoreOpenHour",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "storeOpenHour_id")
    )
    private Set<StoreOpenHour> storeOpenHours = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Store_Service",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Set<Service> services = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store")
    @JsonIgnore
    private Set<Appointment> appointments;

    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "storeCategory_id", nullable = false)
    private StoreCategory storeCategory;

}
