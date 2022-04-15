package com.semi.dangjang.freeboard.domain;

import com.semi.dangjang.common.BaseDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor(access=AccessLevel.PUBLIC)  //�⺻�����ڸ� ������ش� 
public class FreeBoardDto extends BaseDto{
	    
	private long free_seq=-1;
	private String userid="";
	private String title="";
	private String content="";
	private String image="";
	private String wdate="";
	private String like_cnt="";
	private String hit="";
	private String user_seq="";
	private String click="";
	
	@Builder
	public FreeBoardDto(long free_seq, String userid, String title, String content, String image, String wdate,
			String like_cnt, String hit, String user_seq) {
		super();
		this.free_seq = free_seq;
		this.userid = userid;
		this.title = title;
		this.content = content;
		this.image = image;
		this.wdate = wdate;
		this.like_cnt = like_cnt;
		this.hit = hit;
		this.user_seq = user_seq;
	}
	
	
	
}
