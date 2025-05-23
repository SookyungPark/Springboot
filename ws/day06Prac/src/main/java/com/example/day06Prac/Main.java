package com.example.day06Prac;

public class Main {
    public static void main(String[] args) {

        //int currentPage, int pageSize, int grpSize, int totRecords
        int currentPage=6;
        int pageSize=4;
        int grpSize=5;
        int totRecords=37;
        PageHandler handler = new PageHandler(currentPage, pageSize, grpSize, totRecords);

        int start = handler.getGrpStartPage();
        int end = handler.getGrpEndPage();


//        System.out.println(start);
//        System.out.println(end);
//
//        System.out.println(handler.getTotalPage());
//        System.out.println(handler.getCurrentGrp());
//        System.out.println(handler.getGrpStartPage());
//        System.out.println(handler.getGrpEndPage());
//
//        System.out.println(start);
//        System.out.println(end);

        //이전
        if(handler.getGrpStartPage()>1){
            System.out.print("이전");
            System.out.print(handler.getGrpStartPage()-1);
        }


        // [1 2 3 4 5]
        for(int i=start; i<=end; i++){
            System.out.print("["+ i+"]");
        }




        //다음
        if(handler.getGrpEndPage()<handler.getTotalPage()){
            System.out.print("다음");
            System.out.print(handler.getGrpEndPage()+1);
        }


    }


}
