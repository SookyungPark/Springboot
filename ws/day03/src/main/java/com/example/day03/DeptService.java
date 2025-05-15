package com.example.day03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {


    @Autowired
    DeptRepository repository;

    public List<Dept> getDept(Dept dept){
        return repository.dept(dept);
    }


}
