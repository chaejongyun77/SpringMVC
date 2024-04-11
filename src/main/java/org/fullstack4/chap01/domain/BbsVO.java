package org.fullstack4.chap01.domain;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter //getter자동생성
@Builder // dao에서 setIdx, sexUser_id대신 BbsVO.builder()를 사용할 수 있게함
@ToString
@NoArgsConstructor
@AllArgsConstructor


public class BbsVO

{

    private int idx;
    private String title;
    private String user_id;
    private String content;
    private String display_date;
    private LocalDate reg_Date;
    private LocalDate modify_date;
    private int read_cnt;

}
