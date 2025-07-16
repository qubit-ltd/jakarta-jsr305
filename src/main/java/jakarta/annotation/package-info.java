////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2025.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////

/**
 * Jakarta Annotation API - A repackaged version of JSR-305 annotations.
 * <p>
 * This package provides annotation-based metadata for static analysis tools
 * to help detect potential bugs and improve code quality. The annotations in
 * this package are primarily intended for use by static analysis tools such
 * as SpotBugs, SonarQube, and IDEs.
 * <p>
 * Key annotation categories:
 * <ul>
 * <li><strong>Nullability annotations:</strong> {@link jakarta.annotation.Nonnull},
 *     {@link jakarta.annotation.Nullable}, {@link jakarta.annotation.CheckForNull}</li>
 * <li><strong>Default nullability:</strong> {@link jakarta.annotation.ParametersAreNonnullByDefault},
 *     {@link jakarta.annotation.ParametersAreNullableByDefault}</li>
 * <li><strong>Code analysis:</strong> {@link jakarta.annotation.CheckReturnValue},
 *     {@link jakarta.annotation.OverridingMethodsMustInvokeSuper}</li>
 * <li><strong>String validation:</strong> {@link jakarta.annotation.RegEx},
 *     {@link jakarta.annotation.MatchesPattern}, {@link jakarta.annotation.Syntax}</li>
 * <li><strong>Security annotations:</strong> {@link jakarta.annotation.Tainted},
 *     {@link jakarta.annotation.Untainted}, {@link jakarta.annotation.Detainted}</li>
 * <li><strong>Resource management:</strong> {@link jakarta.annotation.WillClose},
 *     {@link jakarta.annotation.WillNotClose}, {@link jakarta.annotation.WillCloseWhenClosed}</li>
 * </ul>
 * <p>
 * <strong>Migration from javax.annotation:</strong>
 * <p>
 * This package provides a drop-in replacement for Google's JSR-305 annotations
 * that were originally under the {@code javax.annotation} namespace. Simply
 * replace your imports:
 * <pre>
 * // Old import
 * import javax.annotation.Nonnull;
 *
 * // New import
 * import jakarta.annotation.Nonnull;
 * </pre>
 * <p>
 * <strong>Usage Example:</strong>
 * <pre>{@code
 * @ParametersAreNonnullByDefault
 * public class UserService {
 *
 *   @Nullable
 *   public User findUser(@Nonnull String userId) {
 *     // Implementation
 *   }
 *
 *   @CheckReturnValue
 *   public boolean saveUser(@Nonnull User user) {
 *     // Implementation
 *   }
 * }
 * }</pre>
 * <p>
 * <strong>Runtime Behavior:</strong>
 * <p>
 * These annotations are primarily intended for static analysis and have minimal
 * runtime overhead. Most annotations use {@link java.lang.annotation.RetentionPolicy#RUNTIME}
 * to ensure they are available for reflection-based tools, but they do not
 * provide runtime null checking or validation.
 * <p>
 * For runtime null checking, consider using validation frameworks like
 * Jakarta Bean Validation or defensive programming practices.
 *
 * @since 1.0.0
 * @see <a href="https://jcp.org/en/jsr/detail?id=305">JSR-305: Annotations for Software Defect Detection</a>
 * @see <a href="https://jakarta.ee/">Jakarta EE</a>
 */
@ParametersAreNonnullByDefault
package jakarta.annotation;