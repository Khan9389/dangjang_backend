package com.semi.dangjang.like;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("likeService")
public class LikeServiceImpl implements LikeService{

	@Resource(name="likeDao")
	LikeDao dao;
	
	@Override
	public void insert(LikeDto dto) {
		dao.insert(dto);
	}
	
	@Override
	public void delete(LikeDto dto) {
		dao.delete(dto);
	}

	@Override
	public LikeDto getView(LikeDto dto) {
		return dao.getView(dto);
	}
	
}
