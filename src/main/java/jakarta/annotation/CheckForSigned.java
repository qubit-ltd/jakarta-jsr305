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

import jakarta.annotation.meta.TypeQualifierNickname;
import jakarta.annotation.meta.When;

/**
 * Used to annotate a value that may be either negative or nonnegative, and
 * indicates that uses of it should check for
 * negative values before using it in a way that requires the value to be
 * nonnegative, and check for it being nonnegative before using it in a way that
 * requires it to be negative.
 */
@Documented
@TypeQualifierNickname
@Nonnegative(when = When.MAYBE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckForSigned {

}
