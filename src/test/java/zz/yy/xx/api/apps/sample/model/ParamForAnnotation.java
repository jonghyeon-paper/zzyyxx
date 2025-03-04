package zz.yy.xx.api.apps.sample.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ParamForAnnotation {

    @NotNull
    private String key;
    private String value;
}
