package org.fullstack4.chap01.dao;

import lombok.Cleanup;
import org.fullstack4.chap01.domain.BbsVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BbsDAOTests {
    private BbsDAO dao;

    @BeforeEach//테스트 실행 전
    public void ready(){
        dao =new BbsDAO();

    }
    @Test
    public void testGetTime() throws Exception{
        System.out.println("BbsDA.getTime() : " + dao.getTime());

    }
    @Test
    public void testGetTime2() throws Exception{
        System.out.println("BbsDAO.getTime2() : "  + dao.getTime2());
    }

    @Test
    public void testRegist() throws Exception{

        BbsVO vo = BbsVO.builder()
                .user_id("test")
                .title("게시글 타이틀 테스트")
                .content("게시글 내용 테스트")
                .display_date((LocalDateTime.now().toString()))
                        .read_cnt(0)
                        .build();
        dao.regist(vo);

    }
    @Test
    public void List() throws  Exception{
        List<BbsVO> list = dao.list();
        list.forEach(vo -> System.out.println("vo : " +vo));
    }

    @Test
    public void view() throws Exception{

        //test 객체는  test어노테이션 사용, public의 void ,매개변수없음 (내부에서 테스트)
        BbsVO vo = dao.view(1);//idx는 임의로 주기, 컨트롤러에서 vaildation체크 끝내기 (request받을때 처리)
        System.out.println("vo : " +vo);
    }

    @Test
    public void modify() throws Exception{
        BbsVO vo = BbsVO.builder()
                .idx(1)
                .user_id("test")
                .title("게시글 타이틀 테스트 수정")
                .content("게시글 내용 테스트 수정")
                .display_date((LocalDateTime.now().toString()))
                .read_cnt(0)
                .build();
        dao.modify(vo);
    }


    @Test
    public void testDelete() throws Exception{

        int idx= 1;
        dao.delete(idx);
    }

}
