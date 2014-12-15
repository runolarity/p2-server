p2 Server UI
============

This is the web ui for the p2 server. It's based on RAP.


UI Flow
-------

### 0. Nav Bar
- main (home)
- repositories
- about

### 1. Main View
- system health (signal style)
- system metrics (number of repositories, number of IUs)
- latest events
- teaser for creating repository

### 2. Repositories View
- table with all repositories
- CRUD actions for repos?

### 3. Repositoy View
- repository metrics (number of IUs, access stats)
- common repository actions (depends on repository type)
  mirror: re-sync, modify cron expression
