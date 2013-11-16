Spam Me Not Viewtool
====================
This plugin turns the Spam-Me-Not Java Version by Björn Bergenheim into a viewtool for dotCMS
This is the OSGI Version

Original Version of this code can be found at:
http://paula.edmiston.org/nb/spamx/SpamMeNot.java

Installation
------------
* Navigate to the dotCMS Dynamic plugins page: "System" > "Dynamic Plugins"
* Click on "Upload plugin" and select the .jar file located in the "build/jar/" folder
* Click on "Exported Packages" and add the contents of the EXPORTS file to the bottom of the list

Usage Example
-------------
```velocity
<p>Email Me: 
${spammenot.encodeEmail("example@email.com", "Example Name")}
</p>

#set($href = $spammenot.encodeString("mailto:example@email.com"))
#set($name = $spammenot.encodeString("Example Name"))
<p>Email Me: <a class="mylink" href="${href}">${name}</a></p>
```

