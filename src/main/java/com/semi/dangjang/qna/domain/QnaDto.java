package com.semi.dangjang.qna.domain;

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
public class QnaDto extends BaseDto {
	private String qna_seq ="";
	private String user_seq ="";
	private String title ="";
	private String content ="";
	private String wdate="";
	private String hit ="";
	private String image="";
	private String nick_name="";
	private String category_code="";
	
	
	@Builder
	public QnaDto(String qna_seq, String user_seq, String title, String content, String wdate, String hit,String image,String nick_name) {
		super();
		this.qna_seq = qna_seq;
		this.user_seq = user_seq;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.hit = hit;
		this.image=image;
		this.nick_name=nick_name;
	}
	
	
}
