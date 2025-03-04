package zz.yy.xx.config;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import zz.yy.xx.core.attribute.CodeConversion;

/**
 * EnumerationDeserializer:
 * 
 * <br>
 * created by good on 2025.03.
 */
public class EnumerationDeserializer extends StdDeserializer<Enum<?>> implements ContextualDeserializer {

    private static final long serialVersionUID = 8780990251921112053L;

    public EnumerationDeserializer() {
        this(null);
    }

    protected EnumerationDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Enum<?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        if (CodeConversion.class.isAssignableFrom(handledType())) {
            for (Enum<?> item : (Enum<?>[]) handledType().getEnumConstants()) {
                if (((CodeConversion<?>) item).toCode().equals(p.getValueAsString())) {
                    return item;
                }
            }
        } else {
            // didn't extends 'CodeConversion' todo..
            for (Enum<?> item : (Enum<?>[]) handledType().getEnumConstants()) {
                if (item.name().equals(p.getValueAsString())) {
                    return item;
                }
            }
        }
        return null;
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
            throws JsonMappingException {
        return new EnumerationDeserializer(property.getType().getRawClass());
    }
}
