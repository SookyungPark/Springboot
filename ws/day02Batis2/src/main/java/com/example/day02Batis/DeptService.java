package com.example.day02Batis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class DeptService {

    @Autowired
    DeptRepository repository;


    public List<Map<String, Object>> getDeptList(){
        return repository.selectAll();
    }




}
