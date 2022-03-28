package com.semi.dangjang.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.semi.dangjang.board.domain.BoardDto;
import com.semi.dangjang.board.service.BoardService;
import com.semi.dangjang.common.FileDownload;
import com.semi.dangjang.common.FileUploadUtil;

@CrossOrigin("*") 
@RestController	
public class BoardController {
	
	@Value("${fileUploadPath}")	
	String fileUploadPath;
	
	@Value("${domain}")
	String domain;
	
	@Resource(name="boardService")
	BoardService boardService;
	
	
	@RequestMapping("/board/list/{pg}")	
	HashMap<String, Object> getList(@PathVariable("pg")int pg, BoardDto dto)
	{
		dto.setStart((pg-1)*dto.getPageSize());
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", boardService.getTotalCnt(dto));
		map.put("list",  boardService.getList(dto));
		
		return map;
	}
	
	
	@RequestMapping("/board/view/{board_seq}")
	BoardDto getView(@PathVariable("board_seq")long board_seq)
	{		
		return	boardService.getView(board_seq);
	}
	
	@RequestMapping("/board/insert")
	Map<String, String> insert(MultipartFile file ,  BoardDto dto, HttpServletRequest req)
	{		
		System.out.println(dto.getTitle());
		System.out.println(dto.getUser_id());
		System.out.println(dto.getContent());
		
		String uploadDir = fileUploadPath+ "/image" ;

		if(file!=null)
		{
			try {
				String filename=FileUploadUtil.upload(uploadDir, file);
				dto.setImage1(domain +"/"+ uploadDir + "/"+ filename);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		boardService.insert(dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
	
    @GetMapping("/download/image/{file}")
    public void download(@PathVariable("file")String file, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        
	   FileDownload.download(fileUploadPath+"/image",  file, httpServletResponse);
        
    }

    @RequestMapping("/board/delete/{board_seq}")
	Map<String, String> delete(@PathVariable("board_seq")long board_seq, HttpServletRequest req)
	{		
		BoardDto dto=new BoardDto();
		dto.setBoard_seq(board_seq);
		boardService.delete(dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
    
    @RequestMapping("/board/update")
   	Map<String, String> update(MultipartFile file ,  BoardDto dto, HttpServletRequest req)
   	{		
   		System.out.println(dto.getTitle());
   		System.out.println(dto.getUser_id());
   		System.out.println(dto.getContent());
   		
   		String uploadDir = fileUploadPath+ "/image" ;
   		
   		if(file!=null)
   		{
   			try {
   				String filename=FileUploadUtil.upload(uploadDir, file);
   				dto.setImage1(domain +"/"+ uploadDir + "/"+ filename);
   				
   			} catch (IOException e) {
   				e.printStackTrace();
   			}
   		}
   		
   		boardService.update(dto);
   		Map<String, String> map = new HashMap<String, String>();
   		map.put("result", "success");
   		return map;
   	}
    
}
