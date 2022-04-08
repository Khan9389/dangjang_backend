package com.semi.dangjang.box.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.semi.dangjang.box.domain.MessageBoxDto;

@Repository("boxDao")
public class MessageBoxDaoImpl implements MessageBoxDao{
	
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public List<MessageBoxDto> senderList(MessageBoxDto dto) {
		// TODO Auto-generated method stub
		return sm.selectList("Box_senderList",dto);
	}

	@Override
	public List<MessageBoxDto> receiverList(MessageBoxDto dto) {
		// TODO Auto-generated method stub
		return sm.selectList("Box_receiverList",dto);
	}

	@Override
	public MessageBoxDto getView(String box_seq) {
		// TODO Auto-generated method stub
		return sm.selectOne("Box_getView",box_seq);
	}

	@Override
	public void insert(MessageBoxDto dto) {
		// TODO Auto-generated method stub
		sm.insert("Box_insert",dto);
	}

	@Override
	public void update(MessageBoxDto dto) {
		// TODO Auto-generated method stub
		sm.update("Box_update",dto);
	}

	@Override
	public void delete(MessageBoxDto dto) {
		// TODO Auto-generated method stub
		sm.delete("Box_delete",dto);
	}
	
	

}
