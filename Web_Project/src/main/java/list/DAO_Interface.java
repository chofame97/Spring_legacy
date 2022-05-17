package list;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface DAO_Interface {

	@Select("select * from guinlist")
	public List<VO> getList();
	
}
