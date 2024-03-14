package com.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.entity.Tousu;
public interface TousuMapper {
    //添加
    public int insert(Tousu tousu);  
    //删除
    public void delete(int id);  
    //根据id获取数据
    public Tousu get(int id);  
    //根据条件提取数据
	  public Tousu getsql(@Param("where") String where);  
    //修改
    public int update(Tousu tousu);   
     //列表
    public List<Tousu> list(@Param("where") String where);
    //分页
    public List<Tousu> sealist(@Param("where") String where);
    //统计
    public int total(@Param("where") String where); 
public void updatesql(@Param("value") String value);
   public void deletesql(@Param("value") String value);
	
}