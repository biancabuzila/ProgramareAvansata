### Compulsory - Laborator 3

**Create an object-oriented model of the problem. You should have at least the following classes *Network*, *Node*, *Computer*, *Router*, *Switch*. The natural ordering of the nodes is given by their names.**
**Create the interfaces *Identifiable* and *Storage*. The classes above must implement these interfaces accordingly.**
**The *Network* class will contain a *List* of nodes.**
**Create and print all the nodes in the network (without the time costs).**

Am creat clasele enumerate mai sus astfel:
+ *Node* este clasă abstractă (proprietate: *name*; constructor, getter și setter pentru *name*, metoda suprascrisă *toString*)
+ *Computer* moștenește clasa *Node* și implementează interfețele *Identifiable* și *Storage* (proprietăți: *address*, *storageCapacity*; constructor, gettere și settere pentru toate proprietățile, metoda suprascrisă *toString*)
+ *Router* moștenește clasa *Node* și implementează interfața *Identifiable* (proprietate: *address*; constructor, getter și setter pentru *address*, metoda suprascrisă *toString*)
+ *Switch* moștenește clasa *Node* (constructor pentru *name*)
+ *Network* (proprietate: *nodes* care e un *List* de *Node*; constructor, getter și setter pentru *nodes*, metoda suprascrisă *toString*)