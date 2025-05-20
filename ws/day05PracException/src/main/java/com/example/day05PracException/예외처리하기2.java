package com.example.day05PracException;

public class 예외처리하기2 {

    public static void main(String[] args) {

        //매서드를 만들어볼게요
        //int doubler(int money)

        int money = -1;
        int result = 0;
        try {
            result = doubler(money);
        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println("처리안됐어용");
            //throw new RuntimeException(e);
        }
        System.out.println("투자 보고서");
        System.out.println("투자 금액 : "+money);
        System.out.println("투자 금액 : "+ result);
        System.out.println("프로그램 정상 종료!");
    }

    public static int doubler(int money) throws Exception {
        //입력으로 들어온 수가 음수면 예외발생시킬거임
        if(money<=0) throw new Exception("d음수안돼b");


        return money*2;
    }
}
