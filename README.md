# Jakarta JSR305 Annotations

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Maven Central](https://img.shields.io/maven-central/v/ltd.qubit/jakarta-jsr305.svg)](https://search.maven.org/artifact/ltd.qubit/jakarta-jsr305)

[中文文档](README.zh_CN.md) | English

## Overview

This project is a repackaged version of Google's JSR-305 annotations, migrated from the `javax.annotation` namespace to the `jakarta.annotation` namespace.

## Motivation

### 1. Legal Compliance
Oracle's legal documents prohibit any organization or individual from using the `javax.annotation` namespace, which could lead to copyright infringement issues. By migrating to the `jakarta.annotation` namespace, we completely avoid this legal risk.

### 2. Following Industry Trends
The migration from Java EE to Jakarta EE is the current mainstream trend, and upgrading from `javax.*` to `jakarta.*` has become standard practice. Using the `jakarta.annotation` namespace aligns with this development direction.

### 3. Tool Compatibility
Most static code analysis tools (such as SpotBugs, SonarQube, IntelliJ IDEA, etc.) can easily support annotations in the `jakarta.*` namespace with proper configuration.

## Included Annotations

This project contains the complete set of JSR-305 annotations, including but not limited to:

- `@Nonnull` / `@Nullable` - Null-checking annotations
- `@CheckForNull` / `@CheckReturnValue` - Return value checking annotations
- `@ParametersAreNonnullByDefault` / `@ParametersAreNullableByDefault` - Parameter default annotations
- `@ThreadSafe` / `@NotThreadSafe` / `@Immutable` / `@GuardedBy` - Concurrency-related annotations
- `@Tainted` / `@Untainted` - Security-related annotations
- Other utility annotations...

## Usage

### Maven Dependency

```xml
<dependency>
  <groupId>ltd.qubit</groupId>
  <artifactId>jakarta-jsr305</artifactId>
  <version>1.0.0</version>
  <scope>provided</scope>
</dependency>
```

### Combined with Jakarta Annotation API

Recommended for use with the official Jakarta Annotation API:

```xml
<dependency>
  <groupId>jakarta.annotation</groupId>
  <artifactId>jakarta.annotation-api</artifactId>
  <scope>compile</scope>
</dependency>
```

### Code Example

```java
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class UserService {

    @Nonnull
    public User findUser(@Nonnull String userId) {
        // Implementation logic
        return user;
    }

    @Nullable
    public User findOptionalUser(@Nonnull String userId) {
        // May return null
        return user;
    }
}
```

## Migration Guide

If your project is currently using JSR-305 annotations from `javax.annotation`, you can migrate using the following steps:

1. **Replace Dependency**: Replace your existing JSR-305 dependency with this project
2. **Update Imports**: Use your IDE's bulk replace feature to change `javax.annotation` to `jakarta.annotation`
3. **Configure Tools**: Update static analysis tool configurations to recognize the new namespace
4. **Test and Verify**: Ensure all functionality works correctly

## Compatibility

- **Java Version**: Requires Java 9 or higher
- **Compilation Target**: Compiled to Java 9 bytecode level
- **Modularity**: Provides `module-info.java` support

## License

This project is licensed under the [Apache License 2.0](LICENSE).

## Contributing

Issues and Pull Requests are welcome to improve this project.

## Documentation

- [Deployment Guide](DEPLOYMENT-GUIDE.md) - How to deploy to different Maven repositories
- [Release Guide](RELEASE-GUIDE.md) - Detailed guide for releasing to Maven Central

## Related Projects

- [JSR 305](https://jcp.org/en/jsr/detail?id=305) - Original JSR-305 specification
- [Jakarta Annotations](https://jakarta.ee/specifications/annotations/) - Jakarta EE annotation specification
- [SpotBugs](https://spotbugs.github.io/) - Static analysis tool supporting JSR-305 annotations

## Changelog

### v1.0.0
- Initial release
- Migrated all JSR-305 annotations from `javax.annotation` to `jakarta.annotation`
- Provided Java 9+ modularization support
