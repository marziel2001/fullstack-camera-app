package JavaLab;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab4GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab4GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
        RouteLocatorBuilder builder,
        @Value("${lab.model.url}") String modelUrl,
        @Value("${lab.brand.url}") String brandUrl,
        @Value("${lab.gatewy.host}") String host
    )
    {
        return builder
            .routes()
            .route("models", route -> route
                .host(host)
                .and()
                .path(
                    "/api/models",
                    "/api/models/{id}",
                    "/api/brands/{id}/models"

                )
                .uri(modelUrl)
                )
            .route("brands", route -> route
                .host(host)
                .and()
                .path(
                    "/api/brands/{id}",
                    "/api/brands"
                )
                .uri(brandUrl)
            )
            .build();
    }

}
