package zz.yy.xx.exception;

import org.springframework.http.HttpStatus;

import lombok.EqualsAndHashCode;
import zz.yy.xx.core.attribute.SimpleResponse;

/**
 * BusinessException:
 * 
 * <br>
 * created by good on 2025.03.
 */
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends RuntimeException implements SimpleResponse {

    private static final long serialVersionUID = 9182664201848370802L;

    private SimpleResponse simpleResponse;

    public BusinessException(SimpleResponse simpleResponse) {
        this.simpleResponse = simpleResponse;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return simpleResponse.getHttpStatus();
    }

    @Override
    public String getBody() {
        return simpleResponse.getBody();
    }

    @Override
    public String getExtraCode() {
        return simpleResponse.getExtraCode();
    }

    @Override
    public String getExtraText() {
        return simpleResponse.getExtraText();
    }
}
