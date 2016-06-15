package com.github.kastyan.phonebook.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;





public class DigestPassword {
	
	
	
	public String digestPass(String password) throws NoSuchAlgorithmException{
		 
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		 md.update(password.getBytes());
		 byte byteData[] = md.digest();
		 StringBuilder sb = new StringBuilder();
		    for (byte b : byteData) {
		        sb.append(String.format("%02X ", b));
		    }
		 String digestedPassword = sb.toString();
		return digestedPassword;
	}

}
