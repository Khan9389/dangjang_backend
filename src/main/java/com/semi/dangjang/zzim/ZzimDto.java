package com.semi.dangjang.zzim;

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
public class ZzimDto extends BaseDto{
	    
	private String board_seq = "";
	private String user_seq = "";
	private String zzim = "";
	
	@Builder
	public ZzimDto (String board_seq, String user_seq, String zzim) {
		super();
		this.board_seq = board_seq;
		this.user_seq = user_seq;
		this.zzim = zzim;
	}
	
}
