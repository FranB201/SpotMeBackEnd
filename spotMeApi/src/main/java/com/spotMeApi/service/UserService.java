package com.spotMeApi.service;

import com.spotMeApi.dao.UserRepository;
import com.spotMeApi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> list(){return userRepository.findAll();}
    public Optional<User> getOne(long id){return userRepository.findById(id);}
    public Optional<User> getByName(String name){return userRepository.findByName(name);}
    public void save(User user){userRepository.save(user);}
    public void delete (long id){userRepository.deleteById(id);}
    public boolean existById(long id){return userRepository.existsById(id);}
    public boolean existByName(String name){return userRepository.existsByName(name);}
    public boolean existByEmail(String email){return userRepository.existsByName(email);}

}
