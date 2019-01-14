v20150302
==================================================================
          Mines and Prospects of Idaho
==================================================================

Database to the Mines and Prospects of Idaho

Compiled by Victoria E. Mitchell, Ruth E. Vance, Earl H. Bennett, 
B. Benjamin E. Studer, Loudon R. Stanford, and Christopher A. Tate

Digital Database 1 in the Digital Data series (DD-1)
Version 1.2015.1
February 2015




-------------------------
HOW TO USE THIS DOCUMENT
-------------------------

This ReadMe document will help you get the most out of the 
database. Please contact us if you should encounter any problems 
with the database.

To view Readme.txt onscreen in Notepad, maximize the Notepad 
window.

To print Readme.txt, open it in Notepad or another word 
processor, and then use the Print command on the File menu.

Names in brackets, such as [Mines], refer to tables in the database.
Names in brackets seperated by a period, such as [Mines].[Foo] refer to
field [Foo] in the table [Mines].


Includes With this Data Set
===========================
1. Access 2000 data in a relational database.
2. Shapefile made from xy event in ArcGIS 10.2.2 using [Mines].[lon_WGS84] and [Mines].[lat_WGS84] fields.
3. Metadata, including the [DataDictionary] table, in .PDF format.



Table of Contents
=================
1. System Requirements
2. Introduction
     a.  Information Included
     b.  Compilation History
3. Key to Abbreviations used in the Mines and Prospects 
    Digital Database
     a. References
     b. Products
4. Total Production Figures
5. Key to the structure of the Mines and Prospects 
     Digital Database
6. Contact Information



1.  System Requirements
=======================
Microsoft Access 2000 or later, and Geographical Information System (GIS) software for opening the shapefile.




2.  Introduction
================

The Idaho Geological Survey's (IGS) Mines and Prospects digital database contains information on over 8,800 mining properties in Idaho. This inventory of mining activity and production is a  valuable research tool, particularly for mineral exploration and land management. All available sources have been used to compile  and correct this information, including published and unpublished reference materials, the U.S. Geological Survey's (USGS) Mineral  Resources Data System (MRDS), and the U.S. Bureau of Mines' Mineral Industry Location Subsystem (MILS). Every effort has been made to make the database complete and accurate; however, any additions or corrections should be directed to the Idaho Geological Survey. Periodic revisions of this database will be issued as new information is added. 


2A.  Information Included

Each mine or prospect is identified by its map location number, [*].[SequenceNumber], which is also the property number in the IGS's mining property files. In the Mines table, the [Mines].[latitude] and [Mines].[longitude] fields (NAD27) are the best available location for the property as plotted. WGS84 locations are included for use in Google Map, Google Earth, and ESRI map services (see online search tool at: http://www.idahogeology.org/webmap/).  Other useful location information (such as county in which the deposit occurs; its township, range, section, quarter section; the land owner; etc.) are also shown and updated for this version (1.2015.1).

A shapefile (MinesAndProspects.shp) built from the WGS84 coordinates that includes attributes from the [Mines] table, a .pdf file containing North American Profile of ISO 19115 metadata and the new (1.2015.1) [DataDictionary] (MinesAndProspects_Metadata.pdf), this ReadMe file (ReadMe.txt), and the Mines and Prospects database MinesAndProspects_1.2015.1).

The References field originally contained the single reference with the best information for spatially locating the property. Ongoing updates are slowly expanding the references for each property. These and other changes were recorded in the Z-updates field, which documents each change made to the database. If more detailed comments are needed, these are to be bound in the Annotations field. For the version 1.2051.1, a TrackChange table has been added to note changes to property locations and attributes for the database re-work 2014-15.  

Production figures were compiled from U.S. Bureau of Mines' unpublished records. For lode mines, the total amounts of ore produced and old tailings reprocessed (if any) are reported in tons; where tailings were reprocessed, these numbers are listed after a slash (i.e., ore/tailings). For placer mines, the production is given in yards of material processed. Production tonnage (or yardage) is most useful for determining the relative size of a deposit. For an individual deposit, caution should be used in comparing the tons of ore or yards of gravel mined with the metals obtained from the ore, because for some years the total amount (tons or yards) mined may be unknown or the data may be incomplete. For the commodities, gold and silver are in troy ounces; copper, lead, and zinc are in pounds. Reliable production data are not available for other commodities. To protect mining company confidentiality, single letters represent broad ranges in the amounts of ore and commodities produced (see below).  

