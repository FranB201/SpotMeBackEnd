package com.spotMeApi.dto;
import com.spotMeApi.entity.AppointmentStatus;
import com.spotMeApi.entity.Service;
import com.spotMeApi.entity.Store;
import com.spotMeApi.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
public class AppointmentDto {

    @NotBlank

    private LocalDateTime date;
    @NotBlank

    private LocalDateTime reservationDate;

    private LocalDateTime cancelDate;

    private User user;
    private Service service;
    private Store store;
    private AppointmentStatus appointmentStatus;

    public AppointmentDto(LocalDateTime date, LocalDateTime reservationDate, LocalDateTime cancelDate){
        this.date = date;
        this.reservationDate = reservationDate;
        this.cancelDate = cancelDate;
    }
}
