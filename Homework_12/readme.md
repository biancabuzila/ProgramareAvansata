### Homework 12

**The input may be a folder (containing .class files) or a .jar. You must explore it recursively. Create the complete prototype, in the same manner as javap tool.**

În clasa *MyTestFramework* am adăugat metoda *exploreFile* care parcurge recursiv directorul a cărui cale este dată ca argument în program. Când ajunge la directorul *classes* adaugă calea curentă la classpath. Dacă ajunge la un fișier a cărui extensie este *.class*, atunci afișează numele clasei, numele câmpurilor și tipul lor, constructorii și parametrii lor, numele metodelor și parametrii acestora.

**Identify all public classes annotated with *@Test* and invoke the methods annotated with *@Test*, whether static or not. If a method requires primitive (at least int) or String arguments, generate mock values for them. Print a statistics regarding the tests.**

În clasa *MyTestFramework* am adăugat metodele:
+ *invokeTest* - parcurge recursiv directorul dat ca argument. Pentru fișierele cu extensia *.class* și care au adnotarea *@Test*, trece prin toate metodele clasei iar pentru cele care sunt publice și au adnotarea *@Test*, le invocă. Dacă metoda este statică, atunci obiectul cu referință la clasă necesar apelului *invoke* este *null*, altfel este o instanță a clasei respective. Dacă metoda are parametri, atunci in lista de obiecte *parameters* necesară apelului *invoke* sunt adăugate valori aleatoare în funcție de tipul lor (cazurile tratate sunt pentru int, String și boolean). 
+ *randomString* - returnează un String cu caractere aleatoare de lungime egală cu valoarea argumentului de tip int dat funcției.

Pentru fiecare clasă sunt numărate testele trecute și cele eșuate, la finalul invocării metodelor sale fiind afișate aceste valori.