For comparison purposes, each entry contains selected fields from the U.S. Bureau of Mines MILS database and the U.S. Geological Survey's MRDS database. This is information taken from the 1991 version of these databases and has not been compared with the current online version of the combined databases (http://mrdata.usgs.gov/mineral-resources/mrds-us.html). The MILS and MRDS databases will remain unchanged and are used simply as a reference in this database, though they are not yet noted in the database as a reference (however, if MILS or MRDS data is available for a property it will be available as a hyperlink on the web app). 

2B.  Compilation History.

The Mines and Prospects database has been an ongoing IGS research project for 25 years (as of 2015)!

The first editions of the Mines and Prospects Map Series were funded jointly under contracts and cooperative agreements between the Idaho Bureau of Mines and Geology (now the Idaho Geological Survey) and the U.S. Geological Survey, the U.S. Bureau of Mines  (now defunct), the U.S. Forest Service, and the U.S. Bureau of  Land Management. For the second editions, the maps and property  listings incorporated corrections and new data accumulated since  the original maps were published. This revision was done as part  of the Idaho Initiative Mapping Program, a cooperative research  project between the Idaho Geological Survey, the U.S. Geological  Survey, and the U.S. Bureau of Mines. Preparation of these digital publications is an on going process. The compilers for the various  editions of the Mines and Prospects for Idaho were Victoria E.  Mitchell, Ruth E. Vance, William B. Strowd, Gail S. Hustedde,  Julie A. Copeland, Margaret H. Ott, Earl H. Bennett, B. Benjamin E. Studer, Loudon R. Stanford, and Christopher A. Tate.
	
The original Mines and Prospects Map Series was compiled by referring to the best available reference for a site (preferably a map) and cross-checking that location against the information in MILS and MRDS. One opening was selected to represent each mine, and points were plotted as accurately as possibly on 1:250,000 maps.  Each dot used to plot a site covered about a quarter of a section. When these maps were digitized, the accuracy of each point was 0.25 miles (400 m) or less. 

In 1994, the Idaho Geological Survey began the first of a series of field programs in co-operation with the U.S. Forest Service (Regions 1 and 4) and the U.S. Bureau of Land Management to inspect inactive and abandoned mines in Idaho. These programs ran through 2005, and the results of most of them have been published as Idaho Geological Survey Staff Reports. When a site was visited, a detailed map of the site's features was made on a 1:24,000 map. The location of the largest and/or most significant feature was later digitized and updated into the database. Some of the later studies included the use of GPS units; these locations were entered directly into the database.

In 2008 in a project funded by the USGS under the National Geological and Geophysical Data Preservation Program, the Idaho Geological Survey began updating the locations of all the properties for which it has a mineral property file. These updated locations were plotted in National Geographic's TOPO! program at a scale of 1:24,000. The improved coordinates were then uploaded into the database.

Several projects funded by USGS and the Idaho Department of Lands resulted in a substantial re-work of the database 2009-2015. This included development of a Mines and Prospects web app, scanning of maps and other documents in the IGS archives to be hyperlinked for download, and 'cleaning up' the data and structure of the database. More information about the procedural changes for the 1.2015.1 version can be found in [mines_mdb_tracking_mdat]. This ReadMe was also updated.  

 

The data are current to the date on the version. 


3. Key to Abbreviations used in the Mines
     and Prospects Digital Database
=========================================

3A. References 

   1. Agency

     BLM    -     U.S. Bureau of Land Management
     DOE    -     U.S. Department of Energy
     DMA    -     Defense Minerals Administration
     DMEA   -     Defense Minerals Exploration Administration

     IBMG   -     Idaho Bureau of Mines and Geology
     IGS    -     Idaho Geological Survey  
     MSHA   -     Mining Safety and Health Administration
     OME    -     Office of Mineral Exploration
     USBM   -     U. S. Bureau of Mines

     USDA   -     U. S. Department of Agriculture
     USFS   -     U. S. Forest Service
     USGS   -     U. S. Geological Survey
     WFOC   -     Western Field Operations Center
     

   2. Publication

     B      -     Bulletin
     CR     -     County Report
     IC     -     Information Circular
     MILS   -     Mineral Inventory Location Subsystem
     MLA    -     Mineral Land Assessment

     MPF    -     Mineral Property File
     MR     -     Miscellaneous Report	
     MRDS   -     Mineral Resources Data System
     OFR    -     Open-File Report

     P      -     Pamphlet
     PP     -     Professional Paper
     RI     -     Report of Investigation
     SR     -     Special Report
     

