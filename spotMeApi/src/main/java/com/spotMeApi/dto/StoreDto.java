package com.spotMeApi.dto;

import com.spotMeApi.entity.Appointment;
import com.spotMeApi.entity.Service;
import com.spotMeApi.entity.StoreCategory;
import com.spotMeApi.entity.StoreOpenHour;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class StoreDto {
    @NotBlank

    private String name;
    @NotBlank
    private String description;
    @NotBlank
    @UniqueElements(message = "Este correo ya existe")
    private String email;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String address;



    private Set<StoreOpenHour> storeOpenHours = new HashSet<>();

    private Set<Service> services = new HashSet<>();

   // private Set<Appointment> appointments;

    private StoreCategory storeCategory;

    public StoreDto(String name, String description, String email, String phoneNumber, String address){
        this.name = name;
        this.description = description;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
