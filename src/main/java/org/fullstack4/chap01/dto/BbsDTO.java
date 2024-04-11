package org.fullstack4.chap01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor //매개변수가 없는 생성자 생성
@AllArgsConstructor // 파라미터가 필요시 lombok이 생성
public class BbsDTO {

    private int idx;
    private String title;
    private String user_id;
    private String content;
    private String display_date;
    private LocalDate reg_Date;
    private LocalDate modify_date;
    private int read_cnt;





   /* @Override
    public String toString() {
        return "BbsDTO{" +
                "idx=" + idx +
                ", title='" + title + '\'' +
                ", user_id='" + user_id + '\'' +
                ", content='" + content + '\'' +
                ", display_date='" + display_date + '\'' +
                ", reg_Date=" + reg_Date +
                ", modify_date=" + modify_date +
                ", read_cnt=" + read_cnt +
                '}';
    }*/
}
