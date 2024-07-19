package com.npst.multipledatabases.service;

import org.springframework.stereotype.Service;

@Service
public class LearningTestClass {
    public int addNumbers(int... data){
        int result = 0;
        for(int i : data){
            result+=i;
        }
        return result;
    }
}
