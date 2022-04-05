package com.semi.dangjang.zzim;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.semi.dangjang.board.domain.BoardDto;

@Repository("zzimDao")
public class ZzimDaoImpl implements ZzimDao{

	List<BoardDto> list = new ArrayList<BoardDto>();
	
	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public void insert(ZzimDto dto) {
		sm.insert("Board_insert", dto);
	}

	@Override
	public void delete(ZzimDto dto) {
		sm.delete("Board_delete", dto);
	}

}
