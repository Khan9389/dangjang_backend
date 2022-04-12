package com.semi.dangjang.zzim;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*") //모든 정책을 허용한다는 의미. 부트는 9090과 리액트의 3000을 연결하려고 하면 출처가 달라서 요청을 주고받을 수 없다.
				  //cross origin을 통해 리액트랑 부트를 연동시켜준다.
@RestController	//컨트롤러라는 표기
public class ZzimController {
	
	//마찬가지로 application.properties 안 domain=http://127.0.0.1:9090을 읽어온다.
	@Value("${domain}")			
	String domain;
	
	@Resource(name="zzimService")
	ZzimService zzimService;
	
    @RequestMapping("/zzim/insert")
    Map<String, Object> insert(ZzimDto dto, HttpServletRequest req)
	{		
		System.out.println("user--------------" + dto.getUser_seq());
		System.out.println("board--------------" + dto.getBoard_seq());
		System.out.println("zzim--------------" + dto.getZzim());
		
		zzimService.insert(dto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
    	map.put("zzimdto",zzimService.getView(dto));

		return map;
	}
    
    @RequestMapping("/zzim/delete")
	Map<String, Object> delete(ZzimDto dto, HttpServletRequest req)
	{	
    	System.out.println("user--------------" + dto.getUser_seq());
		System.out.println("board--------------" + dto.getBoard_seq());
		
		zzimService.delete(dto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
    	map.put("zzimdto",zzimService.getView(dto));

		return map;
	}
    
    @RequestMapping("/zzim/view")
    Map<String, Object> getView(ZzimDto dto)
	{		
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("zzimdto",zzimService.getView(dto));
    	map.put("result", "success");
		return map;
	}
}
