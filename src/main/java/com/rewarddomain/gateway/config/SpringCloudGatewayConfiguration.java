package com.rewarddomain.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class SpringCloudGatewayConfiguration {
	
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/get")
                        .filters(f -> f.addRequestHeader("myHeaderParam", "headerParamValue")
                                .addRequestParameter("myParameter", "paramValue"))
                        .uri("http://httpbin.org:80"))
                
                .route(p -> p
						.path("/currency-exchange-app/**")
						.uri("lb://CURRENCY-EXCHANGE-SERVICE"))
                .build();
    }
	
}
