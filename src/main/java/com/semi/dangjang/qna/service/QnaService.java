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
	List<QnaDto> getQnaSerach(QnaDto dto);
	
	
	
	
	//댓글
	QnaCommentDto getQnaCommentView(String qna_seq);
	void qnaCommentInsert(QnaCommentDto dto);
	void qnaCommentDelete(String qnaco_seq);
	void qnaCommentUpdate(QnaCommentDto dto);
	
	
}
