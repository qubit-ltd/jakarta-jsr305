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

/**
 * Used to annotate a method parameter to indicate that this method will not
 * close the resource.
 *
 * @see WillClose
 * @see WillCloseWhenClosed
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface WillNotClose {

}
