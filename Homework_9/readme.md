### Homework 9

**Create all entity classes and repositories. Implement properly the one-to-many relationships.**

Am creat clasele entități _Continent_, _Country_ și _City_ în pachetul _Entities_ folosind suportul IDE-ului.

**Create a generic _AbstractRepository_ using generics in order to simplify the creation of the repository classes. You may take a look at the CrudRepository interface from Spring Framework.**

Am creat clasa abstractă _AbstractRepository_ (cu metodele _create_, _findById_, _findByName_ și _persist_) și clasele _ContinentRepository_, _CountryRepository_ și _CityRepository_ care o extind.

**Insert, using JPA, a large number of cities in the database and log the execution time of your JPQL queries.**

Am instanțiat un obiect _cityRepo_ de tipul _CityRepository_ și un obiect _countryRepo_ de tipul _CountryRepository_. Am instanțiat un obiect _country_ de tipul _Country_ în care am stocat țara "Romania" folodind metoda _countryRepo.findByName("Romania")_. Am creat o listă de nume de orașe din România și le-am adăugat în baza de date astfel: _cityRepo.create(new City(cityName,(short)0,country))_.

Am adăugat 2 proprietăți la clasa _City_, _startTime_ și _endTime_ de tip long, cu adnotarea _@Transient_ pentru a marca faptul că nu sunt stocate în tabelul din baza de date. Am creat o metodă _logStartTime_ cu adnotarea _@PrePersist_ care setează _startTime_ la timpul de dinaintea începutului adăugării obiectului în baza de date. Am creat o metodă _logEndTime_ cu adnotarea _@PostPersist_ care setează _endTime_ la timpul de după adăugarea obiectului în baza de date și care afișează timpul total al inserării obiectului în baza de date, scăzând _startTime_ din _endTime_.
