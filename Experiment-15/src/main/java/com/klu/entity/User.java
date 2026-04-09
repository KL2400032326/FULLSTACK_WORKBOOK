package com.klu.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Entity
@Table(name="myusers")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String email;
	private String password;
	@Column(name = "verified", nullable = false)
	private boolean verified = false;
	private String otp;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean isVerified) {
		this.verified = isVerified;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}


}
