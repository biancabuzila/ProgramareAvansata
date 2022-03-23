### Homework 4

**Create a class that describes the city.**

Clasa *City* are ca atribut *cityMap* de tip *Map* cu cheia de tip *Intersection* și valoarea de tip *List< Street >*. Metodele clasei sunt:
+ constructor, getter și setter pentru *cityMap*
+ *toString* suprascrisă
+ *joinedStreets(Street street)* ce returneză numărul de străzi ce sunt conectate de strada dată ca parametru.

**Using Java Stream API, write a query that display all the streets that are longer than a specified value and join at least 3 streets.**

Am folosit 2 filtre pe stream-ul aplicat pe array-ul de străzi *streets*:
+ unul care le păstrează doar pe cele cu lungimea mai mare decât 2
+ unul care le păstrează doar pe cele care conectează măcar 3 străzi (condiție verificată cu ajutorul metodei *joinedStreets*).
Apoi am afișat străzile care au rămas în urma filtrelor aplicate.

**Use a third-party library in order to generate random fake names for intersections and streets.**

Pentru străzi am folosit *faker.address().streetName()*, iar pentru intersecții *faker.address().streetAddress()*.

**You may use this package of JGraphT in order to solve the problem (or other library).**

Am creat un graf neorientat de tipul *DefaultUndirectedWeightedGraph< Intersection, DefaultWeightedEdge >*.  Am adăugat vârfurile, muchiile și costurile folosind stream-uri pe array-urile *nodes* de intersecții și *streets* de străzi. Apoi am afișat fiecare muchie din arborele creat de metoda *KruskalMinimumSpanningTree<>(g).getSpanningTree()*.

**Implementare personală pentru rezolvarea problemei**

Am creat o clasă *Solution* care are atributul *city* de tip *City* și metodele:
+ constructor, getter și setter pentru *city*
+ *solve* care reprezintă algoritmul lui Prim și afișează muchiile din arborele parțial de cost minim găsit ca soluție pentru graful reprezentat de *city*
+ *getStreet(Intersection begin, Intersection end)* care returnează strada care are capetele precizate ca parametri.