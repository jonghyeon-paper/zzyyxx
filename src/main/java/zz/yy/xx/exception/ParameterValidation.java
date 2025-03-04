package zz.yy.xx.exception;

/**
 * ParameterValidation:
 * 
 * <br>
 * created by good on 2025.03.
 */
public interface ParameterValidation {

    /**
     * verify parameters
     * 
     * @param throwable 
     * @return 
     */
    boolean isValid(boolean throwable);

    /**
     * verify parameters
     * 
     * @param throwable if 'true', {@link ParameterException} throw. if 'false',
     *                  return boolean.
     * @param consumer
     * @return 'true' verified. 'false' not.
     */
    default boolean isValid(boolean throwable, SelfConsumer consumer) {
        try {
            consumer.run();
        } catch (ParameterException e) {
            if (throwable) {
                throw e;
            } else {
                return false;
            }
        }
        return true;
    }
}
