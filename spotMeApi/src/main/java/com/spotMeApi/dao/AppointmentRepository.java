package com.spotMeApi.dao;

import com.spotMeApi.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;
import java.util.Optional;

@RepositoryRestResource
@CrossOrigin
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findByDate(LocalDateTime date);

}
