package com.npst.multipledatabases;

import com.npst.multipledatabases.service.LearningTestClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LearningTestClassTest {

    LearningTestClass learningTestClass;

    @BeforeEach
    void setUp() {
        learningTestClass = new LearningTestClass();
    }

    @Test
    @DisplayName("Demo-Test")
    void demoTestMethod() {
        assertTrue(true);
    }

    @Test
    @DisplayName("Add-Number-Positive-Test-1")
    void addNumbers_positive_test() {
        int result = learningTestClass.addNumbers(1,2,3,4,5);
        assertEquals(15,result,"Result not Matching");
    }

    @Test
    @DisplayName("Add-Number-Positive-Test-2")
    void addNumbers_positive_2_test() {
        int result = learningTestClass.addNumbers(1,-2,-3,4,5);
        assertEquals(5,result,"Result not Matching");
    }



}
