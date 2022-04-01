package com.semi.dangjang.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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

@CrossOrigin("*") //모든 정책을 허용한다는 의미. 부트는 9090과 리액트의 3000을 연결하려고 하면 출처가 달라서 요청을 주고받을 수 없다.
				  //cross origin을 통해 리액트랑 부트를 연동시켜준다.
@RestController	//컨트롤러라는 표기
public class BoardController {
	
	//@Value는 properties를 읽어오는 annotation
	//application.properties안
	//fileUploadPath를 읽어온다. fileUploadPath=fileupload
	@Value("${fileUploadPath}")	
	String fileUploadPath;
	
	//마찬가지로 application.properties 안 domain=http://127.0.0.1:9090을 읽어온다.
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
		
		System.out.println("----------------------------"+pg);
		System.out.println("----------------------------"+map);
		return map;
	}
	
	
	@RequestMapping("/board/view/{board_seq}")
	BoardDto getView(@PathVariable("board_seq")long board_seq)
	{		
		return	boardService.getView(board_seq);
	}
	
	// List<MultipartFile> fileList
	// 여러장 업로드 할때 list를 통해서 한다.
	@RequestMapping("/board/insert2")
	Map<String, String> insert2(List<MultipartFile> fileList, BoardDto dto, HttpServletRequest req)
	{		
		System.out.println(dto.getTitle());
		System.out.println(dto.getUser_id());
		System.out.println(dto.getContent());
		
		String uploadDir = fileUploadPath+ "/image" ;
		
		for(int i=0; i<fileList.size(); i++ ) {
			
			MultipartFile file = fileList.get(i);
			if(file!=null )
			{
				try {
					
					String filename=FileUploadUtil.upload(uploadDir, file);
					System.out.println("filename : " +i+ filename);
					if(i==0) {
						dto.setImage1(domain +"/"+ uploadDir + "/"+ filename);
					} else if(i==1) {
						dto.setImage2(domain +"/"+ uploadDir + "/"+ filename);
					} else if(i==2) {
						dto.setImage3(domain +"/"+ uploadDir + "/"+ filename);
					} else if(i==3) {
						dto.setImage4(domain +"/"+ uploadDir + "/"+ filename);
					} else if(i==4) {
						dto.setImage5(domain +"/"+ uploadDir + "/"+ filename);
					} else if(i==5) {
						dto.setImage6(domain +"/"+ uploadDir + "/"+ filename);
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		boardService.insert(dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
	//한장 업로드 할 때 MultipartFile로 
	@RequestMapping("/board/insert")
	Map<String, String> insert(MultipartFile file, BoardDto dto, HttpServletRequest req)
	{		
		System.out.println(dto.getTitle());
		System.out.println(dto.getUser_id());
		System.out.println(dto.getContent());
		
		String uploadDir = fileUploadPath+ "/image" ;

		if(file!=null )
		{
			try {
				
				// 
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
	
	//만약에... 4번째 사진만 바꾸고 싶다면...? 그때는 코드ㅇ가...
	//try 문으로 감싸고 if (file!=null && file.isEmpty()) 이거로 쓰고
	//else 라면 setImage1=""; 이렇게 가져가야하나..?
	@RequestMapping("/board/update")
   	Map<String, String> update(List<MultipartFile> fileList, BoardDto dto, HttpServletRequest req)
   	{		
   		System.out.println(dto.getTitle());
   		System.out.println(dto.getUser_id());
   		System.out.println(dto.getContent());
   		
   		String uploadDir = fileUploadPath+ "/image" ;
   		
		for(int i=0; i<fileList.size(); i++ ) {
					
			MultipartFile file = fileList.get(i);
			if(file!=null )
			{
				try {
					
					String filename=FileUploadUtil.upload(uploadDir, file);
					System.out.println("filename : " +i+ filename);
					if(i==0) {
						dto.setImage1(domain +"/"+ uploadDir + "/"+ filename);
					} else if(i==1) {
						dto.setImage2(domain +"/"+ uploadDir + "/"+ filename);
					} else if(i==2) {
						dto.setImage3(domain +"/"+ uploadDir + "/"+ filename);
					} else if(i==3) {
						dto.setImage4(domain +"/"+ uploadDir + "/"+ filename);
					} else if(i==4) {
						dto.setImage5(domain +"/"+ uploadDir + "/"+ filename);
					} else if(i==5) {
						dto.setImage6(domain +"/"+ uploadDir + "/"+ filename);
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
   		
   		boardService.update(dto);
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
    
}
