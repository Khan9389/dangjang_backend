package com.semi.dangjang.comment.repository;

import java.util.List;

import com.semi.dangjang.comment.domain.FBCommentDto;

public interface FBCommentDao {
	List<FBCommentDto> fbcommentList(FBCommentDto dto);
	void fbcommentinsert(FBCommentDto dto);
	int fbcommentTotal(FBCommentDto dto);
	void fbcomment_delete(FBCommentDto dto);
	
}
