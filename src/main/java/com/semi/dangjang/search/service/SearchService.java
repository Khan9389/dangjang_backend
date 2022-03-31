package com.semi.dangjang.search.service;

import java.util.List;

import com.semi.dangjang.search.domain.SearchDto;

public interface SearchService {
	List<SearchDto> getList(SearchDto dto);
}
