package com.example.springboot.four;

import java.util.Random;

public class Naming {
	String[] firstName= {"李","王","張","劉","陳","楊","黃","趙","周","吳",""
			+ "徐","孫","朱","馬","胡","郭","林","何","高","梁",""
			+ "鄭","羅","宋","謝","唐","韓","曹","許","鄧","蕭",""
			+ "馮","曾","程","蔡","彭","潘","袁","於","董","餘",""
			+ "蘇","葉","呂","魏","蔣","田","杜","丁","沈","姜",""
			+ "範","江","傅","鐘","盧","汪","戴","崔","任","陸",""
			+ "廖","姚","方","金","邱","夏","譚","韋","賈","鄒",""
			+ "石","熊","孟","秦","閻","薛","侯","雷","白","龍",""
			+ "段","郝","孔","邵","史","毛","常","萬","顧","賴",""
			+ "武","康","賀","嚴","尹","錢","施","牛","洪","龔",""
			+ "陳","林","黃","張","李","王","吳","劉","蔡","楊",""
			+ "許","鄭","謝","郭","洪","曾","邱","廖","賴","周",""
			+ "徐","蘇","葉","莊","呂","江","何","蕭","羅","高",""
			+ "簡","朱","鍾","施","游","詹","沈","彭","胡","余",""
			+ "盧","潘","顏","梁","趙","柯","翁","魏","方","孫",""
			+ "張簡","戴","范","歐陽","宋","鄧","杜","侯","曹","薛",""
			+ "傅","丁","溫","紀","范姜","蔣","歐","藍","連","唐",""
			+ "馬","董","石","卓","程","姚","康","馮","古","姜",""
			+ "湯","汪","白","田","涂","鄒","巫","尤","鐘","龔",""
			+ "嚴","韓","黎","阮","袁","童","陸","金","錢","邵"};
	String[] boyName= {"建宏","志明","俊傑","志豪","家豪","建銘","信宏","柏翰",
			"嘉宏","宇軒","威廷","建廷","柏宇","志偉","承翰","嘉豪","政宏","建宇",
			"偉誠","承恩","俊宏","宗翰","子豪","偉廷","宇豪","柏廷","俊宇","嘉銘",
			"志軒","明宏","家銘","承宇","子軒","志成","建翰","宗廷","家翰","承翰",
			"建豪","信宇","承銘","家宏","俊廷","柏翰","建銘","偉豪","志廷","承翰",
			"家誠","建翰","志翰","信翰","家成","俊翰","志宏","偉翰","家廷","宇翰",
			"宗翰","俊銘","嘉翰","柏豪","政廷","建誠","偉宇","志恩","柏誠","承豪",
			"家軒","宇廷","俊成","信廷","嘉成","明翰","信豪","子翰","俊恩","志廷",
			"建成","信成","俊軒","偉成","柏宇","志銘","嘉誠","信銘","俊誠","政翰",
			"承廷","嘉軒","明廷","政成","建軒","信翰","偉銘","政軒","志軒","子廷",
			"明成","明宇","俊豪","政豪","家恩","柏銘"};
	String[] girlName= {"怡君","雅婷","惠雯","雅雯","欣怡","佳穎","淑芬","佩玲",
			"靜怡","雅慧","淑娟","美玲","麗君","慧君","淑慧","婉婷","怡婷","珮琳",
			"雅欣","美娟","佳蓉","佳慧","婉如","詩涵","筱婷","雅涵","惠婷","佳琳",
			"佩雯","怡伶","佳芳","雅萍","秀玲","雅玲","靜雯","秀雯","淑貞","秀芬",
			"惠萍","珮君","宜芳","雅惠","佳君","淑華","雅芬","怡萱","筱雯","佩珊",
			"怡萍","淑君","慧萍","宜君","佩君","靜萍","佳芸","佩芸","婉君","筱君",
			"雅芸","雅君","思妤","佳萍","雅蓉","玉芬","美君","淑惠","美華","思涵",
			"美玲","淑芳","佩芬","嘉玲","佩穎","雅婷","怡芬","靜芳","筱萍","佳萱",
			"佩華","慧玲","珮芬","淑玲","淑萍","怡君","靜慧","宜玲","淑華","秀華",
			"惠玲","惠君","怡華","嘉雯","珮玲","佩華","靜君","惠華","慧芳","靜蓉",
			"宜雯","思蓉","雅玲","惠芬","佩玲","婉華","佳華","珮華"};
	
	Random random=new Random();
	int firstNameRan=random.nextInt(firstName.length);
	int boyNameRan=random.nextInt(boyName.length);
	int girlNameRan=random.nextInt(girlName.length);
	
	
	
	public String boyName() {
		StringBuilder sb=new StringBuilder("");
		sb.append(firstName[firstNameRan]);
		sb.append(boyName[boyNameRan]);
		String str=sb.toString();
		sb.setLength(0);
		
		return str;
	}
	
	public String girlName() {
		StringBuilder sb=new StringBuilder("");
		sb.append(firstName[firstNameRan]);
		sb.append(girlName[girlNameRan]);
		String str=sb.toString();
		sb.setLength(0);
		
		return str;
	}
	public static void main(String[] args) {
		Naming name=new Naming();
		System.out.print(name.boyName());
		System.out.print(name.girlName());
	}
}
