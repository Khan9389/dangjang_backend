package com.semi.dangjang.zzim;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("zzimDao")
public class ZzimDaoImpl implements ZzimDao{

	List<ZzimDto> list = new ArrayList<ZzimDto>();
	
	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public void insert(ZzimDto dto) {
		sm.insert("Zzim.Zzim_insert", dto);
	}

	@Override
	public void delete(ZzimDto dto) {
		sm.delete("Zzim.Zzim_delete", dto);
	}

	@Override
	public ZzimDto getView(ZzimDto dto) {
		return sm.selectOne("Zzim.Zzim_getView",  dto);
	}

}
