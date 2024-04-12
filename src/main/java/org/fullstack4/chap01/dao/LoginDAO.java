package org.fullstack4.chap01.dao;

import lombok.Cleanup;
import org.fullstack4.chap01.domain.BbsVO;
import org.fullstack4.chap01.domain.MemberVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
    public MemberVO login(String id, String pwd) throws Exception{
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT user_id, name, pwd");
        sb.append(" FROM tbl_member");
        sb.append(" WHERE user_id =? AND pwd =?");

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sb.toString());
        pstmt.setString(1, id);
        pstmt.setString(2, pwd);

        @Cleanup ResultSet rs = pstmt.executeQuery();

        rs.next();

        MemberVO vo = MemberVO.builder()

                .user_id(rs.getString("user_id"))
                .name(rs.getString("name"))

                .build();

        return vo;
    }
}
