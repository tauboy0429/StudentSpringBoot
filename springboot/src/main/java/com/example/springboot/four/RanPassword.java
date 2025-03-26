package com.example.springboot.four;

import java.util.Random;

public class RanPassword {
	public String randomPassword() {
		Random random=new Random();
		String charPoll="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String charPoll1="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String charPoll2="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
		int charLength=random.nextInt(4)+4;
		int charLength1=random.nextInt(4)+4;
		int charLength2=random.nextInt(4);
		String password="";
		
		for(int i=0;i<charLength;i++) {
			int ranPoll=random.nextInt(charPoll.length());
			password+=charPoll.charAt(ranPoll);
		}
		for(int i=0;i<charLength1;i++) {
			int ranPoll=random.nextInt(charPoll1.length());
			password+=charPoll1.charAt(ranPoll);
		}
		for(int i=0;i<charLength2;i++) {
			int ranPoll=random.nextInt(charPoll2.length());
			password+=charPoll2.charAt(ranPoll);
		}
		return password;
	}
	public static void main(String[] args) {
		RanPassword rp=new RanPassword();
		System.out.print(rp.randomPassword());
	}
}
