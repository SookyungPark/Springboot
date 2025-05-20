package com.example.prj.login;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findById(String userid); // 로그인용
    void insertUser(User user);   // 회원가입용

}
