### Laborator 11

**Create a Spring Boot project containing the REST services for comunicating with the database.**

**Create a REST controller containing methods for:**

- **obtaining the list of the persons, via a HTTP GET request.**
- **adding a new person, via a HTTP POST request.**
- **modifying the name of a person, via a HTTP PUT request.**
- **deleting a person, via a HTTP DELETE request.**

Am creat clasa _Person_ care are ca prorpietate _name_ de tip String, iar metodele sunt constructor pentru _name_, getter si setter pentru _name_.

Am creat clasa _PersonController_ cu adnotările _@RestController_ și _@RequestMappping("/persons")_. Are ca proprietate _persons_ de tip listă de _Person_. Constructorul adaugă niște persoane în lista _persons_. Metodele sunt:

- _getPersons_ - are adnotarea _@GetMapping_ și returnează _persons_
- _findByName_ - are adnotarea _@GetMapping("/{name}")_ și returnează persoana cu numele dat în path
- _addPerson_ - are adnotarea _@PostMapping_ și adaugă la _persons_ persoana cu numele dat
- _updatePerson_ - are adnotarea _@PutMapping("/{oldName}")_ și modifică numele persoanei dat în path
- _deletePerson_ - are adnotarea _@DeleteMapping("/{name}")_ și șterge persoana cu numele dat în path
