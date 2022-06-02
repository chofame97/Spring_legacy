package notice;

import java.util.List;

public interface NoticeService {
	// CRUD (Create, Read, Update, Delete)
	
	void notice_insert(NoticeVO vo);		// 공지글 신규 저장(C)
	
	void notice_reply_insert(NoticeVO vo);	// 공지글에 대한 답글 신규저장(C)
	
	List<NoticeVO> notice_list();  			// 공지글 목록 조회(R)
	
	NoticePage notice_list(NoticePage page); // 공지글 목록 조회 - 페이지 처리된 (R)
	
	NoticeVO notice_detail(int id);			// 공지글 상세조회(R)
	void notice_update(NoticeVO vo);		// 공지글 변경저장(U)
	void notice_delete(int id); 			// 공지글 삭제(D)
	void notice_read(int id);				// 공지글 조회시 조회수 증가 처리(U) 
	
}
