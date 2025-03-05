package zz.yy.xx.api.strategy;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * AppsExceptionHandler:
 * 
 * <br>
 * created by good on 2025.03.
 */
@Controller
@ControllerAdvice
public class AppsExceptionHandler {

    /**
     * handleUnknownException:
     * 
     * @param exception
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<SimpleFailureResponseModel> handleUnknownException(RuntimeException exception) {
        AppsResponse respnose = AppsResponse.FAILURE_UNKNOWN;
        return ResponseEntity.status(respnose.getHttpStatus()).body(SimpleFailureResponseModel
                .of(respnose.getExtraCode(), respnose.getExtraText() + ":\n" + exception.getMessage()));
    }
}
