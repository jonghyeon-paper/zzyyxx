package zz.yy.xx.api.strategy;

import org.springframework.http.HttpStatus;

import zz.yy.xx.core.attribute.SimpleResponse;

/**
 * OthersResponse:
 * 
 * <br>
 * created by good on 2025.03.
 */
public enum OthersResponse implements SimpleResponse {

    SUCCESS(HttpStatus.OK, "0000", "success"),
    // add..
    FAILURE(HttpStatus.BAD_REQUEST, "9999", "failure")
    // add..
    ;

    private HttpStatus httpStatus;
    private String extraCode;
    private String extraText;

    private OthersResponse(HttpStatus httpStatus, String extraCode, String extraText) {
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
        return extraCode;
    }

    @Override
    public String getExtraCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getExtraText() {
        return extraText;
    }
}
