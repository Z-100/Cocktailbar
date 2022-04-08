# :suspension_railway: Components

This represents the entire structure of the database, but coded into the backend. <br />
Each individual component has their own DTO, DAO, Repository, mapper & controller. <br />

But what does that mean?
* DTO - Data Transfer Object
  * This is used to send data back to the client.
    * The difference to the DAO is, that certain properties can be "hidden"
    * e.g. passwords or tokens
* DAO - Data Access Object
  * Each DAO is an entity. Each one of those entities represents a table in the database.
    * The relationships in between the tables are represented in entities.
    * e.g. MC:MC / 1:M relationships.
* (CRUD)Repository
  * Every entity needs a connection to the database. That's the repository's job.
    * Actions like findAll(), getById(id) are specified in this interface.
    * SpringBoot then automatically maps the properties from the database to the corresponding entity
* Mapper (MapStruct)
  * A library, which generates the boring boiler-plate code, to map properties in between the DTOs and DAOs
* Controller
  * This is the connection of the API and the services.
    * Retrieves & sends data from and to the client.
