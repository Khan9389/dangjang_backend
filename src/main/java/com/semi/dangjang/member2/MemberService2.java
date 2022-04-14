package com.semi.dangjang.member2;

public interface MemberService2 {
	boolean isDuplicate(MemberDto dto);
	boolean isDuplicateNickName(MemberDto dto);
	void insert(MemberDto dto);
	MemberDto getInfo(MemberDto dto);
	MemberDto findId(MemberDto dto);
	MemberDto findPassword(MemberDto dto);
	void update(MemberDto dto);
}