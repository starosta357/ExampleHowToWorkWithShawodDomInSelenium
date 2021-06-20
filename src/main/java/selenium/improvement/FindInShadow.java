package selenium.improvement;


import org.openqa.selenium.By;
import org.openqa.selenium.support.AbstractFindByBuilder;
import org.openqa.selenium.support.PageFactoryFinder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@PageFactoryFinder(FindInShadow.FindByCustomBuilder.class)
public @interface FindInShadow {

    String css() default "";

    class FindByCustomBuilder extends AbstractFindByBuilder {
        public By buildIt(Object annotation, Field field) {
            FindInShadow findInShadow = (FindInShadow) annotation;
            return ByShadow.css(findInShadow.css());
        }

    }

}

