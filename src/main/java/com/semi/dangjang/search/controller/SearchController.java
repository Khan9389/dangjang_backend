package com.semi.dangjang.search.controller;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.semi.dangjang.search.domain.SearchDto;
import com.semi.dangjang.search.service.SearchService;

@CrossOrigin("*")

@RestController
public class SearchController {
		
	@Resource(name="searchService")
	SearchService searchService;
	
	@RequestMapping("/main/list/{pg}")	
	HashMap<String, Object> getList(@PathVariable("pg")int pg, SearchDto dto)
	{
		
		dto.setStart((pg-1)*dto.getPageSize());
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list",  searchService.getList(dto));
		
		System.out.println("----------------------------"+pg);
		System.out.println("----------------------------"+map);
		
		return map;
	}
}
