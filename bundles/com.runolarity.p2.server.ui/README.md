p2 Server UI
============

This is the web ui for the p2 server. It's based on AngularJS, Bootstrap and Sass. For development it uses Bower and Grunt to manage dependencies and build the project. Grunt will be triggered automatically from a Maven build so that the production code generated and published.


Day-to-day Commands
-------------------

```
grunt serve   #This will run a development server with watch & livereload enabled.
grunt test    #Run local unit tests.
grunt build   #Places a fully optimized (minified, concatenated, and more) in /dist
```

UI Flow
-------

0. Nav Bar
- main (home)
- repositories
- about

1. Main View
- system health (signal style)
- system metrics (number of repositories, number of IUs)
- latest events
- teaser for creating repository

2. Repositories View
- table with all repositories
- CRUD actions for repos?

3. Repositoy View
- repository metrics (number of IUs, access stats)
- common repository actions (depends on repository type)
  mirror: re-sync, modify filter
