package com.semi.dangjang.member.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.semi.dangjang.member.constant.Role;
import com.semi.dangjang.member.dto.MemberFormDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
public class Member {

	@Id
	@Column(name = "user_seq")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String userid;

	private String password;

	private String nick_name;
	
	private String name;

	private String email;
	
	private String phone;

	private String address1;
	
	private String address2;
	
	private String zipcode;
	
	private String images;

	private String wdate;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		Member member = new Member();
		member.setUserid(memberFormDto.getUserid());
		member.setName(memberFormDto.getName());
		member.setNick_name(memberFormDto.getNick_name());
		member.setEmail(memberFormDto.getEmail());
		member.setPhone(memberFormDto.getPhone());
		member.setAddress1(memberFormDto.getAddress1());
		member.setAddress2(memberFormDto.getAddress2());
		member.setZipcode(memberFormDto.getZipcode());
		member.setImages(memberFormDto.getImages());
		member.setWdate(LocalDateTime.now().toString());
		//String password = passwordEncoder.encode(memberFormDto.getPassword());
		member.setPassword(memberFormDto.getPassword());
		member.setImages(memberFormDto.getImages());
		if(memberFormDto.getAdmincode().equals("1111"))
        	member.setRole(Role.ADMIN);
        else
        	member.setRole(Role.USER);
		return member;
	}

}

