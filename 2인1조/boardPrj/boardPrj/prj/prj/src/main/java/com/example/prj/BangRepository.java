package com.example.prj;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BangRepository {

    @Autowired
    SqlSession session;

    public List<Bang>selectAll(){
        return session.selectList("a.selectAll");
    }

    //등록
    public int insert(Bang bang)
    {
        return session.insert("a.insert",bang);
    }


    public List<Bang> selectByWriter(String writer) {
        return session.selectList("a.selectByWriter", writer);
    }




    //전체 조회 내가했다
    /*
    public List<Bang> selectAll(){
        List<Bang>bangList = session.selectList("a.SelectAll");
        return bangList;
    }

    public int insert (Bang bang){
        return session.insert("a.insert", bang);
    }

     */
    //전체 조회 내가했다


}
