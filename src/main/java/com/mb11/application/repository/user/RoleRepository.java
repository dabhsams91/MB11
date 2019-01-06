package com.mb11.application.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb11.application.model.user.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long>{

}
