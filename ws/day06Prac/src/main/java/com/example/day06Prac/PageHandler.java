package com.example.day06Prac;

public class PageHandler {

        int currentPage;
        int pageSize; //한 페이지에 몇개씩 볼거니?
        int grpSize;
        int totRecords;

        int totalPage;
        int currentGrp;
        int grpStartPage;
        int grpEndPage;

    public PageHandler(int currentPage, int pageSize, int grpSize, int totRecords) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.grpSize = grpSize;
        this.totRecords = totRecords;
        pageCalc();

    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getGrpSize() {
        return grpSize;
    }

    public void setGrpSize(int grpSize) {
        this.grpSize = grpSize;
    }

    public int getTotRecords() {
        return totRecords;
    }

    public void setTotRecords(int totRecords) {
        this.totRecords = totRecords;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentGrp() {
        return currentGrp;
    }

    public void setCurrentGrp(int currentGrp) {
        this.currentGrp = currentGrp;
    }

    public int getGrpStartPage() {
        return grpStartPage;
    }

    public void setGrpStartPage(int grpStartPage) {
        this.grpStartPage = grpStartPage;
    }

    public int getGrpEndPage() {
        return grpEndPage;
    }

    public void setGrpEndPage(int grpEndPage) {
        this.grpEndPage = grpEndPage;
    }

    private void pageCalc(){
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

        /*
        System.out.println(currentPage);
        System.out.println(pageSize);
        System.out.println(grpSize);
        System.out.println(totRecords);

        System.out.println(totalPage);
        System.out.println(currentGrp);
        System.out.println(grpStartPage);
        System.out.println(grpEndPage);
        */

        for(int i=grpStartPage; i<=grpEndPage; i++){
            System.out.print(i+" ");
        }
    }
}
