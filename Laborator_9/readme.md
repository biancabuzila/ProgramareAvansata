### Laborator 9 - Compulsory

**Create a persistence unit (use EclipseLink or Hibernate or other JPA implementation).**

Am folosit EclipseLink.

**Define the entity classes for your model (at least one) and put them in a dedicated package. You may use the IDE support in order to generate entity classes from database tables.**

Am creat pachetul _Entities_ care conține clasele entități din tabelele din baza de date World creată la laboratorul 8.

**Create a singleton responsible with the management of an EntityManagerFactory object.**

Clasa _PersistenceUtil_ are ca proprietate _emf_ ca _EntityManagerFactory_ și ca metode _createEntityManager_ și _getEntityManager_.

**Define repository clases for your entities (at least one). They must contain the following methods:**
**+ _create_ - receives an entity and saves it into the database;**
**+ _findById_ - returns an entity based on its primary key;**
**+ _findByName_ - returns a list of entities that match a given name pattern. Use a named query in order to implement this method.**

Am creat pachetul _Repositories_ care conține (for now) clasa _Continent_ cu metoda _findByName_ care folosește un named query.
