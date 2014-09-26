package com.ofg.warsjawa.controller

import com.ofg.twitter.controller.place.extractor.CityFinder
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.validation.constraints.NotNull

import static org.springframework.web.bind.annotation.RequestMethod.POST

@Slf4j
@RestController
@RequestMapping('/client')
@Api(value = "client", description = "Operations on clients")
class ClientController {



    @RequestMapping(
            value = '/{name}/{surname}/{age}/{jobPosition}/{loanAmount}',
            method = POST)
    @ApiOperation(value = "proccess loan ",
            notes = "a mega api call")
    String findCity( @NotNull String name, @NotNull String surname,@NotNull Integer age,@NotNull String jobPosition,Integer loanAmount) {
        log.info("name: ${name}, surname: ${surname} age: ${age}, job:${jobPosition}, loanAmount: ${loanAmount}")
        return "{}"
    }
}
