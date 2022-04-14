package com.semi.dangjang.freeboard.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.semi.dangjang.comment.domain.FBCommentDto;
import com.semi.dangjang.comment.repository.FBCommentDao;
import com.semi.dangjang.freeboard.domain.FreeBoardDto;
import com.semi.dangjang.freeboard.repository.FreeBoardDao;




@Service("freeboardService")
public class FreeBoardServiceImpl implements FreeBoardService{

	@Resource(name="freeboardDao")
	FreeBoardDao dao;
	
	@Resource(name="fbcommentDao")
	FBCommentDao fbcommentDao;

	@Override
	public List<FreeBoardDto> getList(FreeBoardDto dto) {
		
		return dao.getList(dto);
	}

	@Override
	public FreeBoardDto getView(long free_seq) {
		
		return dao.getView(free_seq);
	}

	@Override
	public void insert(FreeBoardDto dto) {
		dao.insert(dto);
		
	}

	@Override
	public int getTotalCnt(FreeBoardDto dto) {
		
		return dao.getTotalCnt(dto);
	}

	@Override
	public void update(FreeBoardDto dto) {
		dao.update(dto);
		
	}

	@Override
	public void delete(FreeBoardDto dto) {
		dao.delete(dto);
		
	}

	@Override
	public void fbcommentinsert(FBCommentDto dto) {
		fbcommentDao.fbcommentinsert(dto);
		
	}

	@Override
	public List<FBCommentDto> fbcommentList(FBCommentDto dto) {
		// TODO Auto-generated method stub
		return fbcommentDao.fbcommentList(dto);
	}

	@Override
	public int fbcommentTotal(FBCommentDto dto) {
		return fbcommentDao.fbcommentTotal(dto);
		
	}

	@Override
	public void fbcomment_delete(FBCommentDto dto) {
		fbcommentDao.fbcomment_delete(dto);
		
	}
	
	
}






