////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2025.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package jakarta.annotation.concurrent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The field or method to which this annotation is applied can only be accessed
 * when holding a particular lock, which may be a built-in (synchronization)
 * lock, or may be an explicit {@link java.util.concurrent.locks.Lock}.
 * <p>
 * The argument determines which lock guards the annotated field or method:
 * <ul>
 * <li>this : The string literal "this" means that this field is guarded by the class in which it is defined.
 * <li>class-name.this : For inner classes, it may be necessary to disambiguate 'this';
 * the class-name.this designation allows you to specify which 'this' reference is intended
 * <li>itself : For reference fields only; the object to which the field refers.
 * <li>field-name : The lock object is referenced by the (instance or static) field specified by field-name.
 * <li>class-name.field-name : The lock object is reference by the static field specified by class-name.field-name.
 * <li>method-name() : The lock object is returned by calling the named nil-ary method.
 * <li>class-name.class : The Class object for the specified class should be used as the lock object.
 * </ul>
 */
@Target( { ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.CLASS)
public @interface GuardedBy {
    String value();
}
