package com.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.entity.Zleibie;
public interface ZleibieMapper {
    //添加
    public int insert(Zleibie zleibie);  
    //删除
    public void delete(int id);  
    //根据id获取数据
    public Zleibie get(int id);  
    //根据条件提取数据
	  public Zleibie getsql(@Param("where") String where);  
    //修改
    public int update(Zleibie zleibie);   
     //列表
    public List<Zleibie> list(@Param("where") String where);
    //分页
    public List<Zleibie> sealist(@Param("where") String where);
    //统计
    public int total(@Param("where") String where); 
public void updatesql(@Param("value") String value);
   public void deletesql(@Param("value") String value);
	
}