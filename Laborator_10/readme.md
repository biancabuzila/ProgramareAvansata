**Create the project for the server application.**

Am creat proiectul _server_.

**Implement the class responsible with the creation of a ServerSocket running at a specified port. The server will receive requests (commands) from clients and it will execute them.**

Am creat clasa _Server_ care se ocupă de crearea unui _SrverSocket_ la portul 8100. Am setat timeout-ul la 20 de secunde, serverul astfel oprindu-se după acest timp dacă nu mai primește cereri de la clienți.

**Create a class that will be responsible with communicating with a client Socket. The communication will be on a separate thread. If the server receives the command stop it will stop and will return to the client the respons "Server stopped", otherwise it return: "Server received the request ... ".**

Am creat clasa _ClientThread_ care extinde _Thread_, iar metoda _run_ suprascrisă se ocupă de citirea request-ului de la client și trimite un răspuns pe baza acestuia. Dacă request-ul este _stop_, server-ul se va opri.

**Create the project for the client application.**

Am creat proiectul client.

**A client will read commands from the keyboard and it will send them to the server. The client stops when it reads from the keyboard the string "exit".**

Am creat clasa _Client_ care se ocupă de citirea de la tastatură a unui request, trimiterea acestuia la server și de afișarea răspunsului primit. Dacă acesta este _exit_ atunci clientul se va opri. ocupă de citirea de la tastaură a unui request de tip string. Dacă acesta este _stop_ atunci serverul se va opri, iar dacă este _exit_ atunci clientul se va opri.
