package com.semi.dangjang.qna.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.semi.dangjang.qna.domain.QnaDto;

@Repository("qnaDao")
public class QnaDaoImpl implements QnaDao {
	
	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<QnaDto> getQanList(QnaDto dto) {
		return sm.selectList("Qna_getList",dto);
	}

	@Override
	public int getQnaTotalCnt(QnaDto dto) {
		// TODO Auto-generated method stub
		return sm.selectOne("Qna_getTotal",dto);
	}

	@Override
	public QnaDto getView(String id) {
		// TODO Auto-generated method stub
		return sm.selectOne("Qna_getView",id);
	}

	@Override
	public void qnaInsert(QnaDto dto) {
		sm.insert("Qna_insert",dto);
		
	}

	@Override
	public void qnaUpdate(QnaDto dto) {
		sm.update("Qna_update",dto);
		
	}

	@Override
	public void qunDelete(QnaDto dto) {
		sm.delete("Qna_delete",dto);
		
	}

	@Override
	public List<QnaDto> getQnaSerach(QnaDto dto) {
		return sm.selectList("Qna_search",dto);
	}

}
