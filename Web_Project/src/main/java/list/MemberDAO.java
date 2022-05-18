package list;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	@Qualifier("bteam")
	private SqlSession sql;

	public void join() {
		sql.insert("test.mapper.join");
	}
	public List<GuinDTO> check() {
		return sql.selectList("test.mapper.test");
	}
	

}
