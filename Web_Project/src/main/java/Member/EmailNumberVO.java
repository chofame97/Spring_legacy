package Member;

import lombok.Data;

@Data
public class EmailNumberVO {
	private int checkNum;

	public EmailNumberVO(int checkNum) {
		super();
		this.checkNum = checkNum;
	}

	public EmailNumberVO() {
		super();
	}
	
	
	
}
