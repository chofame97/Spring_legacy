package board;

public interface BoardService {

	int board_insert(BoardVO vo);			// 방명록 신규 저장(C)
	BoardPage board_list(BoardPage page);	// 방명록 목록 조회 - 페이지 처리된 (R)
	BoardVO board_detail(int id); 			// 방명록 상세 조회(R)
	int board_read(int id);					// 방명록 조회수 처리(U)
	int board_update(BoardVO vo);			// 방명록 게시글 변경 저장(U)
	int board_delete(int id);				// 방명록 게시글 삭제 처리(D)
	
}
