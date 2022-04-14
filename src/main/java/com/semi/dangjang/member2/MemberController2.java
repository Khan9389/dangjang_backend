package com.semi.dangjang.member2;

import java.io.IOException;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.semi.dangjang.common.FileUploadUtil;

@CrossOrigin("*")
@RestController
public class MemberController2 {
	
	@Value("${fileUploadPath}")
	String fileUploadPath;

	@Value("${domain}")
	String domain;
	
	@Resource(name="memberService2")
	MemberService2 memberService;
	
	@RequestMapping("/member/view/{userid}")
	HashMap<String, Object> member_myinfo(@PathVariable("userid") String userid, HttpServletRequest request, HttpServletResponse response)
	{
		HashMap<String, Object> map = new HashMap<String, Object>();

		if(userid==null) {
			map.put("result", "fail");
			return map;
		}
		
		MemberDto dto = new MemberDto();
		dto.setUserid(userid);
		
		MemberDto resultDto = memberService.getInfo(dto);
		
		map.put("result", "success");
		map.put("info",resultDto);
		return map;
	}
		
	@RequestMapping("/member/isDuplicate")
	public HashMap<String, String> member_isDuplicate(MemberDto dto)
	{
		//System.out.println("userid : " + dto.getUserid());
		System.out.println("nick_name: " + dto.getNick_name());
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("result", memberService.isDuplicate(dto)+"");
		
		return map;
	}
	
	@RequestMapping("/member/isDuplicateNickName")
	public HashMap<String, String> member_isDuplicateNickName(MemberDto dto)
	{

		System.out.println("nick_name: " + dto.getNick_name());
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("result", memberService.isDuplicateNickName(dto)+"");
		
	return map;
	}
	
	
	
	@RequestMapping(value="/member/logout")
	public HashMap<String, String>  member_logout(HttpServletRequest request)
	{
		// loginYN �÷� �߰��� �ڵ� �߰��Ұ�
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
	
	@RequestMapping(value="/member/findid")
	public HashMap<String, String> member_findid_proc(HashMap<String, String> map2, @RequestBody MemberDto dto)
	
	{
	
		/*
		 * System.out.println(
		 * "**********************************************************");
		 * System.out.println(dto.getName()); System.out.println(dto.getPhone());
		 * System.out.println(dto.getEmail());
		 */
		
		MemberDto findDto = memberService.findId(dto);
		HashMap<String, String> map = new HashMap<String, String>();
		if (findDto==null)
			map.put("result", "fail");
		else
		{
			map.put("result", "success");
			map.put("userid", findDto.getUserid());
			
		}
		return map;
	}
	
	
	@RequestMapping(value="/member/findpass")
	public HashMap<String, String> member_findpass_proc(HashMap<String, String> map2, @RequestBody MemberDto dto)
	{	
		
		System.out.println("**********************************************************");
		System.out.println(dto.getUserid());
		System.out.println(dto.getPhone());
		System.out.println(dto.getEmail());
		
		
		// �н����� �����ϴ� �ڵ� �߰��Ұ�
		HashMap<String, String> map = new HashMap<String, String>();
		MemberDto findDto = memberService.findPassword(dto);
		
		if (findDto==null)
			map.put("result", "fail");
		else
		{
			map.put("result", "success");
			map.put("userid", findDto.getUserid());
			map.put("password", findDto.getPassword());
			
		}
		return map;
	}
	
	@RequestMapping(value="/member/update")
	public HashMap<String, String> member_update(MultipartFile file, MemberDto dto)
	{	

		if(file!=null && !file.getOriginalFilename().isBlank()) {		
			String uploadDir = fileUploadPath + "/image";
			if (file != null) {
				try {
					String filename = FileUploadUtil.upload(uploadDir, file);
					dto.setImages(domain + "/" + uploadDir + "/" + filename);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		memberService.update(dto);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("result", "success");	
		return map;
	}
	

}
