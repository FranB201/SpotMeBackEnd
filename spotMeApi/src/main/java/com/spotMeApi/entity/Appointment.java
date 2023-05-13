package com.spotMeApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "appointment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointmentId")
    private Long appointmentId;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "reservationDate", nullable = false)
    private LocalDateTime reservationDate;

    @Column(name = "cancelDate")
    private LocalDateTime cancelDate;


    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;


    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "appointmentStatus_id", nullable = false)
    private AppointmentStatus appointmentStatus;
}
