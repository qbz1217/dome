package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Zleibie;
import com.mapper.ZleibieMapper;
@Service
public class ZleibieService{
	@Autowired
	ZleibieMapper zleibieMapper;
	
	public List<Zleibie> list(String where){
		return zleibieMapper.list(where);
	}
	public List<Zleibie> sealist(String where) {
		// TODO Auto-generated method stub
		return zleibieMapper.sealist(where);
	}
	public int total(String where) {
		return zleibieMapper.total(where);
	}

	public void insert(Zleibie c) {
		zleibieMapper.insert(c);
		
	}
	public void update(Zleibie c) {
		zleibieMapper.update(c);
	}


	public void delete(Zleibie c) {
		zleibieMapper.delete(c.getId());
	}


	public Zleibie get(int id) {
		// TODO Auto-generated method stub
		return zleibieMapper.get(id);
	}
public Zleibie getsql(String where) {
		return zleibieMapper.getsql(where);
	}
   public void updatesql(String value) {
		zleibieMapper.updatesql(value);
	}
	public void deletesql(String value) {
		zleibieMapper.deletesql(value);
	}
}