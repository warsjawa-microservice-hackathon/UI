package com.ofg.warsjawa.controller

import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient
import com.ofg.twitter.controller.place.extractor.CityFinder
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.validation.constraints.NotNull

import static org.springframework.web.bind.annotation.RequestMethod.POST

@Slf4j
@RestController
@RequestMapping('/client')
@Api(value = "client", description = "Operations on clients")
class ClientController {

    @Autowired
    ServiceRestClient serviceRestClient

    @RequestMapping(
            value = '/loan',
            method = POST)
    @ApiOperation(value = "proccess loan ",
            notes = "a mega api call")
    String applyForLoan(  @RequestBody @NotNull Client client) {
        log.info("name: ${client.name}, surname: ${client.surname} age: ${client.age}, job:${client.jobPosition}, loanAmount: ${client.loanAmount}")

       def uid =  UUID.randomUUID()

        def smth =  serviceRestClient.forService("client-service").post()
                .onUrl('/clients')
                .body("""{
                        "firstName" : "${client.name}",
                        "lastName" : "${client.surname}",
                        "id" : "${uid}"
                    }""")
                .withHeaders()
                .contentTypeJson()
                .andExecuteFor()
                .anObject()
                .ofType(String)

        def smth2 =  serviceRestClient.forService("loan-service").put()
                .onUrl("/api/loanApplication/${uid}")
                .body("""{
                        "firstName" : "${client.name}",
                        "lastName" : "${client.surname}",
                        "job" : "${client.jobPosition}",
                         "amount" : ${client.loanAmount}
                    }""")
                .withHeaders()
                .contentTypeJson()
                .andExecuteFor()
                .anObject()
                .ofType(String)

        return "{id:${uid}}"
    }
}
