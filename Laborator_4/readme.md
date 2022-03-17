### Laborator 4

Clasele se află în src/main/java.

**Create an object-oriented model of the problem. Streets have names and lengths, intersections have names. A street joins two intersections.**

Clasa *Street* implementează interfața *Comparable* și are ca proprietăți:
+ *name* (String)
+ *length* (int)
+ *begin* și *end* (Intersection, reprezentând cele 2 intersecții pe care le unește o stradă),

iar ca metode:
+ constructor pentru *name*
+ constructor pentru toate proprietățile
+ settere și gettere
+ *compareTo* suprascrisă
+ *toString* suprascrisă
+ *compareByLength* ce compară 2 străzi după lungime.

Clasa *Intersection* are ca proprietate *name* (String) și ca metode:
+ constructor pentru *name*
+ settere și gettere
+ *toString* suprascrisă.

**Create the streets and the intersections of the problem described in the example. Use *streams* in order to easily create the intersections.**

Am creat un array de tipul *Intersection* în care am pus toate nodurile de pe graful din exemplul de la laborator cu ajutorul unui stream:
+ IntStream.rangeClosed(0, 8) - consideră numerele de la 0 la 8
+ mapToObj(i -> new Intersection("v" + i)) - transformă în obiect de tipul *Intersection* cu numele "v" concatenat cu valoarea respectivă la care se ajunge între 0 și 8
+ toArray(Intersection[]::new) - pune toate obiectele create anterior într-un array de tipul *Intersection*.

**Create a *list* of streets, using *LinkedList* implementation and sort it by the length, using a *comparator* expressed as a *lambda-expression* or *method reference*. Make sure all the objects are *comparable*.**

Am creat mai întâi un array de tip *Street* în care am pus toate străzile din graful dat ca exemplu la laborator. Apoi am creat un *LinkedList* de tipul *Street* pe care l-am inițializat cu array-ul creat anterior (*Arrays.asList(streets)*).

**Create a *set* of intersections, using a *HashSet* implementation. Verify the property that a *Set* does not contain duplicates.**

Am creat un *HashSet* de tipul *Intersection* și l-am inițializat cu array-ul de tip *Intersection* creat anterior. Am realizat verificarea prin afișarea mesajului *The set does not contain duplicates* dacă *!nodeSet.add(nodes[0])* (elementul *nodes[0]* există deja în set, deci funcția nu îl mai adaugă încă o dată).