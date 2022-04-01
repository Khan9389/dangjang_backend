package com.semi.dangjang.qna.service;

import java.util.List;

import com.semi.dangjang.qna.domain.QnaDto;

public interface QnaService {
	List<QnaDto> getQanList(QnaDto dto);
	QnaDto getView(String id);
	int getQnaTotalCnt(QnaDto dto);
	void qnaInsert(QnaDto dto);
	void qnaUpdate(QnaDto dto);
	void qunDelete(QnaDto dto);
}
