package com.example.day08PracConvert;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//대표적인 convert 오류
//null 일때 -> int 기본자료형 데이터를 담으려고 할 때
//"문자열" -> int, Integer  오류발생
//"2025/05/22" -> 문자열인데 Data로 받고싶으면
//스프링이 첨에는 자동으로 변환해주지만 오류가 날수도있대
//=> 400오류 (request bad, )

//변환오류 발생하면 오류화면 응답
//변환오류 발생했을 때 처리한 후 사용자친화적인 오류메세지를 원래 폼에서
//확인할 수 있게해야함


@Data
public class Item {

    Long money;
    String name;

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    Date inDate;


}
