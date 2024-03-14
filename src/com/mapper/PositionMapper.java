package com.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.entity.Position;
public interface PositionMapper {
    //添加
    public int insert(Position position);  
    //删除
    public void delete(int id);  
    //根据id获取数据
    public Position get(int id);  
    //根据条件提取数据
	  public Position getsql(@Param("where") String where);  
    //修改
    public int update(Position position);   
     //列表
    public List<Position> list(@Param("where") String where);
    //分页
    public List<Position> sealist(@Param("where") String where);
    //统计
    public int total(@Param("where") String where); 
public void updatesql(@Param("value") String value);
   public void deletesql(@Param("value") String value);
	
}