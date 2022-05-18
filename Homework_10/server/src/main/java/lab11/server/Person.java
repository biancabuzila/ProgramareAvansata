package lab11.server;

public class Person {

    private String name;
    private boolean logged = false;

    public Person(String name) {
        this.name = name;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isLogged() {
        return logged;
    }
    
    @Override
    public String toString() {
        return "Person{" + "name=" + name + '}';
    }
}
