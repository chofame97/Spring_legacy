package board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO implements BoardService {

	@Autowired @Qualifier("hanul") private SqlSession sql;
	
	@Override
	public int board_insert(BoardVO vo) {
		return sql.insert("board.mapper.insert", vo);
	}

	// 페이징 처리된 목록을 조회

	@Override
	public BoardPage board_list(BoardPage page) {
		// 전체 게시글 수 조회
		page.setTotalList( sql.selectOne("board.mapper.totalList", page) ); 
		// 페이징 처리된 전체 게시글 조회
		page.setList(sql.selectList("board.mapper.list", page));		
		
		return page;
	}

	@Override
	public BoardVO board_detail(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int board_read(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int board_update(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int board_delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
