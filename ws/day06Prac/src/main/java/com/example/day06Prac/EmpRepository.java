package com.example.day06Prac;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//DAO 또는 Mapper
@Repository
public class EmpRepository {

    @Autowired
    SqlSession session;

    public List<Emp> selectAll(){
        return session.selectList("a.selectAll");
    }

    public List<Emp>selectPage(int currentPage, int pageSize){  //현재페이지, 한페이지에 몇개씩볼래?
        int start = (currentPage-1)*pageSize+1;
        int end = currentPage * pageSize;

        Map<String, Integer> pageInfo = new HashMap<>();
        pageInfo.put("start", start);
        pageInfo.put("end", end);

        return session.selectList("a.selectPage" , pageInfo);


    }


}
