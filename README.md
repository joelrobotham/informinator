# MyAccount
This is a REST API which should support all the MyREA backend functionality that DS currently supports.  This should be the only thing that talks to DSDB.

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

## IDE
Eclipse and Intellij are both good.  Eclipse project files are already included in this repo; you need only File > Import them.  However, I recommend downloading the [Scala Eclipse IDE](http://scala-ide.org/) separately, rather than adding the Scala plugin to your existing Eclipse.  This should eliminate version incompatibilities and inter-plugin warfare. 

You can find Scala Vim colors [here](https://github.com/scala/scala-dist/tree/master/tool-support/src/vim), and for Emacs there is the apparently excellent [ENSIME](https://github.com/aemoncannon/ensime).

## Design
MyAccount incorporates the various sub-sections of functionality within MyREA.  This is a temporary situation; once they are all separated from DS, then the various blobs of functionality can be farmed out to various services like Resi Services, as appropriate.  For this reason, the slices of functionality must be modular within the code; it should be possible to 
* Add or remove them by adding or removing a single directory, adding designated shared code as necessary.  
* Swap out the database behind the Data Access layer, without breaking anything else.

![Code Structure](https://community.rea-group.com/servlet/JiveServlet/downloadImage/38-12737-18919/620-371/myrea-structure2.jpg)

### Functionality slices
* Accounts - Register, sign-in, activation emails, forgot password, etc.
* Prefs - Newsletter subscription/unsubscription, random stuff that was jammed in the visitor\_preference key/value table
* Bookmarks - Bookmarked listings; saved, deleting and syncing between devices.
* Saved Searches - Saving and deleting Saved Searches, and altering their email alerts settings.
* Recently Viewed Listings - Maintain and view last N listings that were viewed.
* Recent Searches  - Maintain and view last N searches made.


### Tech layers
* Routes - Describes the API calls that can be made against the service.
* Controllers - Destructures the requests into data that can be understood by the business layer, and formulates valid HTTP responses. Should be immutable and functional.
* Business - Makes the decisions and does the work.  Should be immutable, functional, and easily testable. 
* Data Access - Gets stuff in or out of the data store, which may or may not be DSDB.

Also see this document for more information: [MyREA Technical Evolution](https://community.rea-group.com/groups/consumer-search-developers/blog/2013/06/17/myrea-technical-evolution)
