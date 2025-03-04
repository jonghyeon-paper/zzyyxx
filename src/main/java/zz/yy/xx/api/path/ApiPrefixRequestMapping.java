package zz.yy.xx.api.path;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ApiPrefixRequestMapping:
 * 
 * <br>
 * created by good on 2025.03.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(value = FixedPath.VERSION_PATH)
public @interface ApiPrefixRequestMapping {

}
