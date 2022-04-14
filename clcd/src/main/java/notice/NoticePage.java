package notice;

import java.util.List;

import common.PageVO;

public class NoticePage extends PageVO{
	// 10건의 공지사항을 담을 필드를 선언
	// 공지사항을 담을 Page에 대한 정보를 가진 PageVO를 
	// extends를 통해 page 관련 기능을 모두 상속받아 처리	
	
	private List<NoticeVO> list;

	public List<NoticeVO> getList() {
		return list;
	}

	public void setList(List<NoticeVO> list) {
		this.list = list;
	}		
}
