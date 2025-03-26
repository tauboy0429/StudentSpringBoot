package com.example.springboot.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name="SNO")
	private String SNO;
	
	@Column(name="SNAME")
	private String SNAME;
	
	@Column(name="SBDAY")
	private Date SBDAY;
	
	@Column(name="SSEX")
	private int SSEX;
	
	@Column(name="SMAIL")
	private String email;
	
	@Column(name="SPWD")
	private String SPWD;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String sNO, String sNAME, Date sBDAY, int sSEX, String sMAIL, String sPWD) {
		super();
		SNO = sNO;
		SNAME = sNAME;
		SBDAY = sBDAY;
		SSEX = sSEX;
		email = sMAIL;
		SPWD = sPWD;
	}

	public String getSNO() {
		return SNO;
	}

	public void setSNO(String sNO) {
		SNO = sNO;
	}

	public String getSNAME() {
		return SNAME;
	}

	public void setSNAME(String sNAME) {
		SNAME = sNAME;
	}

	public Date getSBDAY() {
		return SBDAY;
	}

	public void setSBDAY(Date sBDAY) {
		SBDAY = sBDAY;
	}

	public int getSSEX() {
		return SSEX;
	}

	public void setSSEX(int sSEX) {
		SSEX = sSEX;
	}

	public String getSMAIL() {
		return email;
	}

	public void setSMAIL(String sMAIL) {
		email = sMAIL;
	}

	public String getSPWD() {
		return SPWD;
	}

	public void setSPWD(String sPWD) {
		SPWD = sPWD;
	}
	
}
