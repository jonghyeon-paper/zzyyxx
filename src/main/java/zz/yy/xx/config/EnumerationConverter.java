package zz.yy.xx.config;

import java.util.stream.Stream;

import org.springframework.core.convert.converter.Converter;

import jakarta.validation.Valid;
import zz.yy.xx.core.attribute.CodeConversion;

/**
 * EnumerationConverter:
 * 
 * <br>
 * created by good on 2025.03.
 */
public class EnumerationConverter<T extends Enum<?>> implements Converter<String, T> {

    private final Class<T> enumClass;

    public EnumerationConverter(Class<T> enumClass) {
        this.enumClass = enumClass;
    }

    /**
     * If binding fails due to using @link {@link Valid} annotation, a
     * MethodArgumentNotValidException is thrown. If binding fails due to invalid
     * values, a MethodArgumentNotValidException is thrown. If null value is
     * possible, no exception.
     */
    @Override
    public T convert(String source) {
        if (CodeConversion.class.isAssignableFrom(enumClass)) {
            return Stream.of(enumClass.getEnumConstants())
                    .filter(item -> ((CodeConversion<?>) item).toCode().equals(source))
                    .findFirst().orElse(null);
        } else {
            // didn't extends 'CodeConversion' todo..
            return Stream.of(enumClass.getEnumConstants()).filter(item -> item.name().equals(source))
                    .findFirst().orElse(null);
        }
    }

}
