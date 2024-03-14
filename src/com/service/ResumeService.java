package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Resume;
import com.mapper.ResumeMapper;
@Service
public class ResumeService{
	@Autowired
	ResumeMapper resumeMapper;
	
	public List<Resume> list(String where){
		return resumeMapper.list(where);
	}
	public List<Resume> sealist(String where) {
		// TODO Auto-generated method stub
		return resumeMapper.sealist(where);
	}
	public int total(String where) {
		return resumeMapper.total(where);
	}

	public void insert(Resume c) {
		resumeMapper.insert(c);
		
	}
	public void update(Resume c) {
		resumeMapper.update(c);
	}


	public void delete(Resume c) {
		resumeMapper.delete(c.getId());
	}


	public Resume get(int id) {
		// TODO Auto-generated method stub
		return resumeMapper.get(id);
	}
public Resume getsql(String where) {
		return resumeMapper.getsql(where);
	}
   public void updatesql(String value) {
		resumeMapper.updatesql(value);
	}
	public void deletesql(String value) {
		resumeMapper.deletesql(value);
	}
}