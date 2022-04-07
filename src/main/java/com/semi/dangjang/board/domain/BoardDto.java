package com.semi.dangjang.board.domain;

import com.semi.dangjang.common.BaseDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
   
@Setter
@Getter
@NoArgsConstructor(access=AccessLevel.PUBLIC)
@ToString
public class BoardDto extends BaseDto{
	    
	private long board_seq = -1;
	private String category_name = "";
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
	private String user_images = "";
	private String zzim_cnt = "";
	private String hit = "";
	private String wdate = "";
	private String category_code = "";
	private String my_cnt = "";
	private String nick_name = "";
	private String address1 = "";
	private String catCnt = "";
	
	@Builder
	public BoardDto (long board_seq, String category_name, String title, String content, 
			String image1, String image2, String image3, String image4, String image5, String image6,
			String price, String user_id, String user_images, String zzim_cnt, String hit, String wdate, 
			String category_code, String my_cnt, String nick_name, String address1, String user_seq, String catCnt) {
		super();
		this.board_seq = board_seq;
		this.category_name = category_name;
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
		this.user_images = user_images;
		this.zzim_cnt = zzim_cnt;
		this.hit = hit;
		this.wdate = wdate;
		this.category_code = category_code;
		this.my_cnt = my_cnt;
		this.nick_name = nick_name;
		this.address1 = address1;
		this.user_seq = user_seq;
		this.catCnt = catCnt;
	}
	
}
