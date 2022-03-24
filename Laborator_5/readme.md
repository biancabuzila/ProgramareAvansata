### Laborator 5 - Compulsory

**Create an object-oriented model of the problem. You should have at least the following classes: *Catalog* and *Item*. The items should have at least a unique identifier, a title and its location. Consider using an interface or an abstract class in order to describe the items in a catalog.**

**Implement the following methods representing commands that will manage the content of the catalog:**
+ ***add*: adds a new entry into the catalog;**
+ ***toString*: a textual representation of the catalog;**
+ ***save*: saves the catalog to an external file using JSON format; you may use Jackson or other library;**
+ ***load*: loads the catalog from an external file.**

Clasa *Item* este abstractă. Are ca proprietăți *id*, *title*, *location*, *author* de tip *String* și *year* de tip *int*. Metodele sunt constructor pentru toate proprietățile (aruncă excepția *FileNotFoundException* dacă fișierul din locația dată ca parametru nu există, și excepția *InvalidYearException* dacă anul dat e mai mare decât anul curent în care suntem), gettere și settere, *toString* suprascrisă.

Clasele *Article* și *Book* extind clasa *Item* și au un constructor pentru toate proprietățile care apelează constructorul clasei moștenite.

Clasa *Catalog* are ca proprietăți *name* de tip *String* și *items* de tip *List< Item >*. Metodele sunt constructor pentru *name*, gettere și settere pentru proprietăți, *add* care adaugă un item și *toString* suprascrisă.

Clasa *CatalogUtil* are metodele *save* (salvează catalogul dat ca parametru în locația dată ca parametru) și *load* (încarcă catalogul din locația dată ca parametru), ambele aruncă excepția *IOException*.