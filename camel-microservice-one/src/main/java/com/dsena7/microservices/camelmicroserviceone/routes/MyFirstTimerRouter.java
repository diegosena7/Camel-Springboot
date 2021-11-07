package com.dsena7.microservices.camelmicroserviceone.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class MyFirstTimerRouter extends RouteBuilder {

    @Autowired private GetCurrentyTimeBean getCurrentyTimeBean;

    @Override
    public void configure() throws Exception {
        from("timer: first-timer")
//                .transform().constant("Hello World, chamaaaa bb...")
//                .transform().constant("Time now is: " + LocalDateTime.now())
                .bean(getCurrentyTimeBean, "getCurrentyTime")
        .to("log:first-timer");
    }
}

@Component
class GetCurrentyTimeBean{
    public String getCurrentyTime(){
        return "Time now is: " + LocalDateTime.now();
    }
}