package com.semi.dangjang.qna.repository;

import java.util.List;

import com.semi.dangjang.qna.domain.QnaDto;

public interface QnaDao {
	List<QnaDto> getQanList(QnaDto dto);
	int getQnaTotalCnt(QnaDto dto);
	QnaDto getView(String id);
	void qnaInsert(QnaDto dto);
	void qnaUpdate(QnaDto dto);
	void qunDelete(QnaDto dto);
	
}
