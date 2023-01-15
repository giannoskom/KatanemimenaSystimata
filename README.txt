Το backend αποτελειται απο μια βαση postgres μεσω docker.
Δυστηχως υπαρχει ενα ερρορ που δεν καταφεραμε να διορθωσουμε ακομη αλλα θα εχει φτιαχτει μεχτι το επομενο
παραδοτεο.

org.postgresql.util.PSQLException: FATAL: role "postgres " does not exist

-δημιουργια βασης:
	docker run --name car_db --rm -e  POSTGRES_PASSWORD=pass -e POSTGRES_DB=unicar --net=host -v pgdata14:/var/lib/postgresql/data  -d postgres:14

	psql -h localhost -U postgres -d unicar -p 5432 -W