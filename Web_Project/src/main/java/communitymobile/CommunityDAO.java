package communitymobile;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommunityDAO {
	
	@Autowired private SqlSession sql;
	
	public List<CommunityVO> list(){
		List<CommunityVO> list = sql.selectList("community.mapper.list");
		return list;
	}
	
	public int insert(CommunityVO inputvo) {
		return sql.insert("community.mapper.insert", inputvo);
	}
}
