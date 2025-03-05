package zz.yy.xx.api.strategy;

import lombok.Data;
import zz.yy.xx.core.attribute.SimpleResponse;

/**
 * ApiResponseResultWrapper:
 * 
 * <br>
 * created by good on 2025.03.
 * 
 * @param <T> type of result
 */
@Data
public class OthersResponseWrapper<T> {

    public String code;
    public String message;
    public T result;

    private OthersResponseWrapper(String code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    /**
     * of:
     * 
     * @param <T>
     * @param code
     * @param message
     * @param result
     * @return
     */
    public static <T> OthersResponseWrapper<T> of(String code, String message, T result) {
        return new OthersResponseWrapper<T>(code, message, result);
    }

    /**
     * of:
     * 
     * @param <T>
     * @param simpleResponse
     * @param result
     * @return
     */
    public static <T> OthersResponseWrapper<T> of(SimpleResponse simpleResponse, T result) {
        return of(simpleResponse.getExtraCode(), simpleResponse.getExtraText(), result);
    }

    /**
     * of:
     * 
     * @param <T>
     * @param result
     * @return
     */
    public static <T> OthersResponseWrapper<T> of(T result) {
        return of(OthersResponse.SUCCESS, result);
    }
}
