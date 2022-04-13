package com.semi.dangjang.like;

public interface LikeService {
	void insert(LikeDto dto);
	void delete(LikeDto dto);
	LikeDto getView(LikeDto dto);
}
