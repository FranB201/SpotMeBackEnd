package com.spotMeApi.dao;

import com.spotMeApi.entity.UserCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@RepositoryRestResource
@CrossOrigin
public interface UserCategoryRepository extends JpaRepository<UserCategory, Long> {

    Optional<UserCategory> findByName(String name);
    boolean existsByName(String name);

}
