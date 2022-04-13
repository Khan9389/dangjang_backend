package com.semi.dangjang.like;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.semi.dangjang.freeboard.domain.FreeBoardDto;
import com.semi.dangjang.freeboard.service.FreeBoardService;

@CrossOrigin("*") //ëª¨ë“  ? •ì±…ì„ ?—ˆ?š©?•œ?‹¤?Š” ?˜ë¯?. ë¶??Š¸?Š” 9090ê³? ë¦¬ì•¡?Š¸?˜ 3000?„ ?—°ê²°í•˜? ¤ê³? ?•˜ë©? ì¶œì²˜ê°? ?‹¬?¼?„œ ?š”ì²??„ ì£¼ê³ ë°›ì„ ?ˆ˜ ?—†?‹¤.
				  //cross origin?„ ?†µ?•´ ë¦¬ì•¡?Š¸?‘ ë¶??Š¸ë¥? ?—°?™?‹œì¼œì??‹¤.
@RestController	//ì»¨íŠ¸ë¡¤ëŸ¬?¼?Š” ?‘œê¸?
public class LikeController {
	
	//ë§ˆì°¬ê°?ì§?ë¡? application.properties ?•ˆ domain=http://127.0.0.1:9090?„ ?½?–´?˜¨?‹¤.
	@Value("${domain}")			
	String domain;
	
	@Resource(name="likeService")
	LikeService likeService;
	
	@Resource(name="freeboardService")
	FreeBoardService freeboardService;
	
    @RequestMapping("/like/insert")
    Map<String, Object> insert(LikeDto dto, HttpServletRequest req)
	{		
		System.out.println("user--------------" + dto.getUser_seq());
		System.out.println("board--------------" + dto.getFree_seq());
		System.out.println("like--------------" + dto.getLike());
		
		likeService.insert(dto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
    	map.put("likedto", likeService.getView(dto));
    	map.put("like_cnt", freeboardService.getView(Long.parseLong(dto.getFree_seq())).getLike_cnt());

		return map;
	}
    
    @RequestMapping("/like/delete")
	Map<String, Object> delete(LikeDto dto, HttpServletRequest req)
	{	
    	System.out.println("user--------------" + dto.getUser_seq());
		System.out.println("board--------------" + dto.getFree_seq());
		
		likeService.delete(dto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
    	map.put("likedto", likeService.getView(dto));
    	map.put("like_cnt", freeboardService.getView(Long.parseLong(dto.getFree_seq())).getLike_cnt());

		return map;
	}
    
    @RequestMapping("/like/view")
    Map<String, Object> getView(LikeDto dto)
	{		
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("likedto", likeService.getView(dto));
    	map.put("like_cnt", freeboardService.getView(Long.parseLong(dto.getFree_seq())).getLike_cnt());
    	map.put("result", "success");
    	
		return map;
	}
}
