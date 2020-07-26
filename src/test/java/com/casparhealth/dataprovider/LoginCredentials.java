package com.casparhealth.dataprovider;

import java.util.HashMap;

public class LoginCredentials {
	
	public static HashMap<String, String> patientUser() {
		HashMap<String, String> map = new HashMap<String, String>();
		 map.put("emailOrId", "HBNX8321");
		 map.put("password", "65479011");
		return map;
	}
}
