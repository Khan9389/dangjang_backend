package com.semi.dangjang.member.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberFormDto {

	private String user_seq;
	
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

	private String admincode;

}