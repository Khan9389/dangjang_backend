package com.semi.dangjang.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.semi.dangjang.common.FileUploadUtil;
import com.semi.dangjang.member.dto.MemberFormDto;
import com.semi.dangjang.member.entity.Member;
import com.semi.dangjang.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RequestMapping("/member")
@RestController
@RequiredArgsConstructor
public class MemberController {

	@Value("${fileUploadPath}")
	String fileUploadPath;

	@Value("${domain}")
	String domain;

	@Autowired
	UserDetailsService userSevice;

	@Autowired
	MemberService memberSevice;

	// private final PasswordEncoder passwordEncoder;

	@PostMapping(value = "/insert")
	public HashMap<String, String> newMember(MultipartFile file, @Valid MemberFormDto memberFormDto,
			BindingResult bindingResult, Model model) {
		System.out.println(memberFormDto);

		if (file != null && !file.getOriginalFilename().isBlank()) {
			String uploadDir = fileUploadPath + "/image";
			if (file != null) {
				try {
					String filename = FileUploadUtil.upload(uploadDir, file);
					memberFormDto.setImages(domain + "/" + uploadDir + "/" + filename);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		HashMap<String, String> map = new HashMap<String, String>();
		if (bindingResult.hasErrors()) {
			map.put("result", "fail");
		}

		try {
			Member member = Member.createMember(memberFormDto, null);
			memberSevice.saveMember(member);
			map.put("result", "success");
		} catch (IllegalStateException e) {
			model.addAttribute("errorMessage", e.getMessage());
		}

		return map;
	}

	@PostMapping(value = "/login")
	public HashMap<String, String> loginMember( @RequestBody Map<String, String> userInfo, HttpServletRequest request) {
		
		
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$" + userInfo.get("userid"));
		
		HashMap<String, String> map = new HashMap<String, String>();
		

			
		try {
			
	
			UserDetails user = userSevice.loadUserByUsername(userInfo.get("userid"));
				
		
			String userid = userInfo.get("userid");
			String password= userInfo.get("password");
			
			if( password.equals(user.getPassword()))
			{
				HttpSession session = request.getSession();
				session.setAttribute("name", user.getUsername());
			//session.setAttribute("userid", user.getAuthorities());
			//session.setAttribute("email", user.getEmail());
				String [] s = user.getUsername().split("\t");
				map.put("result", "success");
				map.put("username", s[0]);
				map.put("email", s[1]);
				map.put("role", s[2]);
				map.put("nickname", s[3]);
				map.put("user_seq", s[4]);
			}
			else
			{
				map.put("result", "password가 일치하지 않습니다. ");
			}

		} catch(Exception e) {
			map.put("result", "fail");
		}
		return map;
	}

	@GetMapping(value = "/login/error")
	public String loginError(Model model) {
		model.addAttribute("loginErrorMsg", "?��?��?�� ?��?�� 비�?번호�? ?��?��?��주세?��");
		return "/member/memberLoginForm";
	}

}