package zz.yy.xx.exception;

/**
 * SelfConsumer:
 * 
 * <br>
 * created by good on 2025.03.
 */
@FunctionalInterface
public interface SelfConsumer {

    /**
     * no input, no output.
     */
    void run();
}
