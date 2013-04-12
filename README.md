Instructions
==================

Build
-----
$mvn clean install assembly:assembly

Run App
---------
$cd {project}/target <br/>
$java -jar {project}-with-dependencies.jar inputFile1 inputFile2 outputFile

Scalable
---------
No <br/>
Could be scalable by implementing the <a href="http://en.wikipedia.org/wiki/Trie" target="_blank">prefix tree</a> data structure
