### Laborator 8 - Compulsory

**Create a relational database using any RDBMS (Oracle, Postgres, MySql, Java DB, etc.).**

Am creat baza de date World, folosind Oracle.

**Write an SQL script that will create the following tables:**

- **_countries_: id, name, code, continent**
- **\*continents: id, name**

Scriptul este World.sql.

Tabela _continents_ are ca și coloane:

- _id_ de tip _INT_ ca fiind cheie primară și care nu poate fi null
- _name_ de tip _VARCHAR2_ ce nu poate fi null.

Tablea _countries_ are ca și coloane:

- _id_ de tip _INT_ ca fiind cheie primară și care nu poate fi null
- _name_ de tip _VARCHAR2_ ce nu poate fi null
- _code_ de tip _INT_
- _id_continent_ pentru care am creat o constrângere de tip cheie străină care face referire la _id_ din tabela _continents_

**Update pom.xml, in order to add the database driver to the project libraries.**

Am adăgat dependența necesară și am instalat jar-ul corespunzător.

**Create a singleton class in order to manage a connection to the database.**

Clasa _Database_ se ocupă de crearea conexiunii cu baza de date, iar metoda privată statică _createConnection_ face clasa să fie de tip singleton.

**Create DAO classes that offer methods for creating countries and continents, and finding them by their ids and names.**

Clasele _ContinentsDAO_ și _CountryDAO_ se ocupă de adăugarea unui continent, respectiv a unei țări în tabelele asociate bazei de date World. Ambele au metodele _findByName_ și _findById_.

**Implement a simple test using your classes.**
