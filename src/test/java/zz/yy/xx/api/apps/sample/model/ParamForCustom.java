package zz.yy.xx.api.apps.sample.model;

import lombok.Data;
import zz.yy.xx.exception.ParameterException;
import zz.yy.xx.exception.ParameterValidation;

@Data
public class ParamForCustom implements ParameterValidation {

    private String key;
    private String value;

    @Override
    public boolean isValid(boolean throwable) {
        return isValid(throwable, () -> {
            if (key == null) {
                throw new ParameterException("'key' required.");
            }
        });
    }
}
