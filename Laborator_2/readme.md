### Compulsory - Laborator 2
**Create an object-oriented model of the problem. You should have (at least) the following classes: *Event*, *Room*. The start and end time will be integers. The rooms will also have the property *type*. The available types will be implemented as an *enum*.**

Am creat clasele *Event*, *Room*, fiecare având proprietățile precizate, și anume:
+ pentru *Event* : *name* de tip String, *size* de tip int, *start* și *end* de timp int
+ pentru *Room* : *name* de tip string, *type* de tip *RoomType* (care este un *enum*) și *capacity* de tip int

**Each class should have appropriate constructors, getters and setters.**

Pentru ambele clase am construit câte un constructor care primește toate informațiile necesare pentru a fi completate toate câmpurile/proprietățile. Ambele clase au câte un getter și câte un setter pentru fiecare proprietate în parte.
În constructori, settere și gettere am verificat următoarele:
+ *capacity* și *size* iau valori strict pozitive
+ *start* și *end* iau valori din intervalul [0, 24]

**The *toString* method form the Object class must be properly overridden for all the classes. Create and print on the screen the objects in the example.**

Am realizat suprascrierea metodei *toString* astfel încât afișarea obiectelor (a proprietăților acestora) să arate precum exemplele date în enunțul problemei de la laborator. În clasa *Main* am creat obiectele din exemplele date (cu ajutorul constructorilor) și apoi le-am afișat pe ecran.