package com.semi.dangjang.member.service;

import com.semi.dangjang.member.entity.Member;

public interface MemberService {

	public Member saveMember(Member member);

	void validateDuplicateMember(Member member);

}
