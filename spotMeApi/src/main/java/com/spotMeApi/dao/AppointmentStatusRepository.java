package com.spotMeApi.dao;

import com.spotMeApi.entity.Appointment;
import com.spotMeApi.entity.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@RepositoryRestResource
@CrossOrigin
public interface AppointmentStatusRepository extends JpaRepository<AppointmentStatus, Long> {

    Optional<AppointmentStatus> findByName(String name);
}
