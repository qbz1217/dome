package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Sq;
import com.mapper.SqMapper;
@Service
public class SqService{
	@Autowired
	SqMapper sqMapper;
	
	public List<Sq> list(String where){
		return sqMapper.list(where);
	}
	public List<Sq> sealist(String where) {
		// TODO Auto-generated method stub
		return sqMapper.sealist(where);
	}
	public int total(String where) {
		return sqMapper.total(where);
	}

	public void insert(Sq c) {
		sqMapper.insert(c);
		
	}
	public void update(Sq c) {
		sqMapper.update(c);
	}


	public void delete(Sq c) {
		sqMapper.delete(c.getId());
	}


	public Sq get(int id) {
		// TODO Auto-generated method stub
		return sqMapper.get(id);
	}
public Sq getsql(String where) {
		return sqMapper.getsql(where);
	}
   public void updatesql(String value) {
		sqMapper.updatesql(value);
	}
	public void deletesql(String value) {
		sqMapper.deletesql(value);
	}
}