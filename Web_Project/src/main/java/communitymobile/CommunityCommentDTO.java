package communitymobile;

public class CommunityCommentDTO {
	private int clip_id, board_id, clip_count, clip_lev, clip_seq;
    private String member_id, member_nickname, clip_contents, clip_date;
	
    public int getClip_id() {
		return clip_id;
	}
	public void setClip_id(int clip_id) {
		this.clip_id = clip_id;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public int getClip_count() {
		return clip_count;
	}
	public void setClip_count(int clip_count) {
		this.clip_count = clip_count;
	}
	public int getClip_lev() {
		return clip_lev;
	}
	public void setClip_lev(int clip_lev) {
		this.clip_lev = clip_lev;
	}
	public int getClip_seq() {
		return clip_seq;
	}
	public void setClip_seq(int clip_seq) {
		this.clip_seq = clip_seq;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_nickname() {
		return member_nickname;
	}
	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}
	public String getClip_contents() {
		return clip_contents;
	}
	public void setClip_contents(String clip_contents) {
		this.clip_contents = clip_contents;
	}
	public String getClip_date() {
		return clip_date;
	}
	public void setClip_date(String clip_date) {
		this.clip_date = clip_date;
	}
    
    
}
