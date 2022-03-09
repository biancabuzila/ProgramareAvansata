### Homework 2

**Create a class that describes an instance of the *problem*.**

Clasa *Problem* are ca proprietăți array-ul *events* de tip *Event* și array-ul *rooms* de tip *Room*. Metodele sunt *getNrEvents* , *getNrRooms* (returnează numărul de evenimente, respectiv de camere din instanța problemei), *getEvent*, *getRoom* (returneză evenimentul, respectiv camera cu indexul specificat ca parametru).

**Override the *equals* method form the *Object* class for the *Event*, *Room* classes. The problem should not allow adding the same event or room twice.**

**Instead of using an *enum*, create dedicated classes for lecture halls and computer labs. *Room* will become *abstract*. The course room may have an additional property indicating if there is a video projector, and the lab room may indicate the operating system of its computers.**

Clasa *LectureHall* are proprietatea *videoProjector* de tip boolean. Clasa *ComputerLab* are proprietatea *os* de tip String.

**Create a class to describe the solution.**

Clasa *Solution* are ca proprietate array-ul *assignment* de tip *Room* ce reține care cameră este asociată fiecărui eveniment. Metodele sunt *setAssignment* (setează soluția ca fiind cea dată ca parametru), *computeUsedRooms* (returnează numărul de camere folosite de către soluție) și *sameRoom* (returnează *true* în cazul în care camera cu indexul dat ca parametru a apărut deja în *assignment* anterior, *false* altfel).

**Implement a simple algorithm for creating a feasible solution to the problem, "trying" to minimize the number of used rooms. Write doc comments in your source code and generate the class documentation using javadoc.**

Clasa *Algorithm* are ca proprietate *pb* de tip *Problem*. Metoda *solve* rezolvă problema astfel:
1. creează o matrice *schedule* de tip boolean cu numărul de linii egal cu numărul de camere și numărul de coloane egal cu 24 (ore într-o zi) ce marchează cu *true* orele ocupate de camera respectivă, și cu *false* orele libere
2.  pentru fiecare eveniment caută o cameră în ordinea în care camerele apar și îi este atribuită dacă
	+ numărul de participanți la eveniment este mai mic sau egal cu capacitatea camerei
	+ orele la care are loc evenimentul sunt libere în camera respectivă (lucru verificat cu ajutorul metodei *free*)
3. dacă evenimentului i s-a atribuit o cameră, valorile din *schedule* pentru acea cameră și orele la care are loc evenimentul sunt actualizate