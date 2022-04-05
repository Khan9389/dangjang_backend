package com.semi.dangjang.qna.service;

import java.util.List;

import com.semi.dangjang.qna.domain.QnaDto;
import com.semi.dangjang.qnaComment.domain.QnaCommentDto;

public interface QnaService {
	List<QnaDto> getQanList(QnaDto dto);
	QnaDto getView(String id);
	int getQnaTotalCnt(QnaDto dto);
	void qnaInsert(QnaDto dto);
	void qnaUpdate(QnaDto dto);
	void qunDelete(QnaDto dto);
	
	
	
	
	//댓글
	QnaCommentDto getQnaCommentView(String qna_seq);
	void qnaCommentInsert(QnaCommentDto dto);
	void qnaCommentDelete(QnaCommentDto dto);
	void qnaCommentUpdate(QnaCommentDto dto);
	
	
}
