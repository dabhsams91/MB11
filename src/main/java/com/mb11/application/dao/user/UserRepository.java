package com.mb11.application.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mb11.application.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    
    User findByMobilenumber(String mobilenumber);

    @Override
    void delete(User user);

}
