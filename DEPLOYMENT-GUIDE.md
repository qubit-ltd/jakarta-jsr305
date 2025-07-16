# Deployment Guide

English | [中文](DEPLOYMENT-GUIDE.zh_CN.md)

This project supports publishing to two different Maven repositories. By default, `mvn deploy` publishes to Maven Central. Use the `-P qubit` profile to publish to Qubit repository instead.

## Repository Overview

### Default Behavior - Maven Central
When running `mvn deploy` without any profile:
- Deploys to Sonatype OSSRH (Maven Central)
- Generates source and JavaDoc JARs automatically
- Requires GPG signing for Maven Central compliance
- Uses Nexus Staging plugin for automated release process

### Qubit Profile - Qubit Repository
When running `mvn deploy -P qubit`:
- Deploys to `maven.qubit.ltd` repository
- Generates source and JavaDoc JARs automatically
- No GPG signing required (disabled)
- Direct deployment without staging

## Usage

### Deploy to Maven Central (Default)

```bash
# Prerequisites:
# 1. Registered Sonatype JIRA account with publishing permissions
# 2. GPG signing configured
# 3. Maven settings.xml configured

# Compile and test
mvn clean compile

# Deploy SNAPSHOT or release version
mvn clean deploy
```

### Deploy to Qubit Repository

```bash
# Compile and test
mvn clean compile -P qubit

# Deploy SNAPSHOT version
mvn clean deploy -P qubit

# Deploy release version (ensure version doesn't contain -SNAPSHOT)
# 1. Update version in pom.xml
# 2. Execute deployment
mvn clean deploy -P qubit
```

### Generate Release Packages Only (no upload)

```bash
# Generate all required JAR files without deployment
mvn clean package
```

## Maven Settings Configuration

### For Qubit Repository

Configure in `~/.m2/settings.xml`:

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

### For Maven Central

Refer to detailed configuration instructions in [RELEASE-GUIDE.md](RELEASE-GUIDE.md).

## Version Management

### SNAPSHOT Versions
- Version format: `1.0.0-SNAPSHOT`
- Can be republished to snapshot repository
- Suitable for development and testing

### Release Versions
- Version format: `1.0.0`
- Can only be published once (no overwriting)
- Suitable for production environments

## Deployment Workflow Example

### Complete Workflow for Qubit Repository

```bash
# 1. Ensure clean working directory
git status

# 2. Update version number (if needed)
# Edit <version> tag in pom.xml

# 3. Compile and test
mvn clean test -P qubit-release

# 4. Deploy
mvn clean deploy -P qubit-release

# 5. Commit version changes
git add pom.xml
git commit -m "Release version x.x.x"
git tag v1.0.0
git push origin master --tags

# 6. Prepare next development version
# Edit pom.xml to update to next SNAPSHOT version
git add pom.xml
git commit -m "Start next development cycle"
git push origin master
```

## Verify Deployment Results

### Qubit Repository
After deployment, verify with:

```bash
# Check repository files
curl -I https://maven.qubit.ltd/releases/ltd/qubit/jakarta-jsr305/1.0.0/jakarta-jsr305-1.0.0.jar
```

### Maven Central
After deployment, artifacts will be available in about 10-30 minutes at:
- Search: https://search.maven.org/
- Direct access: https://repo1.maven.org/maven2/ltd/qubit/jakarta-jsr305/

**Note**: When publishing to Maven Central, ensure you don't configure third-party mirror repositories (such as Aliyun) in your project pom.xml, as this may cause dependency resolution issues during the publishing process.

## Troubleshooting

### 1. Authentication Failed
Check username and password configuration in Maven settings.xml.

### 2. GPG Signing Failed
Ensure GPG is properly installed and configured. Refer to [RELEASE-GUIDE.md](RELEASE-GUIDE.md).

### 3. Version Conflict
Release versions cannot be republished. Update the version number.

### 4. Network Issues
Check network connectivity and repository service status.