package com.semi.dangjang.comment.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.semi.dangjang.comment.domain.FBCommentDto;

@Repository("fbcommentDao")
public class FBCommentDaoImpl implements FBCommentDao{

	@Autowired 
	SqlSessionTemplate sm;

	@Override
	public List<FBCommentDto> fbcommentList(FBCommentDto dto) {
		
		return sm.selectList("FBComment.fbComment_getList",dto);
	}

	@Override
	public void fbcommentinsert(FBCommentDto dto) {
		sm.insert("FBComment.fbcommentinsert",dto);
		
	}

	@Override
	public int fbcommentTotal(FBCommentDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void fbcomment_delete(FBCommentDto dto) {
		sm.delete("FBComment.fbComment_delete", dto);
		
	}
	
	



}




