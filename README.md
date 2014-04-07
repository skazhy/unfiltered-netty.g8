# unfiltered-netty-rx

A [giter8](https://github.com/n8han/giter8) template for a new Unfilered app with Netty and RxJava Scala adaptor.


    g8 skazhy/unfiltered-netty-rx


Template comes with a couple of handy SBT plugins included. Together with
standard SBT commands for packaging, testing and running you can get the
following:


### Restart app on code changes

To recompile project on code changes, open the SBT shell and start Netty with
`~re-start`.


### Creating an uberjar

Running `sbt assembly` will create an ubjerjar in
target/scala-$version/root.jar


### Generating IntelliJ files

Run `sbt gen-idea` for fetching sources for IDEA (IntelliJ 13 can do this
automatically too, if everything is configured correctly).
