package com.city.mode.service;

import com.city.mode.model.User;
import com.city.mode.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;
import java.util.Set;

@Service
public class UserService {

@Autowired
private UserRepository userRepository;

@Autowired
    private PasswordEncoder passwordEncoder;



public  void registerNewUser(String username, String password, Set<String> roles){
    User user=new User();

user.setUsername(username);
user.setPassword(passwordEncoder.encode(password));
user.setRoles(roles);
    userRepository.save(user);


}


}
