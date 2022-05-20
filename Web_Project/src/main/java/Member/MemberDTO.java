package Member;

import lombok.Data;

@Data
public class MemberDTO {
	private String member_email;

	public MemberDTO(String member_email) {
		super();
		this.member_email = member_email;
	}
	
	
	
}
