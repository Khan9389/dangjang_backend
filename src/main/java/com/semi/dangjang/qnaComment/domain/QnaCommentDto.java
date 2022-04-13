package com.semi.dangjang.qnaComment.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor(access=AccessLevel.PUBLIC)
public class QnaCommentDto {
	
	private String qnaco_seq="";
	private String user_seq="";
	private String qna_seq="";
	private String content="";
	private String wdate="";

	
	@Builder
	public QnaCommentDto(String qnaco_seq, String user_seq, String qna_seq, String content, String wdate) {
		super();
		this.qnaco_seq = qnaco_seq;
		this.user_seq = user_seq;
		this.qna_seq = qna_seq;
		this.content = content;
		this.wdate = wdate;
	}
	
	
	
	
}
