package com.mb11.application.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb11.application.model.User;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);
    
    Optional<User> findByMobilenumber(BigDecimal mobilenumber);
    
    Boolean existsByMobilenumber(BigDecimal mobilenumber); 
    
}
