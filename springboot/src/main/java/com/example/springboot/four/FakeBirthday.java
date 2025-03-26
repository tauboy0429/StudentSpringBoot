package com.example.springboot.four;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class FakeBirthday {
	public Date fakeAge() {
		Random random=new Random();
		Calendar startDate = Calendar.getInstance();
        startDate.set(1925, Calendar.JANUARY, 1); // 設定起始日期為 2000 年 1 月 1 日
        
        Calendar endDate = Calendar.getInstance();
        
        // 計算起始和結束日期之間的毫秒差
        long startMillis = startDate.getTimeInMillis();
        long endMillis = endDate.getTimeInMillis();
        
        // 隨機生成毫秒數
        long randomMillis = startMillis + (long) (random.nextDouble() * (endMillis - startMillis));
        
        // 根據隨機的毫秒數創建一個新的 Date 物件
        Date randomDate = new Date(randomMillis);
        
        return randomDate;
	}
}
