package lab11.server;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

public class SocialNetwork {

    private DefaultUndirectedGraph socialNetwork = new DefaultUndirectedGraph<Person, DefaultEdge>(DefaultEdge.class);

    public void registerPerson(Person person) {
        socialNetwork.addVertex(person);
    }

    public boolean exists(String name) {
        for (Object p : socialNetwork.vertexSet()) {
            if (((Person) p).getName().equals(name)) {
                return true;
            }
            return true;
        }
        return false;
    }

    public Person getPerson(String name) {
        Person person = new Person("person");
        for (Object p : socialNetwork.vertexSet().toArray()) {
            if (((Person) p).getName().equals(name)) {
                person = (Person) p;
                break;
            }
        }
        return person;
    }

    public void addFriendship(String person1, String person2) {
        Person fstPerson = getPerson(person1);
        Person sndPerson = getPerson(person2);
        socialNetwork.addEdge(fstPerson, sndPerson);
    }

    public DefaultUndirectedGraph getSocialNetwork() {
        return socialNetwork;
    }
}
