package com.example.demo.mvn

import com.epam.reportportal.annotations.Step
import spock.lang.Specification
import spock.lang.Unroll

class MockingListSpec extends Specification {

    List<String> stringList = Mock()

    @Step
    @Unroll
    def "should have size equal to 3"() {
        given:
            stringList.size() >> size
        when:
            int result = stringList.size()
        then:
            result == 3
        where:
            size << [1,2,3]
    }

    @Step
    @Unroll
    def "should return a word containing 'a'"() {
        given:
            stringList.get(_ as Integer) >> word
        when:
            String result = stringList.get(index)
        then:
            result.contains("a")
        where:
            [index, word] << [[1,"alfa"],
                             [2,"bravo"],
                             [3,"charlie"]]
    }

}
