package com.semi.dangjang.like;

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
public class LikeDto extends BaseDto{
	    
	private String free_seq = "";
	private String user_seq = "";
	private String like = "";
	
	@Builder
	public LikeDto (String free_seq, String user_seq, String like) {
		super();
		this.free_seq = free_seq;
		this.user_seq = user_seq;
		this.like = like;
	}
	
}
