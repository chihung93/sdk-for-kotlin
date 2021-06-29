# Appwrite Kotlin SDK

![Maven Central](https://img.shields.io/maven-central/v/io.appwrite/sdk-for-kotlin.svg?color=green&style=flat-square)
![License](https://img.shields.io/github/license/appwrite/sdk-for-kotlin.svg?style=flat-square)
![Version](https://img.shields.io/badge/api%20version-0.8.0-blue.svg?style=flat-square)
[![Twitter Account](https://img.shields.io/twitter/follow/appwrite_io?color=00acee&label=twitter&style=flat-square)](https://twitter.com/appwrite_io)
[![Discord](https://img.shields.io/discord/564160730845151244?label=discord&style=flat-square)](https://appwrite.io/discord)

**This SDK is compatible with Appwrite server version 0.8.x. For older versions, please check [previous releases](https://github.com/appwrite/sdk-for-kotlin/releases).**

Appwrite is an open-source backend as a service server that abstract and simplify complex and repetitive development tasks behind a very simple to use REST API. Appwrite aims to help you develop your apps faster and in a more secure way. Use the Kotlin SDK to integrate your app with the Appwrite server to easily start interacting with all of Appwrite backend APIs and tools. For full API documentation and tutorials go to [https://appwrite.io/docs](https://appwrite.io/docs)

![Appwrite](https://appwrite.io/images/github.png)

## Installation

### Gradle

Appwrite's Kotlin SDK is hosted on Maven Central. In order to fetch the Appwrite SDK, add this to your root level `build.gradle(.kts)` file:

```groovy
repositories {      
    mavenCentral()
}
```

If you would like to fetch our SNAPSHOT releases, you need to add the SNAPSHOT maven repository to your `build.gradle(.kts)`:

```groovy
repositories {
    maven {
        url "https://s01.oss.sonatype.org/content/repositories/snapshots/"
    }
}
```

Next, add the dependency to your project's `build.gradle(.kts)` file:

```groovy
implementation("io.appwrite:sdk-for-kotlin:0.0.0")
```

### Maven
Add this to your project's `pom.xml` file:

```xml
<dependencies>
    <dependency>
        <groupId>io.appwrite</groupId>
        <artifactId>sdk-for-kotlin</artifactId>
        <version>0.0.0</version>
    </dependency>
</dependencies>
```


## Contribution

This library is auto-generated by Appwrite custom [SDK Generator](https://github.com/appwrite/sdk-generator). To learn more about how you can help us improve this SDK, please check the [contribution guide](https://github.com/appwrite/sdk-generator/blob/master/CONTRIBUTING.md) before sending a pull-request.

## License

Please see the [BSD-3-Clause license](https://raw.githubusercontent.com/appwrite/appwrite/master/LICENSE) file for more information.