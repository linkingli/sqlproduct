package utils;

import java.util.UUID;

public class UUIDUtils {

	public UUIDUtils() {
		// TODO Auto-generated constructor stub
	}
	public static String getUUID(){
		
		 String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		
		return uuid;
	}
	
	public static void main(String[] args) {
		String uuid = getUUID();
		System.out.println(uuid);
	}
	

}
