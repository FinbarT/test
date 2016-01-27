package Util;

public class GitUser {
	
	private static String username = System.getenv("USERNAME");
	private static String password = System.getenv("PASSWORD");
	
	public static String getUsername(){
		return username;
	}
	
	public static String getPassword(){
		return password;
	}
}
