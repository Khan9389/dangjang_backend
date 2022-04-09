package com.semi.dangjang.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.semi.dangjang.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    //Member findByEmail(String email);
    Member findByUserid(String user_id);

}