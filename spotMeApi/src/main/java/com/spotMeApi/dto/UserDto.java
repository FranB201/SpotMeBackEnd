package com.spotMeApi.dto;

import com.spotMeApi.entity.Appointment;
import com.spotMeApi.entity.UserCategory;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    @UniqueElements(message = "Este correo ya existe")
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String phoneNumber;

//    private UserCategory userCategory;
//
//    private Set<Appointment> appointments;

    public UserDto(String name, String surname, String email, String password, String phoneNumber){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
