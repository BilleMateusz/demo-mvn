package com.example.demo.mvn

import org.slf4j.LoggerFactory
import spock.lang.Specification
import spock.lang.Unroll

class RandomSpec extends Specification {

    def random = new Random()
    def logger = LoggerFactory.getLogger(getClass().getName());

    def "should randomly draw 1 spec"() {
        when:
            def drawn = random.nextInt(2)
            logger.info("randomly drew $drawn")
        then:
            drawn == 1
    }

    def "should always be true spec"() {
        expect:
            1 == 1
    }

    @Unroll('#word of length #length')
    def "should have given length spec"() {
        given:
            logger.info("length of $word should be $length")
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
