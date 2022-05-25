package Member;

import lombok.Data;

@Data
public class MemberVO {
    private String member_id,member_nickname,member_pw,member_birth,member_gender,member_email;
   
    public MemberVO(String vo) {
    }
    
    public MemberVO(String member_id, String member_nickName, String member_pw, String member_birth, String member_gender, String member_email) {
        this.member_id = member_id;
        this.member_nickname = member_nickName;
        this.member_pw = member_pw;
        this.member_birth = member_birth;
        this.member_gender = member_gender;
        this.member_email = member_email;
    }
    
}
