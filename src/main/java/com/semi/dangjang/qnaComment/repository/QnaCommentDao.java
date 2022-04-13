package com.semi.dangjang.qnaComment.repository;

import com.semi.dangjang.qnaComment.domain.QnaCommentDto;

public interface QnaCommentDao {
	QnaCommentDto getQnaCommentView(String qna_seq);
	void qnaCommentInsert(QnaCommentDto dto);
	void qnaCommentDelete(String qnaco_seq);
	void qnaCommentUpdate(QnaCommentDto dto);
	
}
