### Homework 10

**Create an object-oriented model for your application and implement the commands.**

Am creat clasa _Person_ care are ca proprietăți _name_ de tip String și _logged_ de tip boolean. Metodele create sunt constructor care setează valoarea lui _name_, gettere și settere pentru ambele proprietăți și _toString_ suprascrisă.

Am creat clasa _SocialNetwork_ ce are ca proprietate _socialNetwork_ de tip DefaultUndirectedGraph, având nodurile de tip _Person_ și muchiile de tip _DefaultEdge_. Metodele acestei clase sunt:

- _registerPerson_ - adaugă persoana dată ca parametru la nodurile grafului
- _exists_ - verifică dacă în graf există persoana cu numele de tip String dat ca parametru
- _getPerson_ - returnează din graf persoana cu numele de tip String dat ca parametru
- _addFriendship_ - adaugă la graf muchie între cele 2 persoane cu numele de tip String date ca parametri
- getter - pentru _socialNetwork_

În clasa _ClientThread_ am adăugat ca proprietate _client_ de tip _Person_ și _server_ de tip _Server_. În metoda _run_, pentru comenzile _register name_, _login name_, _friend name1 name2 ..._ am creat câte o funcție care se ocupă cu adăugarea persoanei în graf, autentificarea persoanei în aplicație, respectiv adăugarea de muchii între persoane.

Nu am implementat acțiuni pentru comenzile de trimitere și citire de mesaje.

**Implement a timeout for a connection (a number of minutes). If the server does not receive any command from a logged in client in the specified period of time, it will terminate the connection.**

Am setat timeout-ul la 20 de secunde cu comanda _serverSocket.setSoTimeout(timeout)_, unde _timeout = 20000_ (de tip int).
