package com.example.day02Batis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


//@Transactional      //수행한다음에 롤백처리(=취소)하는거임
@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository repository;

    //@Test
    public void test(){
        int result = repository.selectAll().size();

        assertTrue(result >=1);
    }

    //@Test
    public void test2(){

        Member m = new Member();
        m.setId("a200");
        m.setPw("1212");
        m.setName("윤현기");

        repository.insert(m);

    }

    //조회 테스트
    //@Test
    public void test3(){
       Member2 member2 = repository.selectAll2().get(0);


       System.out.println(member2);
       String id = member2.getM_id();

       assertNotNull(id);


    }

    @Test
    public void test4(){
        Member2 member = repository.selectAll3().get(0);
        assertNotNull(member.getM_id());


    }


}