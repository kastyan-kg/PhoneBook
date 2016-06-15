package com.github.kastyan.phonebook.classes;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ScopedProxyMode;

@Component
@Scope(value = "session",  proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User {
	private String name = "guest" ;
	private int userID;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    public int getUserId() {
		return userID;
	}

	public void setUserId(int userId) {
		this.userID = userId;
	}


    
}
