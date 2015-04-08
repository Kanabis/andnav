# Introduction #

This is a small guide how to make a translation for the AndNav application.

# Details #

Under /res create a 'values-xx' directory, where xx is the language code. Then Translate the all the XML files in this directory.

In /res/xml create a new turninstructions\_xx.xml file and translate this.

Add you language to DirectionsLanguge.java

Edit the entrace in enum Country.java: Add contry code 'xx' as 4th parameter and new DirectionsLanguage[.md](.md){DirectionsLanguage.DANISH} as the 7th

Add your name in /translators.txt


TEST TEST TEST your fix.

Submit either a patch or a commit to trunk.