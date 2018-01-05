package co.aurasphere.jyandex.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Utility annotation used to tell Cobertura to ignore a method while
 * calculating the test coverage.
 * 
 * @author Donato Rimenti
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface IgnoreForTestCoverage {

}
