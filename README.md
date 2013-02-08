Instructions
==================

Build
-----
$mvn clean install assembly:assembly

Run App
---------
$cd {project}/target <br/>
$java -jar {project}.jar inputFile1 inputFile2 outputFile


1. What do you expect to be the maximum size of the input files that your project can handle ? 
--------------------------------------------------------------------------
Depends on -Xmx and word length per line<br/>
Word: Unicode String costs 2byte/char + Integer costs 4byte <br/>
example: [-Xmx 256 * 1024 * 1024 bytes] / [(word.name 4chars * 2byte) + 4bytes] <br/>
~ 15 Mb deferent words!


2. What would you do to increase this limit ?
---------------------------------------------------
increase -Xmx


3. Is your program efficient ?
-------------------------------------------------
No


4. What would you do to increase its performance ?
------------------------------------------------------
a.) Use DBMS or <br/>
b.) Use cache with file storage or <br/>
c.) Use files as storage
