package com.semi.dangjang.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.semi.dangjang.board.domain.BoardDto;
import com.semi.dangjang.board.repository.BoardDao;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Resource(name="boardDao")
	BoardDao dao;
	@Override
	public List<BoardDto> getList(BoardDto dto) {
		return dao.getList(dto);
	}

	@Override
	public BoardDto getView(long board_seq) {
		return dao.getView(board_seq);
	}

	@Override
	public void insert(BoardDto dto) {
		dao.insert(dto);
	}

	@Override
	public int getTotalCnt(BoardDto dto) {
		return dao.getTotalCnt(dto);
	}

	@Override
	public void update(BoardDto dto) {
		dao.update(dto);
	}

	@Override
	public void delete(BoardDto dto) {
		dao.delete(dto);
	}
	
}
