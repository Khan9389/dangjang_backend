package com.semi.dangjang.qnaComment.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.semi.dangjang.qnaComment.domain.QnaCommentDto;

@Repository("qnaCommentDao")
public class QnaCommentDaoImpl implements QnaCommentDao {
	
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public QnaCommentDto getQnaCommentView(String qna_seq) {
		// TODO Auto-generated method stub
		return sm.selectOne("QnaComment_getView",qna_seq);
	}

	@Override
	public void qnaCommentInsert(QnaCommentDto dto) {
		sm.insert( "QnaComment_insert",dto);
	}

	@Override
	public void qnaCommentDelete(String qnaco_seq) {
		sm.delete("QnaComment_delete",qnaco_seq);		
	}

	@Override
	public void qnaCommentUpdate(QnaCommentDto dto) {
		sm.update("QnaComment_update",dto);
		
	}
	

}
