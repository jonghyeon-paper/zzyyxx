package zz.yy.xx.api.strategy;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import zz.yy.xx.exception.BusinessException;

/**
 * OthersExceptionHandler:
 * 
 * <br>
 * created by good on 2025.03.
 */
@Controller
@ControllerAdvice
public class OthersExceptionHandler {

    /**
     * handleBusinessException:
     * 
     * @param exception
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResponseEntity<OthersResponseWrapper<?>> handleBusinessException(BusinessException exception) {
        return ResponseEntity.status(exception.getHttpStatus()).body(
                OthersResponseWrapper.of(exception.getExtraCode(), exception.getExtraText(), exception.getBody()));
    }

    /**
     * handleUnknownException:
     * 
     * @param exception
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<OthersResponseWrapper<?>> handleUnknownException(RuntimeException exception) {
        OthersResponse respnose = OthersResponse.FAILURE;
        return ResponseEntity.status(respnose.getHttpStatus()).body(OthersResponseWrapper.of(respnose, null));
    }
}
