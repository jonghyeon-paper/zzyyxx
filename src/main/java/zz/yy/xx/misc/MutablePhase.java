package zz.yy.xx.misc;

/**
 * MutablePhase:
 * 
 * <br>
 * created by good on 2025.03.
 * 
 * @param <S> type of first input source
 * @param <P> type of previous
 * @param <R> type of result
 */
@FunctionalInterface
public interface MutablePhase<S, P, R> {

    R execute(S source, P previous);
}
