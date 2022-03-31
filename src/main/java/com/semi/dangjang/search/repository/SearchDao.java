package com.semi.dangjang.search.repository;

import java.util.List;

import com.semi.dangjang.search.domain.SearchDto;

public interface SearchDao {
	List<SearchDto> getList(SearchDto dto);
}
