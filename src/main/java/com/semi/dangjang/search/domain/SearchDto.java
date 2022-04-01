package com.semi.dangjang.search.domain;

import com.semi.dangjang.common.BaseDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDto extends BaseDto {
	private long board_seq = -1;
	private String category_code = "";
	private String title = "";
	private String user_id = "";
	private String user_seq = "";
	
	@Builder
	public SearchDto(long board_seq, String category_code, String title, String user_id, String user_seq) {
		super();
		this.board_seq = board_seq;
		this.category_code = category_code;
		this.title = title;
		this.user_id = user_id;
		this.user_seq = user_seq;
	}
	
	
	
	
}
