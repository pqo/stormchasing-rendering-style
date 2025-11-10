## stormchasing.render.xml
This is an OsmAnd rendering style optimized for storm chasing. It's been tested on Android and depends on the LightRS rendering style (included with OsmAnd by default).

**Key features**
- Paved roads are rendered in bright colors for daytime readability.
- Unpaved roads (gravel, dirt) are consistently rendered in gray regardless of zoom level or road type.
- Primary, secondary, and tertiary road types are all rendered starting at zoom level 11 to quickly find paved navigation routes.
- Local road types are rendered starting at zoom level 12 for close range interception.
- Trails and roads that are likely to become muddy and/or impassable after heavy rain are rendered as dashed lines
- Roads without surface integrity information are rendered in a hollow style. Please contribute to the underlying OSM data -- see instructions below on how to do this.

![Action shot of the Stormchasing rendering style](Screenshot_OsmAnd.jpg "Action shot of the Stormchasing rendering style")

## Installing
- Open your OsmAnd data storage folder through any file manager or by browsing files via USB. You can find your data storage folder by going to Menu->Settings->OsmAnd settings->Data storage folder.
- Now copy stormchasing.render.xml into the `rendering` subfolder. 
- Enable the style by going to Menu->Configure map->Map rendering->Map style and selecting the *Stormchasing* style

## How to update road surface information in the OSM data
- Go to https://www.openstreetmap.org/ and log in or sign up
- Zoom far enough into the map at the desired location to activate the *Edit* button
- Select the features to edit (hold down shift key to multi-select)
- Set [*surface*](https://wiki.openstreetmap.org/wiki/Key:surface) drop-down as appropriate. For example: asphalt, concrete, dirt, or gravel

NOTE: The *mud* surface type is reserved for [roads that are muddy most of the time](https://wiki.openstreetmap.org/wiki/Tag:surface%3Dmud). So for a gravel road that turns into a rutted muddy road after heavy rain, be sure to add the [*smoothness* tag](https://wiki.openstreetmap.org/wiki/Key:smoothness) and set the value to *bad* or worse. This will allow OsmAnd to visually distinguish between gravel roads that can be used after heavy rain and those that turn to mud.

## Known issues
* *shadowRadius* and *pathEffect* aren't working as overrides in this rendering style when using the Version 2 / OpenGL rendering engine. So be sure to set Menu->Settings->OsmAnd settings->Map rendering engine to Version 1 or the important visual distinctions won't work. If you know how to fix this please submit a PR.

## Existing rendering styles
**LightRS**
* Distinguishes well between unclassified highway types (which is often unpaved but not always) and classified (which is often paved but not always)  
* Shows more highway labels  
* Doesn't distinguish by road surface type  
* Night mode changes surface-identifying colors when zoomed in - paved roads are too dark

**Offroad**
* Distinguishes well between surface types only when zoomed in to 12+  
* Displays trails too boldly especially when zoomed in  
* Doesn't distinguish well enough between unclassified and other highway types which can help indicate maintenance level

**Topo**
* Distinguishes well between surface types only when zoomed in to 12+  
* Displays trails too boldly