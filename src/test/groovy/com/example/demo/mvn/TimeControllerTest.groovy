package com.example.demo.mvn

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TimeControllerTest extends Specification {

    @Autowired
    MockMvc mockMvc

    def "should return current time and date in iso"() {
        when:
            def response = mockMvc.perform(get("/now"))
        then:
            response.andExpect(status().isOk())
    }

}
