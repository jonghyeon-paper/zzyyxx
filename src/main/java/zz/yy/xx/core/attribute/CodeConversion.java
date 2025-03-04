package zz.yy.xx.core.attribute;

import java.util.Objects;

/**
 * CodeConversion:
 * 
 * <br>
 * created by good on 2025.03.
 *
 * @param <T> type of code
 */
public interface CodeConversion<T> {

    /**
     * code(or value) return
     * 
     * @return <code>T</code>
     */
    T toCode();

    /**
     * fromCode:
     * 
     * @param <T> type of code
     * @param <E> class type of enum
     * @param code
     * @param targetType
     * @param nullable
     * @return
     */
    static <T, E extends Enum<?> & CodeConversion<T>> E fromCode(T code, Class<E> targetType, boolean nullable) {
        Objects.requireNonNull(code);
        Objects.requireNonNull(code);
        if (!targetType.isEnum()) {
            throw new RuntimeException(targetType.getName() + " is not enum.");
        }
        for (E item : targetType.getEnumConstants()) {
            if (item.toCode().equals(code)) {
                return item;
            }
        }
        if (nullable) {
            return null;
        }
        throw new RuntimeException("failed to convert '" + code + "' code to '" + targetType.getName() + "'");
    }
}
