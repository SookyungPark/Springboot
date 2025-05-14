package com.acorn.day01Hello;

import org.springframework.stereotype.Service;
//1. 두 수를 사용자로 부터 입력 받아 사칙연산해서 제공하기    /calc
@Service
public class CalcService {

    public int add(int su1, int su2){
        return su1+su2;
    }

    public int minus(int su1, int su2){
        return su1-su2;
    }

    public int multiple(int su1, int su2){
        return su1*su2;
    }

    public int divide(int su1, int su2){
        return su1/su2;
    }
}
