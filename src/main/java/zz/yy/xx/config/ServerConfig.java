package zz.yy.xx.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * ServerConfig:
 * 
 * <br>
 * created by good on 2025.03.
 */
@Configuration
public class ServerConfig {

    /**
     * webServerFactoryCustomizer:
     * 
     * @return
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
        return factory -> factory.setContextPath("");
    }

    /**
     * localServer:
     * 
     * @return
     */
    @Profile("local")
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> localServer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8080);
            }
        };
    }

    /**
     * server:
     * 
     * @return
     */
    @Profile("!local")
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> server() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8080);
            }
        };
    }
}
