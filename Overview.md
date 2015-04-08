# Introduction #

The main wiki for andnav users is [here](http://wiki.andnav.org/index.php/Main_Page).
Discussions regarding enhancements and defects are [here](http://groups.google.com/group/andnav?hl=en).
This wiki is for developers.
In particular it describes the andnav2 design and implementation.

# Details #

When AndNav2 is started the natural progression of views is as follows:
(Omitting the ancillary views.)
  * The top level activity is .Splash
    * The EULA dialog is presented (unless previously accepted)
  * The main .ui.menu is presented
    * The map is the principle component, .ui.map.WhereAmIMap