package com.example.day05PracException;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;


//전역으로 커스텀 예외처리
//패키지 단위나 전체 단위로 예외처리 ㄱㄴ
@ControllerAdvice
public class GlobalCatcher {

    //서버가 오류를 처리하면 상태코드가  200으로 됨
    //그래서 상태코드를 변경해야됨
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(SQLException.class)
    public String catcher(){
        return "errSQL";
    }

}
