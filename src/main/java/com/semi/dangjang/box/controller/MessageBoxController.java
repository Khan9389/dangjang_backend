package com.semi.dangjang.box.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.semi.dangjang.box.domain.MessageBoxDto;
import com.semi.dangjang.box.service.MessageBoxService;

@RestController
public class MessageBoxController {
	
	@Resource(name="boxservice")
	MessageBoxService boxservice;
	
	@RequestMapping("/box/sender")
	HashMap<String,Object> sender(MessageBoxDto dto){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("sender", boxservice.senderList(dto));
		return map;
		
	}
	
	@RequestMapping("/box/receiver")
	HashMap<String,Object> receiver(MessageBoxDto dto){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("sender", boxservice.receiverList(dto));
		return map;
		
	}
	
	@RequestMapping("/box/view/{seq}")
	MessageBoxDto getView(@PathVariable("seq")String box_seq) {
		
		return boxservice.getView(box_seq);
	}
	
	@RequestMapping("/box/insert")
	Map<String,String> insert(MessageBoxDto dto){
		
		
		boxservice.insert(dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
	@RequestMapping("/box/update")
	Map<String,String> update(MessageBoxDto dto){
		
		boxservice.update(dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
	@RequestMapping("/box/delete")
	Map<String,String> delete(MessageBoxDto dto){
		
		boxservice.delete(dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
}
