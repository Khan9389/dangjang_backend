package com.semi.dangjang.qnaComment.repository;

import com.semi.dangjang.qnaComment.domain.QnaCommentDto;

public interface QnaCommentDao {
	QnaCommentDto getQnaCommentView(String qna_seq);
	void qnaCommentInsert(QnaCommentDto dto);
	void qnaCommentDelete(QnaCommentDto dto);
	void qnaCommentUpdate(QnaCommentDto dto);
	
}
