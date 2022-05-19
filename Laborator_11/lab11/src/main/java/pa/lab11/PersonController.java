package pa.lab11;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final List<Person> persons = new ArrayList<>();

    public PersonController() {
        persons.add(new Person("Matei"));
        persons.add(new Person("Stefan"));
    }

    @GetMapping
    public List<Person> getPersons() {
        return persons;
    }

    @GetMapping("/{name}")
    public Person findByName(@PathVariable String name) {
        return persons.stream()
                .filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }

    @PostMapping
    public void addPerson(@RequestParam String name) {
        persons.add(new Person(name));
    }

    @PutMapping("/{oldName}")
    public ResponseEntity<String> updatePerson(@PathVariable String oldName, @RequestParam String newName) {
        Person person = findByName(oldName);
        if (person == null) {
            return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND); //or GONE
        }
        person.setName(newName);
        return new ResponseEntity<>("Person updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deletePerson(@PathVariable String name) {
        Person person = findByName(name);
        if (person == null) {
            return new ResponseEntity<>("Person not found", HttpStatus.GONE);
        }
        persons.remove(person);
        return new ResponseEntity<>("Person removed", HttpStatus.OK);
    }
}
