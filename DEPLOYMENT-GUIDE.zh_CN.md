# 部署指南

[English](DEPLOYMENT-GUIDE.md) | 中文

本项目支持发布到两个不同的 Maven 仓库。默认情况下，`mvn deploy` 发布到 Maven 中央仓库。使用 `-P qubit` 参数可以发布到 Qubit 仓库。

## 仓库说明

### 默认行为 - Maven 中央仓库
运行 `mvn deploy`（不加任何 profile）时：
- 发布到 Sonatype OSSRH（Maven 中央仓库）
- 自动生成源码和 JavaDoc JAR
- 需要 GPG 签名（Maven 中央仓库要求）
- 使用 Nexus Staging 插件进行自动化发布流程

### Qubit Profile - Qubit 仓库
运行 `mvn deploy -P qubit` 时：
- 发布到 `maven.qubit.ltd` 仓库
- 自动生成源码和 JavaDoc JAR
- 不需要 GPG 签名（已禁用）
- 直接部署，无需暂存

## 使用方法

### 发布到 Maven 中央仓库（默认）

```bash
# 前提条件：
# 1. 已注册 Sonatype JIRA 账户并获得发布权限
# 2. 已配置 GPG 签名
# 3. 已配置 Maven settings.xml

# 编译和测试
mvn clean compile

# 发布 SNAPSHOT 或正式版本
mvn clean deploy
```

### 发布到 Qubit 仓库

```bash
# 编译和测试
mvn clean compile -P qubit

# 发布 SNAPSHOT 版本
mvn clean deploy -P qubit

# 发布正式版本（确保版本号不包含 -SNAPSHOT）
# 1. 修改 pom.xml 中的版本号
# 2. 执行发布
mvn clean deploy -P qubit
```

### 仅生成发布包（不上传）

```bash
# 生成所有必需的 JAR 文件，但不部署
mvn clean package
```

## Maven Settings 配置

### 发布到 Qubit 仓库

需要在 `~/.m2/settings.xml` 中配置：

```xml
<settings>
  <servers>
    <server>
      <id>qubit-releases</id>
      <username>your-username</username>
      <password>your-password</password>
    </server>
    <server>
      <id>qubit-snapshots</id>
      <username>your-username</username>
      <password>your-password</password>
    </server>
  </servers>
</settings>
```

### 发布到 Maven 中央仓库

参考本文档中的详细配置说明。

## 版本管理

### SNAPSHOT 版本
- 版本号格式：`1.0.0-SNAPSHOT`
- 可以重复发布到 snapshot 仓库
- 适用于开发和测试

### 正式版本
- 版本号格式：`1.0.0`
- 只能发布一次（不能覆盖）
- 适用于生产环境

## 发布流程示例

### 发布到 Qubit 仓库的完整流程

```bash
# 1. 确保当前是干净的工作目录
git status

# 2. 更新版本号（如果需要）
# 编辑 pom.xml 中的 <version> 标签

# 3. 编译和测试
mvn clean test -P qubit-release

# 4. 发布
mvn clean deploy -P qubit-release

# 5. 提交版本变更
git add pom.xml
git commit -m "发布版本 x.x.x"
git tag v1.0.0
git push origin master --tags

# 6. 准备下一个开发版本
# 编辑 pom.xml，更新到下一个 SNAPSHOT 版本
git add pom.xml
git commit -m "开始下一个开发周期"
git push origin master
```

## 验证发布结果

### Qubit 仓库
发布后可以通过以下方式验证：

```bash
# 检查仓库中的文件
curl -I https://maven.qubit.ltd/releases/ltd/qubit/jakarta-jsr305/1.0.0/jakarta-jsr305-1.0.0.jar
```

### Maven 中央仓库
发布后约 10-30 分钟可以在以下地址查看：
- 搜索：https://search.maven.org/
- 直接访问：https://repo1.maven.org/maven2/ltd/qubit/jakarta-jsr305/

**注意**：发布到 Maven 中央仓库时，请确保不要在项目 pom.xml 中配置阿里云等第三方镜像仓库，这可能会导致发布过程中的依赖解析问题。

## 常见问题

### 1. 认证失败
检查 Maven settings.xml 中的用户名和密码配置。

### 2. GPG 签名失败
确保 GPG 已正确安装和配置，参考本文档中的 GPG 配置部分。

### 3. 版本冲突
正式版本不能重复发布，需要更新版本号。

### 4. 网络问题
检查网络连接和仓库服务状态。