////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2025.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package jakarta.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import jakarta.annotation.meta.TypeQualifier;
import jakarta.annotation.meta.TypeQualifierValidator;
import jakarta.annotation.meta.When;

/**
 * This annotation is used to annotate a value that should only contain nonnegative values.
 * <p>
 * When this annotation is applied to a method it applies to the method return value.
 */
@Documented
@TypeQualifier(applicableTo = Number.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Nonnegative {
    When when() default When.ALWAYS;

    class Checker implements TypeQualifierValidator<Nonnegative> {

        public When forConstantValue(final Nonnegative annotation, final Object v) {
            if (!(v instanceof Number))
                return When.NEVER;
            final boolean isNegative;
            final Number value = (Number) v;
            if (value instanceof Long)
                isNegative = value.longValue() < 0;
            else if (value instanceof Double)
                isNegative = value.doubleValue() < 0;
            else if (value instanceof Float)
                isNegative = value.floatValue() < 0;
            else
                isNegative = value.intValue() < 0;

            if (isNegative)
                return When.NEVER;
            else
                return When.ALWAYS;

        }
    }
}
