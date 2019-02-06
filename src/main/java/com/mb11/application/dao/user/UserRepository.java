package com.mb11.application.dao.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb11.application.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
    
	Optional<User> findByMobilenumber(String mobilenumber);
    
    Boolean existsByEmail(String email);
    @Override
    void delete(User user);

}
