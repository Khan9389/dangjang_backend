package com.semi.dangjang.member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.semi.dangjang.common.FileUploadUtil;
import com.semi.dangjang.member.dto.MemberFormDto;
import com.semi.dangjang.member.entity.Member;
import com.semi.dangjang.member.service.MemberService;

import lombok.RequiredArgsConstructor;

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
	
	private final PasswordEncoder passwordEncoder;

	@PostMapping(value = "/insert")
	public HashMap<String, String> newMember(MultipartFile file,@Valid MemberFormDto memberFormDto, 
			BindingResult bindingResult, Model model) {
		System.out.println(memberFormDto);

		if(!file.getOriginalFilename().isBlank()) {		
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
			Member member = Member.createMember(memberFormDto, passwordEncoder);
			memberSevice.saveMember(member);
			map.put("result", "success");
		} catch (IllegalStateException e) {
			model.addAttribute("errorMessage", e.getMessage());
		}
		

		return map;
	}

	@GetMapping(value = "/login")
	public HashMap<String, String> loginMember(String userid, String password, HttpServletRequest request) {
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$" + userid);
		UserDetails user = userSevice.loadUserByUsername(userid);
		
		
		HashMap<String, String> map = new HashMap<String, String>();
		if (user == null) {
			map.put("result", "fail");

		} else {
			HttpSession session = request.getSession();
			session.setAttribute("name", user.getUsername());
			//session.setAttribute("userid", user.getAuthorities());
			//session.setAttribute("email", user.getEmail());
			map.put("result", "success");

		}
		return map;
	}

	@GetMapping(value = "/login/error")
	public String loginError(Model model) {
		model.addAttribute("loginErrorMsg", "?ïÑ?ù¥?îî ?òê?äî ÎπÑÎ?Î≤àÌò∏Î•? ?ôï?ù∏?ï¥Ï£ºÏÑ∏?öî");
		return "/member/memberLoginForm";
	}

}