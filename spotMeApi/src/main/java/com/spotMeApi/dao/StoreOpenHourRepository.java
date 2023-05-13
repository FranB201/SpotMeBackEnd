package com.spotMeApi.dao;

import com.spotMeApi.entity.StoreOpenHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@RepositoryRestResource
@CrossOrigin
public interface StoreOpenHourRepository extends JpaRepository<StoreOpenHour, Long> {

    Optional<StoreOpenHour> findByName(String name);
    boolean existsByOpen(boolean open);
}
