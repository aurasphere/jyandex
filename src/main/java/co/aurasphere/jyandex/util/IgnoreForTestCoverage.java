package co.aurasphere.jyandex.util;

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
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface IgnoreForTestCoverage {

}
