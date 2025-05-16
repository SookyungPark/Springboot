package com.example.prj;

import lombok.Data;

@Data
public class Bang {

    int board_no;
    String writer;
    String title;
    String content;
    String board_pw;    //방명록쓸때 비밀번호?
    String hit;
    String creat_at; //등록날짜?

}
