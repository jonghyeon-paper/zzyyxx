package zz.yy.xx.config;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * JacksonConfig:
 * 
 * <br>
 * created by good on 2025.03.
 */
@Configuration
public class JacksonConfig {

    /**
     * jacksonCustomizer: a global object-mapper bean configuration. used in
     * view-resolver.
     * <ul>
     * <li>'null' attribute ignore.</li>
     * </ul>
     * 
     * @return
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonCustomizer() {
        return builder -> builder.serializationInclusion(Include.NON_NULL);
    }

    /**
     * enumerationConverterModule:
     * 
     * @return
     */
    @Bean
    public Module enumerationConverterModule() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Enum.class, new EnumerationDeserializer());
        module.addSerializer(Enum.class, new EnumerationSerializer());
        return module;
    }
}
