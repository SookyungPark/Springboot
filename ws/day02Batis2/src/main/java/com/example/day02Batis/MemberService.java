package com.example.day02Batis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MemberService {

    final MemberRepository repository;



    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    //회원조회 서비스
    public List<Member> getMembers(){
        return repository.selectAll();
    }

    //회원가입 서비스
    public int registerMember(Member member){
        return repository.insert(member);
    }
}
