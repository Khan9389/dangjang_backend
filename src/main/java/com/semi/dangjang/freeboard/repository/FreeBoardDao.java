package com.semi.dangjang.freeboard.repository;

import java.util.List;

import com.semi.dangjang.freeboard.domain.FreeBoardDto;





public interface FreeBoardDao {
	List<FreeBoardDto> getList(FreeBoardDto dto);
	int getTotalCnt(FreeBoardDto dto);
	FreeBoardDto getView(long free_seq);
	void insert(FreeBoardDto dto);
	void update(FreeBoardDto dto);
	void delete(FreeBoardDto dto);
	
}
