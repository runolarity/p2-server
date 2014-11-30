p2 Server Core
==============

This is the core bundle for the p2 server. It contains the core functionality developed entirely in Java and hosts the REST API as Gyrex Application.


Architecture
------------

The p2 Server architecture is driven by ease of setup and server operation. It shall be possible to just deploy the server within a few minutes. Therefore, the architecture shall be self-containing, allowing deployment of a p2 Server without requiring the deployment if any additional technology (such as a database or search server). However, separate deployment of those components might become necessary when scaling out.

As any other Eclipse/Gyrex application, the p2 Server has a workspace. The workspace is defaulted to a OS common place.

All data (such as repository information, etc.) shall be stored as files on the local disc within the workspace. Modification of such files directly on disc will be supported. The p2 Server will monitor the files for modifications and reload them when necessary. Any external modification of files outside of the p2 Server may require the invocation of maintenance operations within the server (such as re-indexing).

There is no support for concurrent modification of such files. The p2 Server is not expected to be administrated concurrently by two or more users. The last write wins.

All repositories will have their own storage location. The p2 Server does not use shared bundle pools to reduce storage size on disc.

The p2 Server offers an Eclipse p2 compatible API for accessing repositories. The API exposes a simple p2 repository with artifacts.xml.gz, content.xml.gz and p2.index file. At runtime, when such API is accessed, the information will be computed dynamically by querying the Solr index. The API might cache it for some time and use cache tags for optimized transfer.

Due to the index based query architecture, several oerations require a refresh/update of the index. The p2 Server must ensure that an index update is prepared in the background in a shaddow index and then switched active once an operation completed successfuly.


Index Architecture
------------------

All repository information shall be indexed in Solr.

There will be one index for all repository IU information. A document will be generated per IU, repository and version. 

The document uniquness is defined as follows:
  - repository id
  - repository version (always empty for mirrored repositories)
  - IU id
  - IU version

Additional document information:
  - repository type
  - repository version approval flag
  - repository version tags
  - IU description
  - IU type
  - other IU metadata tbd.


Open Questions
--------------

* Should we use our own repository type combining artifact and metadata for efficiency?

* mirros
  - mirror artifacts from composity into flat repo
  - garbage collect/cleanup mirrored repos

* deployment repos
  - one repo per deployed version
  - store list of repos (and their tags and approved flag) in parent folder
  - dynamically expose composite xmls
