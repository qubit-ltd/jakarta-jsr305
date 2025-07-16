# Jakarta JSR305 Annotations

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Maven Central](https://img.shields.io/maven-central/v/ltd.qubit/jakarta-jsr305.svg)](https://search.maven.org/artifact/ltd.qubit/jakarta-jsr305)

中文文档 | [English](README.md)

## 项目简介

这个项目是将 Google 的 JSR-305 注解从 `javax.annotation` 命名空间迁移到 `jakarta.annotation` 命名空间的重新打包版本。

## 项目目标

### 1. 避免法律问题
Oracle 的法律文件禁止任何机构或个人使用 `javax.annotation` 命名空间，否则可能面临侵权问题。通过迁移到 `jakarta.annotation` 命名空间，可以完全避免这一法律风险。

### 2. 跟上主流趋势
Java EE 向 Jakarta EE 的迁移是当前的主流趋势，`javax.*` 向 `jakarta.*` 的升级已经成为标准做法。使用 `jakarta.annotation` 命名空间符合这一发展方向。

### 3. 保持工具兼容性
大多数静态代码检查工具（如 SpotBugs、SonarQube、IntelliJ IDEA 等）经过适当配置后，可以很容易地兼容 `jakarta.*` 命名空间的注解。

## 包含的注解

本项目包含了完整的 JSR-305 注解集合，包括但不限于：

- `@Nonnull` / `@Nullable` - 空值检查注解
- `@CheckForNull` / `@CheckReturnValue` - 返回值检查注解
- `@ParametersAreNonnullByDefault` / `@ParametersAreNullableByDefault` - 参数默认性注解
- `@ThreadSafe` / `@NotThreadSafe` / `@Immutable` / `@GuardedBy` - 并发相关注解
- `@Tainted` / `@Untainted` - 安全相关注解
- 其他实用注解...

## 使用方法

### Maven 依赖

```xml
<dependency>
  <groupId>ltd.qubit</groupId>
  <artifactId>jakarta-jsr305</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### 结合 Jakarta Annotation API

推荐与官方的 Jakarta Annotation API 一起使用：

```xml
<dependency>
  <groupId>jakarta.annotation</groupId>
  <artifactId>jakarta.annotation-api</artifactId>
  <scope>compile</scope>
</dependency>
```

### 代码示例

```java
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class UserService {

    @Nonnull
    public User findUser(@Nonnull String userId) {
        // 实现逻辑
        return user;
    }

    @Nullable
    public User findOptionalUser(@Nonnull String userId) {
        // 可能返回 null
        return user;
    }
}
```

## 迁移指南

如果你的项目正在使用 `javax.annotation` 中的 JSR-305 注解，可以通过以下步骤迁移：

1. **替换依赖**：将原来的 JSR-305 依赖替换为本项目
2. **更新导入**：使用 IDE 的批量替换功能，将 `javax.annotation` 替换为 `jakarta.annotation`
3. **配置工具**：更新静态分析工具的配置以识别新的命名空间
4. **测试验证**：确保所有功能正常工作

## 兼容性

- **Java 版本**：需要 Java 11 或更高版本
- **编译目标**：编译为 Java 11 字节码级别
- **模块化**：提供 `module-info.java` 支持

## 许可证

本项目采用 [Apache License 2.0](LICENSE) 许可证。

## 贡献

欢迎提交 Issue 和 Pull Request 来改进这个项目。

## 文档

- [部署指南](DEPLOYMENT-GUIDE.zh_CN.md) - Maven 中央仓库发布详细指南

## 相关项目

- [JSR 305](https://jcp.org/en/jsr/detail?id=305) - 原始的 JSR-305 规范
- [Jakarta Annotations](https://jakarta.ee/specifications/annotations/) - Jakarta EE 注解规范
- [SpotBugs](https://spotbugs.github.io/) - 支持 JSR-305 注解的静态分析工具

## 更新日志

### v1.0.0
- 首次发布
- 将所有 JSR-305 注解从 `javax.annotation` 迁移到 `jakarta.annotation`
- 提供 Java 9+ 模块化支持
