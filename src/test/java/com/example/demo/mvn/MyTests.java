package com.example.demo.mvn;


import com.epam.reportportal.junit5.ReportPortalExtension;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(ReportPortalExtension.class)
public class MyTests {

    private static final Logger LOGGER = LogManager.getLogger(MyTests.class);
    Random random = new Random();

    @Test
    void testMySimpleTest() {
        LOGGER.info("Hello from my simple test");
    }

    @Test
    void mytest_randomTest(){
        int i = random.nextInt(2);
        Integer integer = null;
        int x = integer + 5;
        System.out.println(integer);
        assertThat(i).isEqualTo(1);
    }

    @Test
    void mytest_randomTest1(){
        int i = random.nextInt(2);
        Integer integer = null;
        int x = integer + 5;
        System.out.println(integer);
        assertThat(i).isEqualTo(1);
    }

    @Test
    void mytest_randomTest2(){
        int i = random.nextInt(2);
        System.out.println(i);
        assertThat(i).isEqualTo(1);
    }

    @Test
    void mytest_randomTest3(){
        int i = random.nextInt(2);
        System.out.println(i);
        assertThat(i).isEqualTo(1);
    }

    @Test
    void mytest_randomTest4(){
        int i = random.nextInt(2);
        System.out.println(i);
        assertThat(i).isEqualTo(1);
    }
}