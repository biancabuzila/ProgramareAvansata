DROP TABLE continents CASCADE CONSTRAINTS
/
DROP TABLE countries CASCADE CONSTRAINTS
/
DROP SEQUENCE continents_sequence
/
DROP SEQUENCE countries_sequence
/

CREATE TABLE continents (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR2(20) NOT NULL
)
/
CREATE SEQUENCE continents_sequence
    INCREMENT BY 1
    START WITH 1;
/
    
CREATE OR REPLACE TRIGGER continents_on_insert
  BEFORE INSERT ON continents
  FOR EACH ROW
BEGIN
  SELECT continents_sequence.nextval
  INTO :new.id
  FROM dual;
END;
/

CREATE TABLE countries (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR2(50) NOT NULL,
    code INT,
    id_continent INT NOT NULL,
    CONSTRAINT fk_countries_id_continent FOREIGN KEY (id_continent) REFERENCES continents(id)
)
/

CREATE SEQUENCE countries_sequence
    INCREMENT BY 1
    START WITH 1;
/
    
CREATE OR REPLACE TRIGGER countries_on_insert
  BEFORE INSERT ON countries
  FOR EACH ROW
BEGIN
  SELECT countries_sequence.nextval
  INTO :new.id
  FROM dual;
END;
/