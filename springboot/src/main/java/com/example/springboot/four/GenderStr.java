package com.example.springboot.four;

public class GenderStr {
	public String genderString(int gender) {
		if(gender==1){
			return "男";
		}else if(gender==0){
			return "女";
		}
		else
			return "其他";
	}
}
