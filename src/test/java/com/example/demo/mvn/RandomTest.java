package com.example.demo.mvn;

import com.epam.reportportal.junit5.ReportPortalExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Random;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(ReportPortalExtension.class)
public class RandomTest {

    Random random = new Random();

    @Test
    void randomTest_randomTest1(){
        int i = random.nextInt(2);
        Integer integer = null;
        int x = integer + 5;
        System.out.println(integer);
        assertThat(i).isEqualTo(1);
    }

    @Test
    void randomTest_randomTest2(){
        int i = random.nextInt(2);
        Integer integer = null;
        int x = integer + 5;
        System.out.println(integer);
        assertThat(i).isEqualTo(1);
    }

    @Test
    void randomTest_randomTest3(){
        int i = random.nextInt(2);
        System.out.println(i);
        assertThat(i).isEqualTo(1);
    }

    @Test
    void randomTest_randomTest4(){
        int i = random.nextInt(2);
        System.out.println(i);
        assertThat(i).isEqualTo(1);
    }

    @Test
    void randomTest_randomTest5(){
        int i = random.nextInt(2);
        System.out.println(i);
        assertThat(i).isEqualTo(1);
    }
}
