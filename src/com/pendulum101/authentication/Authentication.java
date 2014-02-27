package com.pendulum101.authentication;


public class Authentication {
	private static final String user = "pendulum101";
	private static final String correctHash = "1000:404bff9163a7b9d9f536d7e8180b7ef526538d0c1001eed6:911a3efba25f1561c4a28ebbc5a5c768078984a1de5732b9";

	public static boolean authenticateUser(String username, String password){
		try {
			return username.equals(user) && PasswordHash.validatePassword(password, correctHash);
			//				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
