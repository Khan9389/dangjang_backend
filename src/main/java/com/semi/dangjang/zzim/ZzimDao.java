package com.semi.dangjang.zzim;

public interface ZzimDao {
	void insert(ZzimDto dto);
	void delete(ZzimDto dto);
	ZzimDto getView(ZzimDto dto);
}
