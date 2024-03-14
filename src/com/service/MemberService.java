package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Member;
import com.mapper.MemberMapper;
@Service
public class MemberService{
	@Autowired
	MemberMapper memberMapper;
	
	public List<Member> list(String where){
		return memberMapper.list(where);
	}
	public List<Member> sealist(String where) {
		// TODO Auto-generated method stub
		return memberMapper.sealist(where);
	}
	public int total(String where) {
		return memberMapper.total(where);
	}

	public void insert(Member c) {
		memberMapper.insert(c);
		
	}
	public void update(Member c) {
		memberMapper.update(c);
	}


	public void delete(Member c) {
		memberMapper.delete(c.getId());
	}


	public Member get(int id) {
		// TODO Auto-generated method stub
		return memberMapper.get(id);
	}
public Member getsql(String where) {
		return memberMapper.getsql(where);
	}
   public void updatesql(String value) {
		memberMapper.updatesql(value);
	}
	public void deletesql(String value) {
		memberMapper.deletesql(value);
	}
}