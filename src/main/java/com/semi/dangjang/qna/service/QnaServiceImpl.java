package com.semi.dangjang.qna.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.semi.dangjang.qna.domain.QnaDto;
import com.semi.dangjang.qna.repository.QnaDao;

@Service("qnaService")
public class QnaServiceImpl implements QnaService {
	
	@Resource(name="qnaDao")
	QnaDao  dao;
	
	@Override
	public List<QnaDto> getQanList(QnaDto dto) {
		// TODO Auto-generated method stub
		return dao.getQanList(dto);
	}

	@Override
	public QnaDto getView(String qna_seq) {
		// TODO Auto-generated method stub
		return dao.getView(qna_seq);
	}

	@Override
	public int getQnaTotalCnt(QnaDto dto) {
		// TODO Auto-generated method stub
		return dao.getQnaTotalCnt(dto);
	}

	@Override
	public void qnaInsert(QnaDto dto) {
		// TODO Auto-generated method stub
		dao.qnaInsert(dto);
	}

	@Override
	public void qnaUpdate(QnaDto dto) {
		// TODO Auto-generated method stub
		dao.qnaUpdate(dto);
	}

	@Override
	public void qunDelete(QnaDto dto) {
		// TODO Auto-generated method stub
		dao.qunDelete(dto);
	}

}
