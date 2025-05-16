package com.example.prj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class BangRepositoryTest {
    @Autowired
    BangRepository repository;

    @Test
    public void test(){
        int result = repository.selectAll().size();

        assertTrue(result >=1);
    }
}