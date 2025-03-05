package zz.yy.xx.core.attribute;

import org.springframework.http.HttpStatus;

/**
 * SimpleResponse:
 * 
 * <br>
 * created by good on 2025.03.
 */
public interface SimpleResponse {

    /**
     * getHttpStatus:
     * 
     * @return
     */
    HttpStatus getHttpStatus();

    /**
     * getBody:
     * 
     * @return
     */
    String getBody();

    /**
     * getExtraCode:
     * 
     * @return
     */
    String getExtraCode();

    /**
     * getExtraMessage:
     * 
     * @return
     */
    String getExtraMessage();
}
