package org.fullstack4.chap01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor //매개변수가 없는 생성자 생성
@AllArgsConstructor // 파라미터가 필요시 lombok이 생성
public class MemberDTO
{
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
