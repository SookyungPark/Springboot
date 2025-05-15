package com.example.day03;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
select * from dept;
deptno  dname   loc
10	ACCOUNTING	NEW YORK
20	RESEARCH	DALLAS
30	SALES	CHICAGO
40	OPERATIONS	BOSTON


 */
@Repository
public class DeptRepository {

    @Autowired
    SqlSession session;


    public List<Dept> dept(Dept dept){

        return session.selectList("getDeptList", dept);
    }


}