3B. Products

   1. Metallic

     Ag     -     silver    
     Au     -     gold
     Ba     -     barium
     Be     -     beryllium
     Bi     -     bismuth
     Ca     -     calcium
     Cd     -     cadmium
     Ce     -     cerium
     Co     -     cobalt
     Cu     -     copper
     Fe     -     iron 
     Hg     -     mercury   
     Mg     -     magnesium
     Mn     -     manganese
     Mo     -     molybdenum
     Nb     -     niobium
     Ni     -     nickel
     P      -     phosphorous
     Pb     -     lead 
     Pt     -     platinum
     PGM    -     platinum group metals
     RE     -     rare earths
     Sb     -     antimony
     Si     -     silica
     Sn     -     tin
     Th     -     thorium
     Ti     -     titanium
     U      -     uranium
     V      -     vanadium
     W      -     tungsten
     Yt     -     yttrium
     Zn     -     zinc
     Zr     -     zirconium
                     
    2. Nonmetallic

     abr    -     abrasives
     bar    -     barite
     bk-sd  -     black sand
     cal    -     calcite
     cin    -     cinnabar
     cly    -     clay
     coal   -     coal 
     cor    -     corundum
     dit    -     diatomaceous earth
     dol    -     dolomite
     eva    -     evaporites
     fld    -     feldspar
     F      -     fluorite
     gar    -     garnet
     gas    -     gas
     gem    -     gemstones
     graph  -     graphite
     gyp    -     gypsum    
     lst    -     limestone
     mic    -     mica
     mon    -     monazite
     oil    -     oil
     opl    -     opal
     perl   -     perlite
     pho    -     phosphate
     pum    -     pumice
     qtz    -     quartz
     S      -     sulfur    
     sil    -     silica
     stn    -     stone
     Ta     -     tantalum
     vol    -     volcanic rocks
     zeo    -     zeolites
     



4.  Total Production Figures
============================

The following alphabet is used to protect the confidentiality of the 
production figures for the mines where data are known. These
values are also included in the "ProductionCodes" table in the
database.

The amounts are given, as applicable, in ounces, pounds, tons, or
yards.

     A   -     less than 50
     B   -     51-100
     C   -     101-500
     D   -     501-1,000
     E   -     1,001-5,000
     F   -     5,001-10,000
     G   -     10,001-50,000
     H   -     50,001-100,000
     I   -     100,001-500,000
     J   -     500,001-2,000,000
     K   -     2,000,001-4,000,000
     L   -     4,000,001-6,000,000
     M   -     6,000,001-8,000,000
     N   -     8,000,001-10,000,000
     O   -     10,000,001-12,000,000
     P   -     12,000,001-15,000,000
     Q   -     15,000,001-20,000,000
     R   -     20,000,001-30,000,000
     S   -     30,000,001-40,000,000
     T   -     40,000,001-50,000,000
     U   -     50,000,001-75,000,000
     V   -     75,000,001-100,000,000
     W   -     100,000,001-150,000,000
     X   -     150,000,001-200,000,000
     Y   -     200,000,001-250,000,000
     Z   -     250,000,001-300,000,000
     AA  -     300,000,001-500,000,000
     BB  -     500,000,001-750,000,000
     CC  -     750,000,001-1,000,000,000
     DD  -     1,000,000,001-1,500,000,000
     EE  -     1,500,000,001-2,000,000,000
     FF  -     2,000,000,001-3,000,000,000
     GG  -     3,000,000,001-4,000,000,000
     HH  -     4,000,000,001-5,000,000,000




5.  Key to the (revised format) structure of the
      Mines and Prospects Digital Database
==============================================

The details for the fields are available by viewing the accompanying "MinesAndProspects_Metadata.pdf" file.
  





6.  Contact Information:
========================

  To report bugs, discrepancies, or problems, please contact:

     Idaho Geological Survey
     ATTN: Christopher A. Tate    
     Morrill Hall Third Floor 
     University of Idaho
     P.O. Box 443014
     Moscow, Idaho  83844-3014

     E-mail:  ctate@uidaho.edu
     Phone:   (208) 885-7540

     Idaho Geological Survey Web Site
     http://www.idahogeology.org

     IGS Mines and Prospects web application
     http://www.idahogeology.org/webmap/

     Idaho Geological Survey 
     E-Mail: igs@uidaho.edu




================================================
======================

This readme file was last updated 02-20-2015 for Digital Database
version 1.2015.1.