package zz.yy.xx.misc;

import java.util.Objects;

/**
 * MutablePhaseChain:
 * 
 * <br>
 * created by good on 2025.03.
 * 
 * @param <S> type of first input source
 * @param <R> type of result
 */
public class MutablePhaseChain<S, R> {

    private S source;
    private R result;

    private MutablePhaseChain(S source, R result) {
        this.source = source;
        this.result = result;
    }

    /**
     * next: execute phase and configure the next chain.
     * 
     * @param <NEW_R> type of new result
     * @param nextPhase
     * @return
     */
    public <NEW_R> MutablePhaseChain<S, NEW_R> next(MutablePhase<S, R, NEW_R> nextPhase) {
        Objects.requireNonNull(nextPhase);
        return new MutablePhaseChain<>(source, nextPhase.execute(source, result));
    }

    /**
     * result:
     * 
     * @return
     */
    public R result() {
        return result;
    }

    /**
     * start: create first phase
     * 
     * @param <S> type of source
     * @param sourcrData
     * @return
     */
    public static <S> MutablePhaseChain<S, S> start(S sourceData) {
        return new MutablePhaseChain<S, S>(sourceData, sourceData);
    }
}
