////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2025.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////

/**
 * Meta-annotations for creating custom type qualifiers and validation rules.
 * <p>
 * This package provides the foundational annotations for building custom
 * type qualifiers and defining validation logic. These meta-annotations
 * allow you to create domain-specific annotations that can be understood
 * by static analysis tools.
 * <p>
 * <strong>Core Meta-Annotations:</strong>
 * <ul>
 * <li>{@link jakarta.annotation.meta.TypeQualifier} - Marks an annotation
 *     as a type qualifier that can be used for static analysis.</li>
 * <li>{@link jakarta.annotation.meta.TypeQualifierNickname} - Creates a
 *     nickname annotation that inherits behavior from another qualifier.</li>
 * <li>{@link jakarta.annotation.meta.TypeQualifierDefault} - Specifies
 *     default qualifier behavior for elements in a scope.</li>
 * <li>{@link jakarta.annotation.meta.TypeQualifierValidator} - Interface
 *     for implementing custom validation logic.</li>
 * </ul>
 * <p>
 * <strong>Supporting Annotations:</strong>
 * <ul>
 * <li>{@link jakarta.annotation.meta.When} - Enumeration specifying when
 *     a qualifier condition holds (ALWAYS, MAYBE, NEVER, UNKNOWN).</li>
 * <li>{@link jakarta.annotation.meta.Exclusive} - Indicates mutually
 *     exclusive qualifiers.</li>
 * <li>{@link jakarta.annotation.meta.Exhaustive} - Indicates complete
 *     coverage of possible values.</li>
 * </ul>
 * <p>
 * <strong>Creating Custom Qualifiers:</strong>
 * <p>
 * Example of creating a custom type qualifier:
 * <pre>{@code
 * @Documented
 * @TypeQualifier
 * @Retention(RetentionPolicy.RUNTIME)
 * public @interface Positive {
 *   When when() default When.ALWAYS;
 *
 *   class Checker implements TypeQualifierValidator<Positive> {
 *     public When forConstantValue(Positive annotation, Object value) {
 *       if (value instanceof Number) {
 *         double num = ((Number) value).doubleValue();
 *         return num > 0 ? When.ALWAYS : When.NEVER;
 *       }
 *       return When.UNKNOWN;
 *     }
 *   }
 * }
 * }</pre>
 * <p>
 * Example of creating a nickname annotation:
 * <pre>{@code
 * @Documented
 * @TypeQualifierNickname
 * @Nonnull(when = When.MAYBE)
 * @Retention(RetentionPolicy.RUNTIME)
 * public @interface CheckForNull {
 * }
 * }</pre>
 * <p>
 * Example of setting default qualifiers:
 * <pre>{@code
 * @Documented
 * @Nonnull
 * @TypeQualifierDefault(ElementType.PARAMETER)
 * @Retention(RetentionPolicy.RUNTIME)
 * public @interface ParametersAreNonnullByDefault {
 * }
 * }</pre>
 * <p>
 * <strong>Static Analysis Integration:</strong>
 * <p>
 * These meta-annotations enable static analysis tools to:
 * <ul>
 * <li>Understand custom domain-specific qualifiers</li>
 * <li>Apply appropriate validation logic</li>
 * <li>Propagate qualifier information through code</li>
 * <li>Report violations of qualifier contracts</li>
 * <li>Handle qualifier defaults and inheritance</li>
 * </ul>
 * <p>
 * <strong>Best Practices:</strong>
 * <ul>
 * <li>Use meaningful names for custom qualifiers</li>
 * <li>Provide validation logic when possible</li>
 * <li>Document the intended semantics clearly</li>
 * <li>Consider using nicknames for common patterns</li>
 * <li>Set appropriate retention policies for tool support</li>
 * </ul>
 *
 * @since 1.0.0
 * @see <a href="https://jcp.org/en/jsr/detail?id=305">JSR-305: Annotations for Software Defect Detection</a>
 * @see jakarta.annotation
 */
@ParametersAreNonnullByDefault
package jakarta.annotation.meta;

import jakarta.annotation.ParametersAreNonnullByDefault;