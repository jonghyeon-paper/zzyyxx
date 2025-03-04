package zz.yy.xx.config;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import zz.yy.xx.core.attribute.CodeConversion;

/**
 * EnumerationSerializer:
 * 
 * <br>
 * created by good on 2025.03.
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class EnumerationSerializer extends StdSerializer<Enum> implements ContextualSerializer {

    private static final long serialVersionUID = 1534801559712436017L;

    public EnumerationSerializer() {
        this(null);
    }

    protected EnumerationSerializer(Class<Enum> t) {
        super(t);
    }

    @Override
    public void serialize(Enum value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (CodeConversion.class.isAssignableFrom(handledType())) {
            gen.writeObject(((CodeConversion<?>) value).toCode());
        } else {
            // didn't extends 'CodeConversion' todo..
            gen.writeObject(value.name());
        }
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property)
            throws JsonMappingException {
        return new EnumerationSerializer((Class<Enum>) property.getType().getRawClass());
    }
}
