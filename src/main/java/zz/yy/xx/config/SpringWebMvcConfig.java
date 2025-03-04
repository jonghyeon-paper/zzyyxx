package zz.yy.xx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SpringWebMvcConfig:
 * 
 * <br>
 * created by good on 2025.03.
 */
@Configuration
public class SpringWebMvcConfig {

    /**
     * webMvcConfig:
     * 
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfig() {
        return new WebMvcConfigurer() {

            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverterFactory(new EnumerationConverterFactory());
            }
        };
    }
}
