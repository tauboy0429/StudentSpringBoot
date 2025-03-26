package com.example.springboot.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.springboot.four.MD5;
import com.example.springboot.four.RanPassword;
import com.example.springboot.model.Student;
import com.example.springboot.service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class StudentController {
	@Autowired
	StudentService ssi;

	@PostMapping(value = "/register", produces = "application/json")
	@ResponseBody
	public Map<String, String> register(@RequestBody Map<String, String> requestBody) {Map<String, String> loginRes = new HashMap<>();
		loginRes.put("redirectUrl", "http://localhost:3000/register");
		return loginRes;
	}
	
	@PostMapping(value = "/information", produces = "application/json")
	@ResponseBody
	public Map<String, String> information(@RequestBody Map<String, String> requestBody) {
		String sname=requestBody.get("sname");
		String sbday=requestBody.get("sbday");
		String ssex=requestBody.get("ssex");
		String smail=requestBody.get("smail");
		String spwd=requestBody.get("spwd");
		
		Map<String, String> loginRes = new HashMap<>();
		
		Student student=new Student();
		student.setSNAME(sname);
		student.setSBDAY(Date.valueOf(sbday));
		student.setSSEX(Integer.valueOf(ssex));
		student.setSMAIL(smail);
		student.setSPWD(spwd);
		
		Map<String, String> res = new HashMap<>();
		res=ssi.registerStudent(student);
		
		if("success".equals(res.get("message"))) {
			loginRes.put("message", "success");
			loginRes.put("redirectUrl", "http://localhost:3000/login");
		}else {
			loginRes=res;
		}
		return loginRes;
	}

	@PostMapping(value = "/login", produces = "application/json")
	@ResponseBody
	public Map<String, Object> login(@RequestBody Map<String, String> requestBody, HttpSession session) {
		String smail=requestBody.get("smail");
		String spwd=requestBody.get("spwd");
		
		Map<String, Object> loginRes = new HashMap<>();
		Student student = new Student();

		// 2. 判斷帳號密碼
		Map<String, String> res = ssi.login(smail, spwd);
		if ("success".equals(res.get("account")) && "success".equals(res.get("login"))) {
			loginRes.put("message", "loginSuccess");
			student = ssi.findByEmail(smail);
			loginRes.put("student", student);
			loginRes.put("redirectUrl", "http://localhost:3000/info");
		} else if ("success".equals(res.get("account"))) {
			loginRes.put("message", "sameAccount");
		} else {
			loginRes.put("message", "fail");
		}
		return loginRes;
	}
	@GetMapping("/getSessionStudent")
	@ResponseBody
	public ResponseEntity<Student> getSessionStudent(HttpSession session) {
		System.out.println("目前 session 的 student: " + session.getAttribute("student"));
	    Student student = (Student) session.getAttribute("student");
	    if (student == null) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	    }
	    return ResponseEntity.ok(student);
	}

	
	@PostMapping("/forget")
	@ResponseBody
	public Map<String, Object> forgetPa(@RequestBody Map<String, String> requestBody) {
		String smail=requestBody.get("smail");
		
		Map<String, Object> loginRes = new HashMap<String, Object>();
		Student student = new Student();
		MD5 md5=new MD5();

		// 5.忘記密碼

		student = ssi.findByEmail(smail);
		System.setProperty("https.protocols", "TLSv1.2");

		if (student != null) {
			RanPassword rp = new RanPassword();

			String newPass = rp.randomPassword();
			System.out.println(newPass);
			String finalPass=md5.md5Encrypt(newPass);
			System.out.print(finalPass);

			ssi.sendEmail(student.getSMAIL(), newPass);
			student.setSPWD(newPass);
			ssi.save(student);

			loginRes.put("message", "success");
			loginRes.put("redirectUrl", "index.jsp");
			return loginRes;
		} else {
			loginRes.put("message", "fail");
			loginRes.put("redirectUrl", "index.jsp");
			return loginRes;
		}
	}
}
