package Member;

import lombok.Data;

@Data
public class EmailDTO {
	private String member_email;

	public EmailDTO(String member_email) {
		super();
		this.member_email = member_email;
	}
	
	
	
}
