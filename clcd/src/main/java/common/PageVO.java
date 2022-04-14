package common;

public class PageVO {

	int totalList;			// 총 글의 건수(DB에서 조회해 온 전체 글수)
	int totalPage;			// 총 페이지 수
	int totalBlock;			// 총 블럭 수
	int pageList = 10;		// 페이지당 보여질 목록의 수
	int blockPage = 10;		// 블럭당 보여질 페이지의 수
	int curPage;			// 현재 페이지
	int beginList, endList;	// 각 페이지에 보여질 시작 목록번호, 끝 목록번호
	int curBlock;			// 현재 블럭
	int beginPage, endPage;	// 각 블럭에 보여질 시작, 끝 페이지 번호
	
	public int getTotalList() {
		return totalList;
	}
	
	// 전체 페이지가 조회가 되면 페이지 처리를 할수 있기 때문에 
	// 조회된 전체 페이지 수 값이 등록되는 단계에서 
	// 페이지 처리에 관한 작업을 하면 되기에 totlaList setter 메소드에서 처리를 함.
	public void setTotalList(int totalList) {
		this.totalList = totalList;	// DB에서 총 글의 건수
		// 총 페이지수(totalPage) : totalList / pageList 
		totalPage = totalList / pageList;
		// 총 448건의 글을 페이지당  10건씩... 총 페이지수 44
		// 대신 나머지가 발생하기 때문에 1페이지를 증가 해야 함. 
		if ( totalList % pageList > 0) ++totalPage;
		// totalPage = 45...
		// 총 블럭수(totalBlock) : totalPage / blockPage
		totalBlock = totalPage / blockPage;
		if (totalPage % blockPage > 0) ++totalBlock;
		
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}
	public int getPageList() {
		return pageList;
	}
	public void setPageList(int pageList) {
		this.pageList = pageList;
	}
	public int getBlockPage() {
		return blockPage;
	}
	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getBeginList() {
		return beginList;
	}
	public void setBeginList(int beginList) {
		this.beginList = beginList;
	}
	public int getEndList() {
		return endList;
	}
	public void setEndList(int endList) {
		this.endList = endList;
	}
	public int getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
}
