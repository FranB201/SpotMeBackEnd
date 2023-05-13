package com.spotMeApi.controller;

import com.spotMeApi.dto.Mensaje;
import com.spotMeApi.dto.UserDto;
import com.spotMeApi.entity.User;

import com.spotMeApi.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public ResponseEntity<List<User>> List(){
        List<User> list = userService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/details/", params = {"id"})
    public ResponseEntity<?> getById(@PathVariable("id") long id){
        if(!userService.existById(id)) return new ResponseEntity<>(new Mensaje("No existe el user con ese id."), HttpStatus.NOT_FOUND);
        if(userService.getOne(id).isPresent()){
            User user = userService.getOne(id).get();
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> create(@RequestBody UserDto userDto){
        if(StringUtils.isBlank(userDto.getName()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio."), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(userDto.getSurname()))
            return new ResponseEntity<>(new Mensaje("El apellido es obligatorio."), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(userDto.getPassword()))
            return new ResponseEntity<>(new Mensaje("La contraseña es obligatoria."), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(userDto.getPhoneNumber()))
            return new ResponseEntity<>(new Mensaje("El teléfono es obligatorio."), HttpStatus.NOT_FOUND);
        if(userService.existByEmail(userDto.getEmail()))
            return new ResponseEntity<>(new Mensaje("Ya existe un usuario con ese email."), HttpStatus.BAD_REQUEST);

        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());

        userService.save(user);
        return new ResponseEntity<>(new Mensaje("Usuario creado satisfactoriamente."), HttpStatus.OK);



    }
}
