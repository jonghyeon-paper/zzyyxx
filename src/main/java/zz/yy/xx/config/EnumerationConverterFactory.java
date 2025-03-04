package zz.yy.xx.config;

import java.util.Objects;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * EnumerationConverterFactory:
 * 
 * <br>
 * created by good on 2025.03.
 */
public class EnumerationConverterFactory implements ConverterFactory<String, Enum<?>> {

    @Override
    public <T extends Enum<?>> Converter<String, T> getConverter(Class<T> enumClass) {
        Objects.requireNonNull(enumClass);
        if (!enumClass.isEnum()) {
            throw new RuntimeException(enumClass.getName() + " is not enum.");
        }
        return new EnumerationConverter<T>(enumClass);
    }
}
