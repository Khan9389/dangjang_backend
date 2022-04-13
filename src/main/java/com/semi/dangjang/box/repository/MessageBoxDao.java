package com.semi.dangjang.box.repository;

import java.util.List;

import com.semi.dangjang.box.domain.MessageBoxDto;

public interface MessageBoxDao {
	
	List<MessageBoxDto> senderList(MessageBoxDto dto);
	List<MessageBoxDto> receiverList(MessageBoxDto dto);
	MessageBoxDto getView(String box_seq);
	void insert(MessageBoxDto dto);
	void update(MessageBoxDto dto);
	void delete(MessageBoxDto dto);

}
