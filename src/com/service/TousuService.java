package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Tousu;
import com.mapper.TousuMapper;
@Service
public class TousuService{
	@Autowired
	TousuMapper tousuMapper;
	
	public List<Tousu> list(String where){
		return tousuMapper.list(where);
	}
	public List<Tousu> sealist(String where) {
		// TODO Auto-generated method stub
		return tousuMapper.sealist(where);
	}
	public int total(String where) {
		return tousuMapper.total(where);
	}

	public void insert(Tousu c) {
		tousuMapper.insert(c);
		
	}
	public void update(Tousu c) {
		tousuMapper.update(c);
	}


	public void delete(Tousu c) {
		tousuMapper.delete(c.getId());
	}


	public Tousu get(int id) {
		// TODO Auto-generated method stub
		return tousuMapper.get(id);
	}
public Tousu getsql(String where) {
		return tousuMapper.getsql(where);
	}
   public void updatesql(String value) {
		tousuMapper.updatesql(value);
	}
	public void deletesql(String value) {
		tousuMapper.deletesql(value);
	}
}