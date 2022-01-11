package com.example.demo.mvn;

import com.epam.reportportal.junit5.ReportPortalExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Java6Assertions.assertThat;

@ExtendWith(ReportPortalExtension.class)
public class EnumParametersTest {

    public enum TestParams {
        ONE,
        TWO
    }

    @ParameterizedTest
    @EnumSource(TestParams.class)
    public void testParameters_test1(TestParams param) {
        System.out.println("Test: " + param.name());
        assertThat(param == TestParams.ONE);
    }

    @ParameterizedTest
    @EnumSource(TestParams.class)
    public void testParameters_test2(TestParams param) {
        System.out.println("Test: " + param.name());
        assertThat(param == TestParams.TWO);
    }

}