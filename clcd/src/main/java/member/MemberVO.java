package member;

public class MemberVO {

	private String id, name, pw, addr, tel, gender, email, post, admin;
	private String birth;
	
	// social_type : 소셜 로그인 형태가 네이버인지 카카오인지 구분할 필드명
	// social_email : 소셜 이메일 값을 저장할 필드명
	private String social_type, social_email;
	
	
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getSocial_type() {
		return social_type;
	}
	public void setSocial_type(String social_type) {
		this.social_type = social_type;
	}
	public String getSocial_email() {
		return social_email;
	}
	public void setSocial_email(String social_email) {
		this.social_email = social_email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	
	
}
