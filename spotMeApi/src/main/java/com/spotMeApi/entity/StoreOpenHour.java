package com.spotMeApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "storeOpenHour")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreOpenHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storeOpenHourId")
    private Long storeOpenHourId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "openTime", nullable = false)
    private LocalTime openTime;

    @Column(name = "closeTime", nullable = false)
    private LocalTime closeTime;

    @Column(name = "open")
    private boolean open;

    @Column(name = "breakStart")
    private LocalTime breakStart;

    @Column(name = "breakEnd")
    private LocalTime breakEnd;


    @ManyToMany(mappedBy = "storeOpenHours")
    private Set<Store> stores = new HashSet<>();
}
