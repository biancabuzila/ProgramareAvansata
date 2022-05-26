### Laborator 12 - Compulsory

**The input will be a .class file, located anywhere in the file system.**

**Load the specified class in memory, identifying dynamically its package.**

**Using reflection, extract as many information about the class (at least its methods).**

**Using reflection, invoke the static methods, with no arguments, annotated with @Test.**

Am creat clasa *Test* cu adnotarea *@interface*.

Am creat clasa *MyProgram* care are câteva metode publice statice, unele fiind adnotate cu *@Test*.

Am creat clasa *MyTestFramework* cu o singură metodă *main* care trece prin toate metodele primei clase din lista de parametri, iar pe cele adnotate cu *@Test* le invocă. Dacă aruncă excepție, se consideră că testul nu a fost trecut iar variabila *failed* este incrementată, altfel se consideră că testul a fost trecut iar variabila *passed* este incrementată. La final sunt afișate valorile celor 2 variabile, și anume mesajul: "Passed: 2, Failed: 2".