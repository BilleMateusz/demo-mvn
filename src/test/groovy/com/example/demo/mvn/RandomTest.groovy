package com.example.demo.mvn

import com.google.common.io.BaseEncoding
import org.slf4j.LoggerFactory
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll
import com.google.common.io.Resources


class RandomTest extends Specification {

    def random = new Random()
    @Shared
    String CLASS_NAME = getClass().getName()
    @Shared
    def logger = LoggerFactory.getLogger(CLASS_NAME)

//    def setup() {
//        logger.debug("before each method")
//    }

    def cleanupSpec() {
//        def file = new File("target/surefire-reports/${RandomTest.class.getName()}.txt")
//        def content = Resources.asByteSource(file.toURI().toURL()).read()
//        String reportState_label = ""
//        logger.debug("#RP_MESSAGE#BASE64#${BaseEncoding.base64().encode(content)}#${reportState_label}")
    }

    def "should randomly draw 1 "() {
        when:
            def drawn = random.nextInt(2)
            logger.info("randomly drew $drawn")
        then:
            drawn == 1
    }

    def "should always be true"() {
        expect:
            1 == 1
    }

    @Unroll('#word of length #length')
    def "should have given length"() {
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
