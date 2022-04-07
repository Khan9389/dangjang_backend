package com.semi.dangjang.board.repository;

import java.util.List;

import com.semi.dangjang.board.domain.BoardDto;

public interface BoardDao {
	List<BoardDto> getList(BoardDto dto);
	List<BoardDto> getTotalCnt(BoardDto dto);
	BoardDto getView(long board_seq);
	void insert(BoardDto dto);
	void update(BoardDto dto);
	void delete(BoardDto dto);
	
}
