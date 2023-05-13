package com.spotMeApi.controller;

import com.spotMeApi.dto.Mensaje;
import com.spotMeApi.dto.StoreDto;
import com.spotMeApi.dto.UserDto;
import com.spotMeApi.entity.Store;
import com.spotMeApi.entity.User;
import com.spotMeApi.service.StoreService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store")
public class StoreController {

    @Autowired
    StoreService storeService;


    @GetMapping("/list")
    public ResponseEntity<List<Store>> List() {
        List<Store> list = storeService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/details/", params = {"id"})
    public ResponseEntity<?> getById(@PathVariable("id") long id) {
        if (!storeService.existById(id))
            return new ResponseEntity<>(new Mensaje("No existe el centro con ese id."), HttpStatus.NOT_FOUND);
        if (storeService.getOne(id).isPresent()) {
            Store store = storeService.getOne(id).get();
            return new ResponseEntity<>(store, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
    }


    @PostMapping("/insert")
    public ResponseEntity<?> create(@RequestBody StoreDto storeDto) {
        if (StringUtils.isBlank(storeDto.getName()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio."), HttpStatus.NOT_FOUND);
        if (StringUtils.isBlank(storeDto.getDescription()))
            return new ResponseEntity<>(new Mensaje("La descripción es obligatoria."), HttpStatus.NOT_FOUND);
        if (StringUtils.isBlank(storeDto.getEmail()))
            return new ResponseEntity<>(new Mensaje("El email es obligatorio."), HttpStatus.NOT_FOUND);
        if (StringUtils.isBlank(storeDto.getPhoneNumber()))
            return new ResponseEntity<>(new Mensaje("El teléfono es obligatorio."), HttpStatus.NOT_FOUND);
        if (StringUtils.isBlank(storeDto.getAddress()))
            return new ResponseEntity<>(new Mensaje("La dirección es obligatoria."), HttpStatus.NOT_FOUND);
        if (storeService.existByName(storeDto.getName()))
            return new ResponseEntity<>(new Mensaje("Ya existe un centro con este nombre."), HttpStatus.BAD_REQUEST);

        Store store = new Store();
        store.setName(storeDto.getName());
        store.setDescription(storeDto.getDescription());
        store.setEmail(storeDto.getEmail());
        store.setPhoneNumber(storeDto.getPhoneNumber());
        store.setAddress(storeDto.getAddress());

        storeService.save(store);
        return new ResponseEntity<>(new Mensaje("Centro creado satisfactoriamente."), HttpStatus.OK);

    }

}
