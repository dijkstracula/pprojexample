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
