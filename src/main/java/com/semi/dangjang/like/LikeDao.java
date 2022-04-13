package com.semi.dangjang.like;

public interface LikeDao {
	void insert(LikeDto dto);
	void delete(LikeDto dto);
	LikeDto getView(LikeDto dto);
}
