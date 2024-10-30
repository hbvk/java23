# Java 23

[![Build Status](https://dev.azure.com/hbvk/java-test/_apis/build/status%2Fhbvk.java23?branchName=main)](https://dev.azure.com/hbvk/java-test/_build/latest?definitionId=42&branchName=main)

| JDK                                            | Release    | EOL     | Class File Version |
|------------------------------------------------|------------|---------|--------------------|
| [JDK 23](https://openjdk.org/projects/jdk/23/) | 2024-09-17 | 2025-06 | 67.0               |

# New Features

| feature                                               | JEP                                          | status           | test                                                               |
|-------------------------------------------------------|----------------------------------------------|------------------|--------------------------------------------------------------------|
| Primitive Types in Patterns, instanceof, and switch 1 | [JEP 455](https://openjdk.java.net/jeps/455) | Preview          |
| Class-File API                                        | [JEP 466](https://openjdk.java.net/jeps/466) | 2. Preview       |
| Markdown Documentation Comments                       | [JEP 467](https://openjdk.java.net/jeps/467) | **final**        | used throughout this project                                       |
| Vector API                                            | [JEP 469](https://openjdk.java.net/jeps/469) | Eighth Incubator |
| Stream Gatherers                                      | [JEP 473](https://openjdk.java.net/jeps/473) | Second preview   | [test case](src/test/java/com/hbvk/jep473/Jep473GathererTest.java) |
| ZGC: Generational Mode by Default                     | [JEP 474](https://openjdk.java.net/jeps/474) | **final**        |
| Module Import Declarations                            | [JEP 476](https://openjdk.java.net/jeps/476) | Preview          |
| Implicitly Declared Classes and Instance Main Methods | [JEP 477](https://openjdk.java.net/jeps/477) | Third preview    |
| Structured Concurrency                                | [JEP 480](https://openjdk.java.net/jeps/480) | Third preview    |
| Scoped Values                                         | [JEP 481](https://openjdk.java.net/jeps/481) | Third preview    |
| Flexible Constructor Bodies                           | [JEP 482](https://openjdk.java.net/jeps/482) | Second Preview   |

# Testing new features

In this project I have been experimenting with new Java features in Java 23:

* Markdown Documentation Comments

Not many new features this time: A change in garbage collection and an alternative for HTML-based javadoc. The
markdown-based javadoc is used throughout this project. If you want to try it out, intelliJ will automatically convert
it to markdown for you.

# Testing preview features

I also tested the following preview features:

* [Stream Gatherers](src/test/java/com/hbvk/jep473/Jep473GathererTest.java)

Preview features are subject to change.

Stream gatherers are a good idea, but the current preview implementation lacks the ease of use of similar Kotlin
constructs. Also, there seems to be no difference with the previous preview.

