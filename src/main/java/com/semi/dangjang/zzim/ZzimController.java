package com.semi.dangjang.zzim;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.semi.dangjang.board.domain.BoardDto;

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
    Map<String, String> insert(ZzimDto dto, HttpServletRequest req)
	{		
		System.out.println(dto.getUser_seq());
		System.out.println(dto.getBoard_seq());
		System.out.println(dto.getZzim());
		
		zzimService.insert(dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
    
    @RequestMapping("/zzim/delete")
	Map<String, String> delete(String board_seq, String user_seq, HttpServletRequest req)
	{		
		ZzimDto dto=new ZzimDto();
		dto.setBoard_seq(board_seq);
		dto.setUser_seq(user_seq);
		zzimService.delete(dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
}
