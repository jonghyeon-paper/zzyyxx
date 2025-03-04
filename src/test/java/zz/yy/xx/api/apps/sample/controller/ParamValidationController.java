package zz.yy.xx.api.apps.sample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import zz.yy.xx.api.apps.sample.model.ParamForAnnotation;
import zz.yy.xx.api.apps.sample.model.ParamForCustom;
import zz.yy.xx.exception.ParameterException;

@RestController
@RequestMapping("/sample")
public class ParamValidationController {

    @GetMapping("/validation-using-annotation")
    public ResponseEntity<?> usingAnnotation(@Valid ParamForAnnotation parameters) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/validation-using-custom")
    public ResponseEntity<?> usingCustom(ParamForCustom parameters) {
        parameters.isValid(true);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(ParameterException.class)
    public ResponseEntity<?> localExceptionHandler(ParameterException e) {
        return new ResponseEntity<>("parameter-exception: e:" + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
