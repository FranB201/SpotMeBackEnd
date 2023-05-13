package com.spotMeApi.dao;

import com.spotMeApi.entity.Service;
import com.spotMeApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@RepositoryRestResource
@CrossOrigin // faltaria añadir el origen del front para seguridad (origins = {"https://localhost:/4200"})
public interface ServiceRepository extends JpaRepository<Service, Long> {

    Optional<Service> findByName(String Name);
    boolean existsByName(String name);

}
