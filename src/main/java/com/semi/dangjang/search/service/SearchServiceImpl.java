package com.semi.dangjang.search.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.semi.dangjang.search.domain.SearchDto;
import com.semi.dangjang.search.repository.SearchDao;

@Service("searchService")
public class SearchServiceImpl implements SearchService{
	@Resource(name="searchDao")
	SearchDao searchDao;

	@Override
	public List<SearchDto> getList(SearchDto dto) {
		return searchDao.getList(dto);
	}
	

}
