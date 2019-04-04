package com.ggomez1973.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class GatewayApplication {

//    @Bean
//    public DiscoveryClientRouteDefinitionLocator discoveryRoutes(DiscoveryClient dc){
//        return new DiscoveryClientRouteDefinitionLocator(dc, new DiscoveryLocatorProperties());
//    }

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder){
	    return builder.routes()
				.route(r -> r.path("/get") // http :8080/get
					.filters(gfs -> gfs.addRequestHeader("BCP", "Yerba bajo contenido en polvo"))
					.uri("http://httpbin.org:80"))

				.route(r -> r.host("*.rewrite.org")  // http :8080/foo/get Host:www.rewrite.org
					.filters(gfs -> gfs.rewritePath("/foo/(?<segment>.*)", "/${segment}"))
					.uri("http://httpbin.org:80"))

				.route(r -> r.host("www.hystrix.org")  // http :8080/delay/4 Host:www.hystrix.org
					.filters(gfs -> gfs.hystrix(config -> config.setName("mycmd")))
					.uri("http://httpbin.org:80"))

				.route(r -> r.path("/echo") // Web Sockets a traves del Gateway
					.uri("ws://localhost:9000"))
                .route(r -> r.path("/hey")  // Proxy? No anda!
                        .uri("lb://cable-service/telebosta"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
