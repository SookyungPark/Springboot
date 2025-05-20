package com.example.prj;

import lombok.Data;

import java.util.Date;

@Data
public class Bang {

    private int boardNo;
    private String writer;
    private String title;
    private String content;
    private String boardPw;
    private int hit;
    private Date creatAt;
}
