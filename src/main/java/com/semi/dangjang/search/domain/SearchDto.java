package com.semi.dangjang.search.domain;

import com.semi.dangjang.common.BaseDto;

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
	
}
