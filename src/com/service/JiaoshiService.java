package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Jiaoshi;
import com.mapper.JiaoshiMapper;
@Service
public class JiaoshiService{
	@Autowired
	JiaoshiMapper jiaoshiMapper;
	
	public List<Jiaoshi> list(String where){
		return jiaoshiMapper.list(where);
	}
	public List<Jiaoshi> sealist(String where) {
		// TODO Auto-generated method stub
		return jiaoshiMapper.sealist(where);
	}
	public int total(String where) {
		return jiaoshiMapper.total(where);
	}

	public void insert(Jiaoshi c) {
		jiaoshiMapper.insert(c);
		
	}
	public void update(Jiaoshi c) {
		jiaoshiMapper.update(c);
	}


	public void delete(Jiaoshi c) {
		jiaoshiMapper.delete(c.getId());
	}


	public Jiaoshi get(int id) {
		// TODO Auto-generated method stub
		return jiaoshiMapper.get(id);
	}
public Jiaoshi getsql(String where) {
		return jiaoshiMapper.getsql(where);
	}
   public void updatesql(String value) {
		jiaoshiMapper.updatesql(value);
	}
	public void deletesql(String value) {
		jiaoshiMapper.deletesql(value);
	}
}