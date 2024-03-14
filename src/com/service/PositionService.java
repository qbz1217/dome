package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Position;
import com.mapper.PositionMapper;
@Service
public class PositionService{
	@Autowired
	PositionMapper positionMapper;
	
	public List<Position> list(String where){
		return positionMapper.list(where);
	}
	public List<Position> sealist(String where) {
		// TODO Auto-generated method stub
		return positionMapper.sealist(where);
	}
	public int total(String where) {
		return positionMapper.total(where);
	}

	public void insert(Position c) {
		positionMapper.insert(c);
		
	}
	public void update(Position c) {
		positionMapper.update(c);
	}


	public void delete(Position c) {
		positionMapper.delete(c.getId());
	}


	public Position get(int id) {
		// TODO Auto-generated method stub
		return positionMapper.get(id);
	}
public Position getsql(String where) {
		return positionMapper.getsql(where);
	}
   public void updatesql(String value) {
		positionMapper.updatesql(value);
	}
	public void deletesql(String value) {
		positionMapper.deletesql(value);
	}
}