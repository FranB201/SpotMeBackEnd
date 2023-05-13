package com.spotMeApi.service;

import com.spotMeApi.dao.StoreRepository;
import com.spotMeApi.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StoreService {

    @Autowired
    StoreRepository storeRepository;

    public List<Store> list(){return storeRepository.findAll();}
    public Optional<Store> getOne(long id){return storeRepository.findById(id);}
    public Optional<Store> getByName(String name){return storeRepository.findByName(name);}
    public void save(Store store){storeRepository.save(store);}
    public void delete (long id){storeRepository.deleteById(id);}
    public boolean existById(long id){return storeRepository.existsById(id);}
    public boolean existByName(String name){return storeRepository.existsByName(name);}
}
