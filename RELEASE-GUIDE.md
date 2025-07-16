# Maven 中央仓库发布指南

## 前置要求

### 1. 注册 Sonatype JIRA 账户
1. 访问 https://issues.sonatype.org
2. 创建新账户
3. 创建一个新的 JIRA ticket 来申请发布权限：
   - Project: Community Support - Open Source Project Repository Hosting (OSSRH)
   - Issue Type: New Project
   - Group Id: `io.github.haixing-hu`
   - Project URL: `https://github.com/haixing-hu/jakarta-jsr305`

### 2. 验证 GitHub 用户名
Sonatype 会要求你证明对 GitHub 账户的所有权，通常需要：
- 创建一个临时的公开仓库，名称为 Sonatype 指定的格式
- 或者在现有仓库中添加特定内容

### 3. 设置 GPG 签名

#### 生成 GPG 密钥对
```bash
# 生成新的 GPG 密钥
gpg --gen-key

# 按提示输入：
# - 姓名：Haixing Hu
# - 邮箱：starfish@qubit.ltd
# - 密码：（设置一个强密码）
```

#### 查看和上传密钥
```bash
# 查看生成的密钥
gpg --list-keys

# 导出公钥（替换为你的密钥ID）
gpg --armor --export YOUR_KEY_ID

# 上传公钥到密钥服务器
gpg --keyserver keyserver.ubuntu.com --send-keys YOUR_KEY_ID
gpg --keyserver keys.openpgp.org --send-keys YOUR_KEY_ID
```

### 4. 配置 Maven Settings

将 `settings-template.xml` 内容复制到 `~/.m2/settings.xml`，并填入实际信息：

```bash
# 创建目录（如果不存在）
mkdir -p ~/.m2

# 复制模板并编辑
cp settings-template.xml ~/.m2/settings.xml
# 然后编辑文件，填入实际的用户名、密码和 GPG 密码
```

## 发布流程

### 1. 准备发布版本

```bash
# 确保代码已提交并推送到 GitHub
git add .
git commit -m "准备发布 1.0.0 版本"
git push origin master

# 更新版本号为正式版本（移除 -SNAPSHOT）
# 编辑 pom.xml，将 <version>1.0.0-SNAPSHOT</version> 改为 <version>1.0.0</version>
```

### 2. 执行发布

```bash
# 清理并编译
mvn clean compile

# 发布到中央仓库（暂存）
mvn clean deploy -P release

# 如果配置了 autoReleaseAfterClose=false，需要手动释放
mvn nexus-staging:release -P release
```

### 3. 验证发布

发布成功后，大约 10-30 分钟后可以在以下地址查看：

- 搜索中央仓库：https://search.maven.org/
- 直接访问：https://repo1.maven.org/maven2/io/github/haixing-hu/jakarta-jsr305/

### 4. 后续版本管理

```bash
# 发布完成后，更新到下一个 SNAPSHOT 版本
# 例如：<version>1.0.1-SNAPSHOT</version>
git add pom.xml
git commit -m "开始下一个开发周期"
git push origin master
```

## 使用发布的库

其他项目可以通过以下方式使用：

```xml
<dependency>
  <groupId>io.github.haixing-hu</groupId>
  <artifactId>jakarta-jsr305</artifactId>
  <version>1.0.0</version>
</dependency>
```

## 常见问题

### 1. GPG 签名失败
确保：
- GPG 已正确安装并配置
- 密钥已生成并上传到密钥服务器
- settings.xml 中的 GPG 配置正确

### 2. 权限被拒绝
确保：
- JIRA ticket 已被批准
- groupId 所有权已验证
- Sonatype 账户配置正确

### 3. 网络问题
如果遇到网络连接问题：
- 检查网络连接
- 尝试使用不同的密钥服务器
- 确认 Sonatype 服务状态

## 相关链接

- [Sonatype OSSRH 指南](https://central.sonatype.org/publish/publish-guide/)
- [Maven GPG 插件文档](https://maven.apache.org/plugins/maven-gpg-plugin/)
- [Nexus Staging 插件文档](https://help.sonatype.com/repomanager2/staging-releases/configuring-your-project-for-deployment)