package zz.yy.xx.api.strategy;

import lombok.Data;

/**
 * SimpleFailureResponseModel:
 * 
 * <br>
 * created by good on 2025.03.
 */
@Data
public class SimpleFailureResponseModel {

    private String failureCode;
    private String failureText;

    public SimpleFailureResponseModel(String failureCode, String failureText) {
        this.failureCode = failureCode;
        this.failureText = failureText;
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
    public static SimpleFailureResponseModel of(String failureCode, String failureText) {
        return new SimpleFailureResponseModel(failureCode, failureText);
    }
}
