package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Notice;
import com.mapper.NoticeMapper;
@Service
public class NoticeService{
	@Autowired
	NoticeMapper noticeMapper;
	
	public List<Notice> list(String where){
		return noticeMapper.list(where);
	}
	public List<Notice> sealist(String where) {
		// TODO Auto-generated method stub
		return noticeMapper.sealist(where);
	}
	public int total(String where) {
		return noticeMapper.total(where);
	}

	public void insert(Notice c) {
		noticeMapper.insert(c);
		
	}
	public void update(Notice c) {
		noticeMapper.update(c);
	}


	public void delete(Notice c) {
		noticeMapper.delete(c.getId());
	}


	public Notice get(int id) {
		// TODO Auto-generated method stub
		return noticeMapper.get(id);
	}
public Notice getsql(String where) {
		return noticeMapper.getsql(where);
	}
   public void updatesql(String value) {
		noticeMapper.updatesql(value);
	}
	public void deletesql(String value) {
		noticeMapper.deletesql(value);
	}
}