package com.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.entity.Member;
public interface MemberMapper {
    //添加
    public int insert(Member member);  
    //删除
    public void delete(int id);  
    //根据id获取数据
    public Member get(int id);  
    //根据条件提取数据
	  public Member getsql(@Param("where") String where);  
    //修改
    public int update(Member member);   
     //列表
    public List<Member> list(@Param("where") String where);
    //分页
    public List<Member> sealist(@Param("where") String where);
    //统计
    public int total(@Param("where") String where); 
public void updatesql(@Param("value") String value);
   public void deletesql(@Param("value") String value);
	
}