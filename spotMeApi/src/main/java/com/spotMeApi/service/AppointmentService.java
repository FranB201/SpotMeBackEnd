package com.spotMeApi.service;

import com.spotMeApi.dao.AppointmentRepository;
import com.spotMeApi.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    public List<Appointment> list(){return appointmentRepository.findAll();}
    public Optional<Appointment> getOne(long id){return appointmentRepository.findById(id);}
    public Optional<Appointment> getByDate(LocalDateTime date){return appointmentRepository.findByDate(date);}
    public void save(Appointment appointment){appointmentRepository.save(appointment);}
    public void delete (long id){appointmentRepository.deleteById(id);}
    public boolean existById(long id){return appointmentRepository.existsById(id);}
}
