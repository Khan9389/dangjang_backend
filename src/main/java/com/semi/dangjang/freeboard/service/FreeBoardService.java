package com.semi.dangjang.freeboard.service;

import java.util.List;

import com.semi.dangjang.comment.domain.FBCommentDto;
import com.semi.dangjang.freeboard.domain.FreeBoardDto;





public interface FreeBoardService {
	List<FreeBoardDto> getList(FreeBoardDto dto);
	FreeBoardDto getView(FreeBoardDto dto);
	void insert(FreeBoardDto dto);
	int getTotalCnt(FreeBoardDto dto);
	void update(FreeBoardDto dto);
	void delete(FreeBoardDto dto);
	
	List<FBCommentDto> fbcommentList(FBCommentDto dto);
	void fbcommentinsert(FBCommentDto dto);
	void fbcomment_delete(FBCommentDto dto);
	int fbcommentTotal(FBCommentDto dto);
}
