package org.fullstack4.chap01.domain;

import lombok.*;

@Data //getter자동생성
@Builder // dao에서 setIdx, sexUser_id대신 BbsVO.builder()를 사용할 수 있게함
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class MemberVO {
    String user_id;
    String name;
    String pwd;
    String jumin;
    String addr1;
    String addr2;
    String birthday;
    String job_code;
    String mileage;
    String user_Sate;
    String reg_date;
    String leave_date;
    String pwd_change_date;
}
