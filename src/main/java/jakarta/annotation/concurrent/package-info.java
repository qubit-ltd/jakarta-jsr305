////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2025.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////

/**
 * Annotations for concurrent programming and thread safety documentation.
 * <p>
 * This package provides annotations to document the thread safety characteristics
 * of classes and their members. These annotations serve as both documentation
 * for developers and hints for static analysis tools.
 * <p>
 * <strong>Available Annotations:</strong>
 * <ul>
 * <li>{@link jakarta.annotation.concurrent.ThreadSafe} - Indicates that a class
 *     is thread-safe and can be safely used by multiple threads concurrently.</li>
 * <li>{@link jakarta.annotation.concurrent.NotThreadSafe} - Indicates that a class
 *     is not thread-safe and should not be used by multiple threads without
 *     external synchronization.</li>
 * <li>{@link jakarta.annotation.concurrent.Immutable} - Indicates that a class
 *     is immutable and therefore inherently thread-safe.</li>
 * <li>{@link jakarta.annotation.concurrent.GuardedBy} - Indicates that a field
 *     or method should only be accessed when holding a particular lock.</li>
 * </ul>
 * <p>
 * <strong>Usage Examples:</strong>
 * <pre>{@code
 * @ThreadSafe
 * public class ConcurrentCounter {
 *   @GuardedBy("this")
 *   private int count = 0;
 *
 *   public synchronized int increment() {
 *     return ++count;
 *   }
 * }
 *
 * @Immutable
 * public class Point {
 *   private final int x, y;
 *
 *   public Point(int x, int y) {
 *     this.x = x;
 *     this.y = y;
 *   }
 *
 *   public int getX() { return x; }
 *   public int getY() { return y; }
 * }
 *
 * @NotThreadSafe
 * public class ArrayList<E> {
 *   // Implementation
 * }
 * }</pre>
 * <p>
 * <strong>Best Practices:</strong>
 * <ul>
 * <li>Always document thread safety characteristics of public classes</li>
 * <li>Use {@code @GuardedBy} to clearly document locking protocols</li>
 * <li>Prefer immutable classes when possible for inherent thread safety</li>
 * <li>Be explicit about non-thread-safe classes to prevent misuse</li>
 * </ul>
 * <p>
 * <strong>Static Analysis:</strong>
 * <p>
 * These annotations are particularly useful for static analysis tools that can:
 * <ul>
 * <li>Detect potential race conditions</li>
 * <li>Verify locking protocols</li>
 * <li>Warn about unsafe concurrent access patterns</li>
 * <li>Validate immutability constraints</li>
 * </ul>
 *
 * @since 1.0.0
 * @see <a href="https://jcip.net/">Java Concurrency in Practice</a>
 * @see <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/">Oracle Java Concurrency Tutorial</a>
 */
@ParametersAreNonnullByDefault
package jakarta.annotation.concurrent;

import jakarta.annotation.ParametersAreNonnullByDefault;