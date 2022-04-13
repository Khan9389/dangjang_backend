package com.semi.dangjang.like;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("likeDao")
public class LikeDaoImpl implements LikeDao{

	List<LikeDto> list = new ArrayList<LikeDto>();
	
	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public void insert(LikeDto dto) {
		sm.insert("Like.Like_insert", dto);
	}

	@Override
	public void delete(LikeDto dto) {
		sm.delete("Like.Like_delete", dto);
	}

	@Override
	public LikeDto getView(LikeDto dto) {
		return sm.selectOne("Like.Like_getView",  dto);
	}

}
