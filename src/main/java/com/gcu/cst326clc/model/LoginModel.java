package com.gcu.cst326clc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginModel {

    private int Id;

    @NotNull(message="User name is a required field")
    @Size(min=1, max=32, message="User name must be between 1 and 32 characters")
    private String username;

    @NotNull(message="Password is a required field")
    @Size(min=1, max=32, message="Password must be between 1 and 32 characters")
    private String password;

    public LoginModel() {
    	
    }
    
    public LoginModel(String username, String password) {
    	this.username = username;
    	this.password = password;
    }
    
    public LoginModel(int id, String username, String password)
	{
    	this.Id = id;
    	this.username = username;
    	this.password = password;
	}

	public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
