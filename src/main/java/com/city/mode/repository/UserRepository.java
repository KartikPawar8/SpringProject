package com.city.mode.repository;


import com.city.mode.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

Optional<User>findByUsername(String userName);



}
