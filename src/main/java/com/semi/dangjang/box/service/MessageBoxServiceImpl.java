package com.semi.dangjang.box.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.semi.dangjang.box.domain.MessageBoxDto;
import com.semi.dangjang.box.repository.MessageBoxDao;

@Service("boxservice")
public class MessageBoxServiceImpl implements MessageBoxService{
	
	@Resource(name="boxDao")
	MessageBoxDao boxDao;

	@Override
	public List<MessageBoxDto> senderList(MessageBoxDto dto) {
		// TODO Auto-generated method stub
		return boxDao.senderList(dto);
	}

	@Override
	public List<MessageBoxDto> receiverList(MessageBoxDto dto) {
		// TODO Auto-generated method stub
		return boxDao.receiverList(dto);
	}

	@Override
	public MessageBoxDto getView(String box_seq) {
		// TODO Auto-generated method stub
		return boxDao.getView(box_seq);
	}

	@Override
	public void insert(MessageBoxDto dto) {
		// TODO Auto-generated method stub
		boxDao.insert(dto);
	}

	@Override
	public void update(MessageBoxDto dto) {
		// TODO Auto-generated method stub
		boxDao.update(dto);
	}

	@Override
	public void delete(MessageBoxDto dto) {
		// TODO Auto-generated method stub
		boxDao.delete(dto);
	}
	
	
	
}
