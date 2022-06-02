package communitymobile;

import java.sql.Date;

import lombok.Data;

@Data
public class CommunityVO {

	private String board_title, board_contents, board_date, board_filename, board_filepath, member_id, member_nickname;
	private int board_id, board_readcnt, board_category, board_like_cnt, board_comments_cnt;
	private Date writedate;
	
	public String getMember_nickname() {
        return member_nickname;
    }
    public void setMember_nickname(String member_nickname) {
        this.member_nickname = member_nickname;
    }
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getBoard_like_cnt() {
		return board_like_cnt;
	}
	public void setBoard_like_cnt(int board_like_cnt) {
		this.board_like_cnt = board_like_cnt;
	}
	public int getBoard_comments_cnt() {
		return board_comments_cnt;
	}
	public void setBoard_comments_cnt(int board_comments_cnt) {
		this.board_comments_cnt = board_comments_cnt;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_contents() {
		return board_contents;
	}
	public void setBoard_contents(String board_contents) {
		this.board_contents = board_contents;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}
	public String getBoard_filename() {
		return board_filename;
	}
	public void setBoard_filename(String board_filename) {
		this.board_filename = board_filename;
	}
	public String getBoard_filepath() {
		return board_filepath;
	}
	public void setBoard_filepath(String board_filepath) {
		this.board_filepath = board_filepath;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public int getBoard_readcnt() {
		return board_readcnt;
	}
	public void setBoard_readcnt(int board_readcnt) {
		this.board_readcnt = board_readcnt;
	}
	public int getBoard_category() {
		return board_category;
	}
	public void setBoard_category(int board_category) {
		this.board_category = board_category;
	}

	
}
