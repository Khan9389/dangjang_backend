package com.semi.dangjang.freeboard.repository;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.semi.dangjang.freeboard.domain.FreeBoardDto;





@Repository("freeboardDao")
public class FreeBoardDaoImpl implements FreeBoardDao{

	List<FreeBoardDto> list = new ArrayList<FreeBoardDto>();
	
	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<FreeBoardDto> getList(FreeBoardDto dto) {
		
		return sm.selectList("FreeBoard.FreeBoard_getList", dto);
	}


	@Override
	public int getTotalCnt(FreeBoardDto dto) {
		
		return sm.selectOne("FreeBoard.FreeBoard_getTotal", dto);
	}


	@Override
	public FreeBoardDto getView(FreeBoardDto dto) {
		
		return sm.selectOne("FreeBoard.FreeBoard_getView",  dto);
	}


	@Override
	public void insert(FreeBoardDto dto) {
		
		sm.insert("FreeBoard.FreeBoard_insert", dto);
	}


	@Override
	public void update(FreeBoardDto dto) {
		sm.update("FreeBoard.FreeBoard_update", dto);
		
	}


	@Override
	public void delete(FreeBoardDto dto) {
		sm.delete("FreeBoard.FreeBoard_delete", dto);
		
	}


	@Override
	public void updateHit(int id) {
		// TODO Auto-generated method stub
		
	}
	
	

	

}






