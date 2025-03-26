package com.example.springboot.four;

import java.util.Calendar;
import java.util.Date;

public class BirthdayToAge {
	public int dateToAge(Date date) {
		Calendar birth = Calendar.getInstance();
        birth.setTime(date);
        
        // 當前日期
        Calendar today = Calendar.getInstance();
        
        // 計算年齡
        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        
        // 如果當前日期還沒過生日，年齡減 1
        if (today.get(Calendar.MONTH) < birth.get(Calendar.MONTH) || 
            (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH) && today.get(Calendar.DAY_OF_MONTH) < birth.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }
        
        return age;
	}
}
