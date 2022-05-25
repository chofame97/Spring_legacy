package Member;

import lombok.Data;

@Data
public class NickNameDTO {
	private String nickName;

	public NickNameDTO(String nickName) {
		super();
		this.nickName = nickName;
	}

	public NickNameDTO() {
		super();
	}
	
	
	
}
