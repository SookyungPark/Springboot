package com.example.day06Prac;

public class PageHandlerMain {

    public static void main(String[] args) {

        //페이징관련 데이터처리
        //1. 현재페이지 (기본값:1, 사용자가 선택한 페이지)
        //2. 한 페이지에 보이는 글의 수 (=페이지 사이즈)
        //3. 그룹의 사이즈 ([1 2 3] [1 2 3 4 5])
        //4. 전체 레코드 수 : db
        //5. 전체페이지수 수하기 (전체 레코드수 / 페이지 사이즈), 나머지 있는 경우는 +1
        //6. 현재 페이지에 대한 현재그룹 구하기 (전체페이지수 / 그룹의 사이즈), 나머지 있으면 +1
        //7. 현재그룹에 대한 그룹시작, 그룹끝 구하기
        //  그룹시작 : (현재그룹-1)*그룹사이즈+1
        //  그룹의 끝 : 현재그룹*그룹 사이즈
        //8. 그룹 끝 확인하기 (전체 페이지수보다 큰지 확인 ㄱ)
        //9. 현재 그룹 시작~현재그룹 마지막까지 반복
        //10. 이전, 다음 처리


        int currentPage;
        int pageSize; //한 페이지에 몇개씩 볼거니?
        int grpSize;
        int totRecords;

        int totalPage;
        int currentGrp;
        int grpStartPage;
        int grpEndPage;

        currentPage=6;
        pageSize=4;
        grpSize=5;
        totRecords=37;

        int remain = totRecords%pageSize;
        if(remain==0){
            totalPage = totRecords/pageSize;
        }else{
            totalPage=(totRecords/pageSize)+1;
        }



        //현재그룹 구하기
        int remain2 = currentPage %grpSize;
        if(remain2==0){
            currentGrp=currentPage/grpSize;
        }else{
            currentGrp=(currentPage/grpSize)+1;
        }

        //현재그룹의 시작번호
        //현재그룹의 마지막번호

        grpStartPage=(currentGrp-1)*grpSize+1; //=1
        grpEndPage=currentGrp*grpSize;  //=1*5 =>5


        //그룹의 마지막 확인하기
        if(grpEndPage>totalPage){
            grpEndPage=totalPage;
        }


        System.out.println(currentPage);
        System.out.println(pageSize);
        System.out.println(grpSize);
        System.out.println(totRecords);

        System.out.println(totalPage);
        System.out.println(currentGrp);
        System.out.println(grpStartPage);
        System.out.println(grpEndPage);

        for(int i=grpStartPage; i<=grpEndPage; i++){
            System.out.print(i+" ");
        }







    }


}
