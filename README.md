LANCER PIZZAIOLO

- lancer docker-compose up (step 5)
- dans eclipse : windows>preferences>git changer le chemin du workspace (par /workspace/git)
- idem dans maven installation : importer une installation externe : /maven et remplacer le settings.xml par celui qui se trouve dans /maven/conf/
- importer le projet via git (ou à ajouter au volume eclipse si pas internet)
- importer tomcat comme pour la step 4
- convertir en projet maven puis dans properties> project facets> runtime (en haut à droite ) choisir tomcat
- faire un maven update projet
- ajouter le projet à tomcat et lancer tomcat 
- done!
