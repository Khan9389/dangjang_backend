package com.semi.dangjang.comment.domain;

import com.semi.dangjang.common.BaseDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor(access=AccessLevel.PUBLIC)
public class FBCommentDto extends BaseDto{
	
	private String fbco_seq="";
	private String user_seq="";
	private String free_seq="";
	private String content="";
	private String wdate="";
	private String userid="";
	
	@Builder
	public FBCommentDto(String fbco_seq, String user_seq, String free_seq, String content, String wdate) {
		super();
		this.fbco_seq = fbco_seq;
		this.user_seq = user_seq;
		this.free_seq = free_seq;
		this.content = content;
		this.wdate = wdate;
	}
	
	
}
