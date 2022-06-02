### Laborator 13 - Compulsory

**Create the files: Messages.properties, Messages_ro.properties.**

Le-am creat în folderul src/main/resources.

**Create the package *com* and implement the following classes describing commands:**
**+ *DisplayLocales*: to display all available locales**
**+ *SetLocale*: to set the application current locale.**
**+ *Info*: to display informations about the current or a specific locale.**

**When the user sets a specific language tag, various information obtained using standard Java classes such as Currency or DateFormatSymbols should be displayed in a text area.**

Clasa *DisplayLocales* are doar constructorul care are un argument de tip *ResourceBundle* și afișează mesajul reținut de cheia *locales* și toate localizările disponibile.

Clasa *SetLocale* are 2 proprietăți: *locale* de tip *Locale* și *messages* de tip *ResourceBundle*. Constructorul setează aceste 2 proprietăți. Metoda *setLocale* primește ca argumente limba și țara, afișează mesajul reținut de cheia *locale.set* și setează localizarea.

Clasa *Info* are un constructor care are ca argumente localizarea curentă, localizarea despre care se doresc informații și *messages* de tip *ResourceBundle*. Sunt afișate mesajul reținut de cheia *info*, infomațiile cerute mai întâi în limba corespunzătoare localizării curente, iar în paranteză în limba despre care s-au cerut informațiile.

**Create the package app and the main class LocaleExplore. Inside this class, read commands from the keyboard and execute them.**

În clasa *LocaleExplore*, într-o buclă infinită, este afișat mesajul reținut de cheia *prompt*, sunt citite comenzile *DisplayLocales*, *SetLocale -limbă- -țară-*, *Info -limbă- -țară-* și afișate informațiile corespunzătoare lor. Pentru alte comenzi decât cele 3 precizate este afișat mesajul reținut de cheia *invalid*.