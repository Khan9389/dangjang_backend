package com.semi.dangjang.board.repository;

import java.util.List;

import com.semi.dangjang.board.domain.BoardDto;





public interface BoardDao {
	List<BoardDto> getList(BoardDto dto);
	int getTotalCnt(BoardDto dto);
	BoardDto getView(long id);
	void insert(BoardDto dto);
	void update(BoardDto dto);
	void delete(BoardDto dto);
	
}
