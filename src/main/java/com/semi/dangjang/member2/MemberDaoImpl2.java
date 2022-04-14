package com.semi.dangjang.member2;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDaoImpl2 implements MemberDao2{

	@Autowired
	SqlSessionTemplate sm;
	
	
	@Override
	public boolean isDuplicate(MemberDto dto) {
		
		int cnt = sm.selectOne("Member_isduplicate", dto);
		if(cnt==0)
			return false; //以묐났�븘�떂, �궗�슜媛��뒫�븳 �븘�씠�뵒�엫  
		else
			return true; //�씠誘� �궗�슜以묒엫 
	}
	

	@Override
	public boolean isDuplicateNickName(MemberDto dto) {
		
	int cnt = sm.selectOne("Member_isduplicateNickName", dto);
		if(cnt==0)
			return false; //以묐났�븘�떂, �궗�슜媛��뒫�븳 �븘�씠�뵒�엫  
	else
		return true; //�씠誘� �궗�슜以묒엫 
	}
	
	


	@Override
	public void insert(MemberDto dto) {
		sm.insert("Member_insert", dto);
	}

	@Override
	public MemberDto getInfo(MemberDto dto) {		
		return sm.selectOne("Member_getInfo", dto);
	}


	@Override
	public MemberDto findId(MemberDto dto) {		
		return sm.selectOne("Member_findid", dto);
	}


	@Override
	public MemberDto findPassword(MemberDto dto) {		
		return sm.selectOne("Member_findpassword", dto);
	}


	@Override
	public void update(MemberDto dto) {
		sm.update("Member_updateInfo", dto);
		
	}

}
