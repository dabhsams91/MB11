package com.mb11.application.entitysport.converter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.mb11.application.model.user.User;

public class UserDataConverter {

	public void getUserModelFromUserPayload(com.mb11.application.payload.user.User payloadUser, User userModel) {

		userModel.setDob(Date.valueOf(payloadUser.getDob()));
		userModel.setFirstname(payloadUser.getFirstname());
		userModel.setImageUrl(payloadUser.getImageUrl());
		userModel.setLastname(payloadUser.getLastname());
		userModel.setMiddlename(payloadUser.getMiddlename());
		userModel.setName(payloadUser.getName());
		userModel.setProviderId(payloadUser.getProviderId());
		userModel.setUpdatetime(Timestamp.valueOf(LocalDateTime.now()));
	}

}
