package com.semi.dangjang.freeboard.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.semi.dangjang.comment.domain.FBCommentDto;
import com.semi.dangjang.common.FileUploadUtil;
import com.semi.dangjang.freeboard.domain.FreeBoardDto;
import com.semi.dangjang.freeboard.service.FreeBoardService;



@CrossOrigin("*") //http:127.0.0.1 혹은 localhost
@RestController	//jsp를 호출하지 않고 json형태로 데이터를 보낸다.
public class FreeBoardController {
	
	@Value("${fileUploadPath}")	//src/main/resources/application.properties 의 값을 업로드 한다.
	String fileUploadPath;
	
	@Value("${domain}")
	String domain;
	
	@Resource(name="freeboardService")
	FreeBoardService freeboardService;
	
	
	@RequestMapping("/freeboard/list/{pg}")	//freeboard/list/1
	HashMap<String, Object> getList(@PathVariable("pg")int pg, FreeBoardDto dto)
	{
		//System.out.println("curpage  " + pg);
		dto.setStart((pg-1)*dto.getPageSize());
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", freeboardService.getTotalCnt(dto));
		map.put("list",  freeboardService.getList(dto));

		
		return map;
	}
	
	
	@RequestMapping("/freeboard/view/{free_seq}")
	HashMap<String, Object> getView(@PathVariable("free_seq")long free_seq)
	{	
		HashMap<String, Object> map = new HashMap<String, Object>();
		FBCommentDto cdto = new FBCommentDto(); 
		cdto.setFree_seq(free_seq+"");
		map.put("commentList", freeboardService.fbcommentList(cdto));
		map.put("dto",freeboardService.getView(free_seq));
		
		return map;
	}
	
	// Map -> HashMap의 추상클래스  -- aixos 가 json 으로 보내는데 json 받으려면 
	//@RequestBody  가 있어야 한다 
	@RequestMapping("/freeboard/insert")
	Map<String, String> insert(MultipartFile file ,  FreeBoardDto dto, HttpServletRequest req)
	{		
		System.out.println(dto.getTitle());
		System.out.println(dto.getUserid());
		System.out.println(dto.getContent());
		
		//fileupload/image에 만든다.
		String uploadDir = fileUploadPath+ "/image" ;	//파일이 업로드 될 경로
		
		//http://localhost:9090/fileupload/image/1582531436.jpeg
		if(file!=null)
		{
			try {
				//파일을 주면 업로드하면서 새로운 파일명을 반환한다. 파일명이 중복될 수 있기 때문이다.
				String filename=FileUploadUtil.upload(uploadDir, file);
				//dto.setFilename(filename);
				dto.setImage(domain +"/"+ uploadDir + "/"+ filename);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		freeboardService.insert(dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
//	
//    @GetMapping("/download/image/{file}")
//    public void download(@PathVariable("file")String file, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
//            throws ServletException, IOException {
//        
//	   FileDownload.download(fileUploadPath+"/image",  file, httpServletResponse);
//        
//    }

    @RequestMapping("/freeboard/delete/{free_seq}")
	Map<String, String> delete(@PathVariable("free_seq")long free_seq, HttpServletRequest req)
	{		
		FreeBoardDto dto=new FreeBoardDto();
		dto.setFree_seq(free_seq);
		freeboardService.delete(dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
    
    @RequestMapping("/freeboard/update")
   	Map<String, String> update(MultipartFile file ,  FreeBoardDto dto, HttpServletRequest req)
   	{		
   		System.out.println(dto.getTitle());
   		System.out.println(dto.getUserid());
   		System.out.println(dto.getContent());

   		
   		
   		String uploadDir = fileUploadPath+ "/image" ;
   		
   		//http://localhost:9090/user-photos/image/1582531436.jpeg
   		if(file!=null)
   		{
   			try {
   				String filename=FileUploadUtil.upload(uploadDir, file);
   		//		dto.setFilename(filename);
   		//		dto.setImage_url(domain +"/"+ uploadDir + "/"+ filename);
   		//		
   			} catch (IOException e) {
   				e.printStackTrace();
   			}
   		}
   		
   		//System.out.println("**********************************    "  +  dto.getId());
   		
   		freeboardService.update(dto);
   		Map<String, String> map = new HashMap<String, String>();
   		map.put("result", "success");
   		return map;
   	}
    
    
    
}






