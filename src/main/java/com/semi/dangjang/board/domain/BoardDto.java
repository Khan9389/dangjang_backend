package com.semi.dangjang.board.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.semi.dangjang.common.BaseDto;

import lombok.AccessLevel;
import lombok.Builder;
   
@Setter
@Getter
@NoArgsConstructor(access=AccessLevel.PUBLIC)
public class BoardDto extends BaseDto{
	    
	private long board_seq = -1;
	private String category_code = "";
	private String title = "";
	private String content = "";
	private String image1 = "";
	private String image2 = "";
	private String image3 = "";
	private String image4 = "";
	private String image5 = "";
	private String image6 = "";
	private String price = "";
	private String user_id = "";
	private String user_seq = "";
	private String zzim_cnt = "";
	private String hit = "";
	private String wdate = "";
	
	@Builder
	public BoardDto (long board_seq, String category_code, String title, String content, 
			String image1, String image2, String image3, String image4, String image5, String image6,
			String price, String user_id, String user_seq, String zzim_cnt, String hit, String wdate) {
		super();
		this.board_seq = board_seq;
		this.category_code = category_code;
		this.content = content;
		this.title = title;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.image5 = image5;
		this.image6 = image6;
		this.price = price;
		this.user_id = user_id;
		this.user_seq = user_seq;
		this.zzim_cnt = zzim_cnt;
		this.hit = hit;
		this.wdate = wdate;
	}
	
}
