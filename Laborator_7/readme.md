### Laborator 7

**Create an object oriented model of the problem. You may assume that there are 10 tiles for each letter in the alphabet and each letter is worth a random number of points (between 1 and 10).**

**Each player will have a name and they must perform in a concurrent manner, extracting repeatedly tokens from the board.**

**After each extraction, the player will submit to the board all the letters.**

**Simulate the game using a thread for each player.**

Clasa *Tile* are ca proprietăți *letter* de tip char și *points* de tip int. Metodele sunt gettere și *toString* suprascrisă.

Clasa *Bag* are ca proprietate *tiles* de tip listă de perechi de literă și numărul de litere de acel fel introduse. Metodele sunt:
+ constructor - sunt introduse câte 10 piese pentru fiecare literă din alfabet
+ *extractFiles* - extrage aleator o piesă astfel: se generează aleator un index pentru literă și se scade numărul de astfel de litere, iar dacă numărul ajunge la 0 se șterge perechea respectivă din *tiles*

Clasa *Board* are ca proprietate *words* de tip listă de string-uri. Metoda *addWord* adaugă cuvântul dat ca parametru în *words* și afișează numele jucătorului alături de cuvântul creat de el.

Clasa *Player* are ca proprietăți *name* de tip string, *game* de tip *Game* și *running* de tip boolean. Metodele sunt:
+ *submitWord* - creează cu un *StringBuilder* cuvântul cu literele de pe piesele extrase și returnează true dacă acest lucru este posibil, false altfel
+ *run* - apelează *submitWord* cât timp returnează true

Clasa *Game* are ca proprietăți *bag* de tip *Bag*, *board* de tip *Board* și *players* de tip listă de *Player*. Metodele sunt:
+ *addPlayer* - adaugă un jucător
+ *play* - creează un fir de execuție pentru fiecare jucător
+ *main* - creează un joc, adaugă jucători și începe jocul