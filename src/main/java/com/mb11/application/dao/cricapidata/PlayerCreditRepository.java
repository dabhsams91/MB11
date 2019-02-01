package com.mb11.application.dao.cricapidata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb11.application.model.cricapidata.PlayerCredit;

@Repository
public interface PlayerCreditRepository extends JpaRepository<PlayerCredit, Long>{

}
