package Member;

import lombok.Data;

@Data
public class LoginVO {
    private String member_id,member_pw;

    public LoginVO(String member_id, String member_pw) {
        this.member_id = member_id;
        this.member_pw = member_pw;
    }

    public LoginVO() {
    }

    
}
