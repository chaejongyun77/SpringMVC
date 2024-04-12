package org.fullstack4.chap01.service;


import org.fullstack4.chap01.dao.LoginDAO;

import org.fullstack4.chap01.domain.MemberVO;

import org.fullstack4.chap01.dto.MemberDTO;
import org.fullstack4.chap01.util.MapperUtil;
import org.modelmapper.ModelMapper;

public enum LoginService {
    INSTANCE;
    private LoginDAO dao;
    private ModelMapper modelMapper;

    LoginService(){
        dao = new LoginDAO();
        modelMapper = MapperUtil.INSTANCE.getModelMapper();
    }

    public MemberDTO login(String id, String pwd) throws Exception {

        MemberVO memberVO = dao.login(id,pwd);


        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);



        return memberDTO;


    }
}
