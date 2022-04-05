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
	private String answer="";
	private String at="";
	
	@Builder
	public QnaDto(String qna_seq, String user_seq, String title, String content, String wdate, String hit, String image,
			String nick_name, String category_code, String answer, String at) {
		super();
		this.qna_seq = qna_seq;
		this.user_seq = user_seq;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.hit = hit;
		this.image = image;
		this.nick_name = nick_name;
		this.category_code = category_code;
		this.answer = answer;
		this.at = at;
	}
	
	
}
