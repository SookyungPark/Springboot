package com.example.prj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BangService {

    final BangRepository repository;

    @Autowired
    public BangService(BangRepository repository){
        this.repository = repository;
    }

    //조회
    public List<Bang> getBang(){
        return repository.selectAll();
    }

    //글 등록 서비스
    public int registerBang(Bang bang){
        return repository.insert(bang);
    }

    //작성자에 따른 글 조회
    public List<Bang> getBangByWriter(String writer) {
        return repository.selectByWriter(writer);
    }
}
