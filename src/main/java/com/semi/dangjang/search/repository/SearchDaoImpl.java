package com.semi.dangjang.search.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.semi.dangjang.search.domain.SearchDto;

@Repository("searchDao")
public class SearchDaoImpl implements SearchDao{
	
	
	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<SearchDto> getList(SearchDto dto) {
		return sm.selectList("listPage",dto);
	}
	
	
}
