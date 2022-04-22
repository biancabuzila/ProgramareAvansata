### Homework 7

**Create an implementation of a dictionary, using some collection of words. Use an appropriate collection to represent the dictionary. This collection should be large enough; you may use aspell to generate a text file containing English words, or anything similar: WordNet, dexonline, etc.**

Am creat o interfață _Dictionary_ care are metoda _getWords_ ce returnează un set de string-uri.

Am creat o clasă _MockDictionary_ care implementează _Dictionary_. Are ca proprietate _words_ ca fiind un set de string-uri. Constructorul adaugă în _words_ cuvintele din fișierul _dictionary.txt_ generat cu aspell, din directorul src/main/resources.

În clasa _Player_ am adăugat proprietatea _requestedTiles_ de tip int care este 7 la începutul jocului, _tiles_ de tip listă de _Tile_ ce reprezintă piesele deținute de jucător și _score_ de tip int ce reprezintă scorul jucătorului care este 0 la începutul jocului.

În clasa _Player_ am modificat metoda _submitWord_. Am creat un map pentru literele de pe piesele extrase și un map pentru literele cuvântului curent din dicționar (cheia este litera, iar valoarea este numărul de astfel de litere). Astfel, trec prin toate cuvintele din dicționar iar când ajung la unul pentru care literele acestuia se regăsesc printre literele pieselor extrase și pentru care numărul de litere de același fel este cel puțin egal cu numărul de litere de același fel din piesele extrase, apelez _addWord_. (ex: cuvântul din dicționar este tall; nu e suficient ca jucător să am piesele cu literele a,t,l ci trebuie să am măcar 2 piese cu litera l).

Dacă un jucător reușește să formeze un cuvânt valid, atunci:

- _requestedTiles_ devine lungimea cuvântului format
- _score_ se actualizează conform regulilor enunțului problemei
- din _tiles_ scoatem piesele folosite pentru formarea cuvântului

Dacă un jucător NU reușește să formeze un cuvânt valid, atunci:

- _requestedTiles_ devine 7
- _tiles_ se golește
- adăugăm înapoi în _bag_ piesele nefolosite de jucător

**Implement the scoring and determine who the winner is at the end of the game.**

Pentru a afișa câștigătorul la finalul jocului, pentru fiecare thread creat pentru jucători am folosit _join_. Astfel, afișez jucătorul care are scorul cel mai mare.

**Make sure that players wait their turns, using a wait-notify approach.**

**Implement a timekeeper thread that runs concurrently with the player threads, as a daemon. This thread will display the running time of the game and it will stop the game if it exceeds a certain time limit.**

Urmează să fac și ultimele 2 cerințe din temă.
