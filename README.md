Dit project is de New Nexus Skills applicatie gebruikt in de 'AngularJS' workshop. Het leuke is dat de applicatie nu ook in de cloud 
staat: http://skills-codist.rhcloud.com/api/persoon.json


# Hoe te draaien #

mvn clean install zorgt voor de bouw van het project.

mvn jetty:run -Dspring.profiles.active=dev zorgt voor het opstarten van de app.



# Setup van het project zelf

Het project is een Java project gemaakt met JAX-RS, Spring en Hibernate. Het doel is om REST services beschikbaar te stellen
aan een voorkant. Momenteel is er geen security geimplementeerd.

De applicatie bestaat uit 3 lagen:

## REST laag
Geimplementeerd met JAX-RS. Deze laag gebruikt de service laag om de REST CRUD acties uit te voeren. De laag is verantwoordelijk
voor het transformeren van het REST model naar het interne model. Dozer is gebruikt voor deze transformatie.

De REST laag is als volgt te benaderen: http://localhost:8080/newnexus/api/persoon.json

## Service laag
De service laag is verantwoordelijk voor Transactie demarcatie en het benaderen van de repository laag. In de service laag
zal ook enentuele business logica geplaatst worden.

## Repository / DAO laag
Verantwoordelijk voor de CRUD operaties op de database. Hibernate is gekozen als ORM framework. Spring Data JPA dient
als eenvoudige tool om snel CRUD repositories te maken.


