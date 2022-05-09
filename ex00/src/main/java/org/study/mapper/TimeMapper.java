package org.study.mapper;

import org.apache.ibatis.annotations.Select;

// org.study.mapper.TimeMapper.getTime2

public interface TimeMapper {
	
	@Select("SELECT sysdate FROM dual")
	public String getTime();
	
	String getTime2();
	
}
