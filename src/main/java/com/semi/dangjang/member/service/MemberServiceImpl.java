package com.semi.dangjang.member.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.semi.dangjang.member.entity.Member;
import com.semi.dangjang.member.repository.MemberRepository;


@Service
@Transactional
public class MemberServiceImpl implements UserDetailsService, MemberService {

	//public MemberRepository memberRepository;
	@Autowired
	MemberRepository memberRepository;

	public Member saveMember(Member member) {
		validateDuplicateMember(member);
		return memberRepository.save(member);
	}

	public void validateDuplicateMember(Member member) {
		Member findMember = memberRepository.findByUserid(member.getUserid());
		if (findMember != null) {
			throw new IllegalStateException("?ù¥ÎØ? Í∞??ûÖ?êú ?öå?õê?ûÖ?ãà?ã§.");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		Member member = memberRepository.findByUserid(userid);
		
		if(member == null) {
			throw new UsernameNotFoundException(userid);
		}
		
		return User.builder()
				.username(member.getUserid())
				.password(member.getPassword())
				.roles(member.getRole().toString())
				.build();
	}

//	public Member loadUserByUsername(String id) {
//
//		Member member = memberRepository.findByUserid(id);
//
//		return member;
//	}

}
