package zz.yy.xx.api.strategy;

import org.springframework.http.HttpStatus;

import zz.yy.xx.core.attribute.SimpleResponse;

/**
 * AppsResponse:
 * 
 * <br>
 * created by good on 2025.03.
 */
public enum AppsResponse implements SimpleResponse {

    OK(HttpStatus.OK, "0001", "ok"),
    // add..
    FAILURE_UNKNOWN(HttpStatus.UNPROCESSABLE_ENTITY, "9001", "unknown error")
    // add..
    ;

    private HttpStatus httpStatus;
    private String extraCode;
    private String extraText;

    private AppsResponse(HttpStatus httpStatus, String extraCode, String extraText) {
        this.httpStatus = httpStatus;
        this.extraCode = extraCode;
        this.extraText = extraText;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getBody() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getExtraCode() {
        return extraCode;
    }

    @Override
    public String getExtraText() {
        return extraText;
    }
}
