package com.example.demo.mvn

import spock.lang.Specification
import spock.lang.Unroll

class RandomTest extends Specification {

    def random = new Random()

    def "should randomly draw 1"() {
        expect:
            random.nextInt(2) == 1
    }

    def "should always be true"() {
        expect:
            1 == 1
    }

    @Unroll
    def "should have given length"() {
        expect:
            word.length() == length
        where:
            word      | length
            "alfa"    | 4
            "bravo"   | 5
            "charlie" | 7
            "delta"   | 5
    }

}
