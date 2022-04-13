package com.semi.dangjang.box.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageBoxDto {
	
	private String box_seq="";
	private String board_seq="";
	private String content="";
	private String wdate="";
	private String sender="";
	private String receiver="";
	private String ischeck="";
	private String title="";
	private String image="";


}
