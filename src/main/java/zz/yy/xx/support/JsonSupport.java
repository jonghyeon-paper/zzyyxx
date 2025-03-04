package zz.yy.xx.support;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * JsonSupport:
 * 
 * <br>
 * created by good on 2025.03.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class JsonSupport {

    private final ObjectMapper om;
    private ObjectMapper copiedOm;

    @PostConstruct
    private void postConstruct() {
        copiedOm = om.copy();
        //om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //om.setDefaultPropertyInclusion(Include.NON_NULL);
        //om.setDefaultPropertyInclusion(Include.NON_EMPTY);
    }

    /**
     * serialize: object to json format string
     * 
     * @param o input object
     * @return json format string
     */
    public String serialize(Object o) {
        try {
            return copiedOm.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            log.error("parse error:", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * deserialize: json format string to {@code T} class
     * 
     * @param <T> type of output class
     * @param s json format argument
     * @param typeReference type of output {@code TypeReference}
     * @return <code>T</code> class
     */
    public <T> T deserialize(String s, TypeReference<T> typeReference) {
        try {
            return copiedOm.readValue(s, typeReference);
        } catch (JsonMappingException e) {
            log.error("parse error:", e);
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            log.error("parse error:", e);
            throw new RuntimeException(e);
        }
    }
}
