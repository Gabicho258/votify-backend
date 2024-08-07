package pe.edu.unsa.votify_apigateway.settups;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;



@Slf4j

@Configuration
public class GlobalPostFiltering {
    @Bean
    public GlobalFilter postGlobalFilter(){
        return (exchange, chain) -> {
            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> {
                        log.info("Global Post Filter executed");
                    }));
        };
    }
}
