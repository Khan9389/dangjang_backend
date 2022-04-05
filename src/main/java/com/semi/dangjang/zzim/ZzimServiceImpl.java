package com.semi.dangjang.zzim;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("zzimService")
public class ZzimServiceImpl implements ZzimService{

	@Resource(name="zzimDao")
	ZzimDao dao;
	
	@Override
	public void insert(ZzimDto dto) {
		dao.insert(dto);
	}
	
	@Override
	public void delete(ZzimDto dto) {
		dao.delete(dto);
	}
	
}
