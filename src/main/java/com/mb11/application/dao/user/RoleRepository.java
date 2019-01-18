package com.mb11.application.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mb11.application.model.user.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Override
    void delete(Role role);

}
