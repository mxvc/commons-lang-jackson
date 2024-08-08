# Usage
![版本](https://img.shields.io/maven-central/v/io.github.mxvc/kettle-sdk-java)
```xml
<dependency>
    <groupId>io.github.tmgg</groupId>
    <artifactId>kettle-sdk-java</artifactId>
    <version>version</version>
</dependency>
```

Demo
```java
KettleSdk sdk = new KettleSdk(url, repo, username, password);
SlaveServerStatus status = sdk.status();
```
