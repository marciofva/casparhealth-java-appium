package com.casparhealth.dataprovider;

import java.util.HashMap;

public class LoginCredentials {
	
	public static HashMap<String, String> patientUser() {
		HashMap<String, String> map = new HashMap<String, String>();
		 map.put("emailOrId", "HLG7259");
		 map.put("password", "40981352");
		return map;
	}
}
