package com.mb11.application.payload;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public class Login {
	
    @Email
    private String email;
    
    @DecimalMax(value = "10")
    private BigDecimal mobilenumber;

    @NotBlank
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public BigDecimal getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(BigDecimal mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
    
    
}
