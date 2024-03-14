package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Business;
import com.mapper.BusinessMapper;
@Service
public class BusinessService{
	@Autowired
	BusinessMapper businessMapper;
	
	public List<Business> list(String where){
		return businessMapper.list(where);
	}
	public List<Business> sealist(String where) {
		// TODO Auto-generated method stub
		return businessMapper.sealist(where);
	}
	public int total(String where) {
		return businessMapper.total(where);
	}

	public void insert(Business c) {
		businessMapper.insert(c);
		
	}
	public void update(Business c) {
		businessMapper.update(c);
	}


	public void delete(Business c) {
		businessMapper.delete(c.getId());
	}


	public Business get(int id) {
		// TODO Auto-generated method stub
		return businessMapper.get(id);
	}
public Business getsql(String where) {
		return businessMapper.getsql(where);
	}
   public void updatesql(String value) {
		businessMapper.updatesql(value);
	}
	public void deletesql(String value) {
		businessMapper.deletesql(value);
	}
}