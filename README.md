# Sample P -> Java project structure

Just putting this up here so yall can see what I think we'll do.

TLDR: All P code still gets compiled into one file named after the entire
project, which is placed in `./PGenerated`.  This matches what we do with the
current code generator but if we want to break things up in a more fine-grained
manner, per the discussion [here](https://github.com/p-org/P/issues/454) then
all those changes will be localised in this subdirectory.  At P -> Java compile
time, the `pom.xml` will be generated and placed in the root of the project,
just like with the C# backend.

```
nathta@bcd0741cf59d pprojtest % tree ./PSpec ./PGenerated
PSpec
└── foo.p
PGenerated
└── pprojtest.java
```


The foreign function package structure is a bit more refined:  For every P
machine `someMachine` with foreign functions, those definitions go into the
package `ffi`, whereas all globals go under `ffi.globals`.  So, the
fully-qualified classname for the `myMonitor` FFI code would be `ffi.myMonitor`
and the class for the global Counter datatype would be named
`ffi.globals.Counter`.

```
nathta@bcd0741cf59d pprojtest % tree PForeign
PForeign
├── globals
│   └── Counter.java
└── myMonitor.java
```

Currently, the pom.xml just pulls the P Java runtime from the local Maven
repository, which means it needs to be
[installed](https://github.com/dijkstracula/prtsandbox#installation)
there first (see link for instructions).  This of course will be changed
once we have a remote artifactory to stick that .jar file.

To build:

```
nathta@bcd0741cf59d pprojtest % mvn package
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------------< com.amazon.p:my-pproj >------------------------
[INFO] Building my-pproj 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ my-pproj ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/nathta/code/pprojtest/src/main/resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ my-pproj ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 3 source files to /Users/nathta/code/pprojtest/POutput/classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ my-pproj ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/nathta/code/pprojtest/src/test/resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ my-pproj ---
[INFO] No sources to compile
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ my-pproj ---
[INFO] No tests to run.
[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ my-pproj ---
[INFO] Building jar: /Users/nathta/code/pprojtest/POutput/my-pproj-1.0-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.638 s
[INFO] Finished at: 2022-06-21T12:15:07-07:00
[INFO] ------------------------------------------------------------------------
nathta@bcd0741cf59d pprojtest % jar -tf POutput/my-pproj-1.0-SNAPSHOT.jar
META-INF/
META-INF/MANIFEST.MF
PGenerated/
PForeign/
PForeign/globals/
PGenerated/pprojtest.class
PGenerated/pprojtest$PHalt.class
PGenerated/pprojtest$DefaultEvent.class
PGenerated/pprojtest$eIncr.class
PGenerated/pprojtest$myMonitor.class
PForeign/globals/Counter.class
PForeign/myMonitor.class
META-INF/maven/
META-INF/maven/com.amazon.p/
META-INF/maven/com.amazon.p/my-pproj/
META-INF/maven/com.amazon.p/my-pproj/pom.xml
META-INF/maven/com.amazon.p/my-pproj/pom.properties
nathta@bcd0741cf59d pprojtest %
```
