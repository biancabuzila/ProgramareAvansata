### Homework 1

**Let *n*,* p* be two integers and C<sub>1</sub>,...,C<sub>m</sub> a set of letters (the alphabet), all given as a command line arguments. Validate the arguments!**

Am considerat că argumentele sunt valide daca sunt îndeplinite următoarele condiții:
+ sunt date cel puțin 3 argumente (*n*, *p* și măcar o literă)
+ *n* și *p* sunt ambele numere întregi strict pozitive
+ fiecare C<sub>i</sub> reprezintă o singură literă majusculă

** Create an array of *n* strings (called *words*), each word containing exactly *p* characters from the given alphabet. Display on the screen the generated array.**

Am folosit metoda *generate* a clasei Main. Aceasta construiește un array de *n* cuvinte a câte *p* caractere din array-ul de char *c*, pe care îl returnează. Cele *p* caractere sunt alese în mod aleator din *c* cu ajutorul funcției *Math.random()*. În *pos* va fi stocată o valoare cuprinsă între 0 și *m*; dacă *pos*=*m* (*pos* depășește limitele array-ului *c*) atunci va fi aleasă o altă valoare în același mod. Variabila *pos* reprezintă poziția în *c* pe care se află caracterul ce urmează a fi concatenat la cuvântul construit la acel moment.

**Two words are neighbors if they have a common letter.**
+ **Create a boolean *n x n* matrix, representing the adjacency relation of the words.**

Am folosit metoda *neighbor* a clasei Main. Aceasta primește două cuvinte și returnează *true* dacă sunt vecine, respectiv *false* altfel. Pentru implementare am considerat că literele primite ca argumente pot fi doar litere mari (deci în număr de 26).
Am declarat un array de valori booleene *exists* care ne spune dacă litera alfabetului de pe poiziția asociată ei în array (litera - 'A') există sau nu în primul cuvânt. Trecem prin caracterele celui de-al doilea cuvânt și dacă există cel puțin unul care se află și în primul cuvânt (lucru verificat cu ajutorul lui *exists*) atunci înseamnă că cele 2 cuvinte sunt vecine.
Pentru a construi matricea de adiacență (care este simetrică față de diagonala principală) am verificat pentru fiecare cuvânt din *words* cu ajutorul metodei *neighbor* care dintre cuvintele următoare lui din array sunt vecine cu el.

+ **Create a data structure (using arrays) that stores the neighbors of each word. Display this data structure on the screen.**

Am creat o matrice de String-uri *neighbors*. Pentru fiecare cuvânt din *words* am numărat valorile *true* din *matrix[i]* pentru a vedea câți vecini are cuvântul respectiv astfel încât să nu avem valori de null în *neighbors*. Apoi pentru fiecare valoare *true* am adăugat în *neighbors[i]* cuvântul asociat poziției din *matrix* cu care este vecin.