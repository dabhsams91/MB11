package com.mb11.application.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mb11.application.model.user.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    Privilege findByName(String name);

    @Override
    void delete(Privilege privilege);

}
