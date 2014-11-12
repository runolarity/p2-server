p2 Server Scenarios
===================

This document defines and describes the scenarios we want to enable and support with the p2 Server.

The key words "MUST", "MUST NOT", "REQUIRED", "SHALL", "SHALL NOT", "SHOULD", "SHOULD NOT", "RECOMMENDED", "MAY", and "OPTIONAL" in this document are to be interpreted as described in RFC 2119.



1. Mirroring
------------

Given an URL to a remote p2 repository, the p2 Server can create a local mirror. 

Simple as well as composite repository shall be supported as remote repositories. All artifacts and all metadata available in the remote p2 repository will be made available on the p2 Server under a given URL. The data shall be stored locally so that it is available in case the remote repository is offline. The mirroring operation will be performed asynchronously. It can be triggered manually, scheduled to occur at a specified time (cron expression) and/or based on events triggered by a web hook to allow integration with 3rd party systems.


2. Deployment of p2 repositories with Maven Tycho
-------------------------------------------------

Using 'mvn deploy' it shall be possible to deploy Tycho based p2 repository Maven module projects.

The p2 repository will be made available on the p2 Server under a given URL. At the main repository URL a composite repository shall be made available which exposes an aggregated view over every deployed repository version. A lightwight approval process supports staging of new uploads for review. The p2 Server must allow to configure whether only 'approved' versions will be made available in the composite repository or every deployed version. 

The p2 Server should allow tagging for specific repository versions. Deep linking techniques allow access to a specific version, a tagged version as well as the latest 'approved' and the latest 'deployed' ('uploaded') version. 

A Maven deployment operation should be atomic - it either succeeds or fails.

The p2 Server must allow to configure a maximum numbers of version which will be kept on the server. If the limit is exceeded, old versions shall be removed (starting with the oldest) till the limit restored. A user must be able to identify (mark) versions which shall never be deleted automatically by the p2 Server.


3. Promotion of p2 repositories into release repositories
---------------------------------------------------------

The p2 Server must allow to promote a particular p2 repository version into a release repository. A release repository is a p2 repository which must not allow direct deployments but aggregates other repositories.
