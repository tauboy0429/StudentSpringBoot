package com.example.springboot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.springboot.four.MD5;
import com.example.springboot.model.Student;
import com.example.springboot.repository.StudentRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.validation.Validator;
@Service
public class StudentService {
	@Autowired
	private StudentRepository sr;
	
	@Autowired
    private JavaMailSender mailSender;
	
	@Autowired
    private Validator validator;

	public List<Student> findAll() {
		return sr.findAll();
	}

	public void save(Student student) {
		MD5 md5 = new MD5();
		List<Student> list = new ArrayList<Student>();
		String paw = student.getSPWD();
		String newPassword = md5.md5Encrypt(paw);
		student.setSPWD(newPassword);
		sr.save(student);
	}

	public Student findByEmail(String email) {
		Student student = sr.findByEmail(email);
		return student;
	}

	public void deleteById(String sno) {
		sr.deleteById(sno);
	}

	public Map<String, String> login(String email, String pwd) {
		// 聲明map陣列
		Map<String, String> res = new HashMap<String, String>();
		MD5 md5=new MD5();
		Student student = sr.findByEmail(email);
		
		if (student!=null) {
			if (student.getSPWD().equals(md5.md5Encrypt(pwd))) {
				res.put("account", "success");
				res.put("login", "success");
			} else {
				res.put("account", "success");
				res.put("login", "fail");
			}
		} else {
			res.put("account", "fail");
			res.put("login", "fail");
		}

		return res;
	}

	public void sendEmail(String SMAIL, String SPWD) {
        try {
            // 創建郵件內容
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");

            helper.setFrom("poyu0036@gmail.com");
            helper.setTo(SMAIL);
            helper.setSubject("重設密碼通知");
            helper.setText("您的新密碼是: " + SPWD);

            // 發送郵件
            mailSender.send(message);
            System.out.println("郵件已發送到 " + SMAIL);

        } catch (MessagingException e) {
            throw new RuntimeException("郵件發送失敗: " + e.getMessage(), e);
        }
    }

	public String fakeInfo(int number1) {
		// 學號
		String number = String.format("%02d", number1);
		String fNO = "A" + number;
		
		return fNO;
	}

	public Map<String, String> registerStudent(Student student) {
		Map<String, String> registerRes = new HashMap<String, String>();
		List<Student> list = new ArrayList<Student>();

		// 1. 驗證 email 格式
		Pattern emailRegex = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");

		if (!isPatternMatch(student.getSMAIL(), emailRegex)) {
			registerRes.put("message", "mail格式錯誤");
			return registerRes;
		}

		Student foundStudents = sr.findByEmail(student.getSMAIL());

		if (foundStudents!=null) {
			registerRes.put("message", "sameAcount");
			registerRes.put("redirectUrl", "index");
			return registerRes;
		}
		String inf=sr.findMaxSNO();
		
		int num=Integer.valueOf(inf.replaceAll("\\D", ""));
		String fNO=fakeInfo(num+1);
		student.setSNO(fNO);
		
		MD5 md5=new MD5();
		student.setSPWD(md5.md5Encrypt(student.getSPWD()));

		Student savedStudent = sr.save(student);
		if (savedStudent != null && savedStudent.getSNO() != null) {
		    registerRes.put("message", "success");
		} else {
		    registerRes.put("message", "fail");
		}
		
		return registerRes;
	}

	private boolean isPatternMatch(String email, Pattern emailRegex) {
		return emailRegex.matcher(email).find();
	}
}
