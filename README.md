# Week 09: Libraries

## Overview

This week we will be looking at techniques for building libraries in Scala. In particular we will look at facilities provided by the Scala programming language for information hiding, types, and stackable traits. We will also investigate the generation of JAR files from Scala that allow libraries to be distributed in an efficient format. In addition, we will see how to search for libraries on Maven Central and include libraries in your SBT environment.

*To get access to this material [download][zip] the zip archive.*

[zip]: https://github.com/umass-cs-220/week-09-libraries/archive/master.zip

## Readings

* Chapter 12 Traits, Odersky
* Chapter 13 Packages and Imports, Odersky
* Chapter 19 Type Parameterization, Odersky
* Chapter 20 Abstract Members, Odersky

## Code Examples

* [code/traits](code/traits)
* [code/types](code/types)
* [code/csvlib](code/csvlib)

## Resources

* [SBT Library Dependencies], how to use libraries in SBT
* [Maven Central], a place to search for libraries
* [awesome-scala], a list of useful Scala libraries
* [scala-csv], a CSV library for Scala
* [sbt-assembly], an SBT plugin to build JAR files

[SBT Library Dependencies]: http://www.scala-sbt.org/0.13/tutorial/Library-Dependencies.html
[Maven Central]: http://search.maven.org
[awesome-scala]: https://github.com/lauris/awesome-scala
[scala-csv]: https://github.com/tototoshi/scala-csv
[sbt-assembly]: https://github.com/sbt/sbt-assembly