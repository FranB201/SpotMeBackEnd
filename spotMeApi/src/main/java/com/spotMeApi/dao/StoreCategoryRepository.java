package com.spotMeApi.dao;

import com.spotMeApi.entity.StoreCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@RepositoryRestResource
@CrossOrigin
public interface StoreCategoryRepository extends JpaRepository<StoreCategory, Long> {
    Optional<StoreCategory> findByName(String name);
    boolean existsByName(String name);
}
