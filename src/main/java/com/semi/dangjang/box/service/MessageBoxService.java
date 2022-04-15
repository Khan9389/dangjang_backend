package com.semi.dangjang.box.service;

import java.util.List;

import com.semi.dangjang.box.domain.MessageBoxDto;

public interface MessageBoxService {
	
	List<MessageBoxDto> senderList(MessageBoxDto dto);
	List<MessageBoxDto> receiverList(MessageBoxDto dto);
	MessageBoxDto getView(String box_seq);
	void insert(MessageBoxDto dto);
	void update(MessageBoxDto dto);
	void delete(MessageBoxDto dto);
	int count(MessageBoxDto dto);

}
