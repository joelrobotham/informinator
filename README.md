## Setup
1. Install the Simple Build Tool if you haven't already: brew install sbt
2. Type "./install-sbt" in the myaccount directory. It should give SBT more memory, download whatever dependencies it needs, and compile the source code.
3. Type "sbt". This will fire up the SBT command prompt
4. Type "run".  This will compile everything and launch the server on port 9000.
 
# SBT commands
From within the SBT prompt, there are stacks of commands. Here are some useful ones:
* run  - As mentioned above, this will start the server.  It should hot-load Scala code changes.
* compile - Compile the source code
* console - Enter a Scala REPL with all the project's dependencies loaded.
* test - Run all the tests.   
* ~test - Run all the tests, automatically running them again when something changes.  You can prepend ~ to any command to have this effect.
* exit - Exit the SBT prompt

You can find Scala Vim colors [here](https://github.com/scala/scala-dist/tree/master/tool-support/src/vim), and for Emacs there is the apparently excellent [ENSIME](https://github.com/aemoncannon/ensime).

