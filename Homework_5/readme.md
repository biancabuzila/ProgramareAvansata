### Homework 5

**Represent the commands using classes instead of methods. Use an interface or an abstract class in order to desribe a generic command. Implement the commands *load*, *list*, *view*, *report* (create the classes *AddCommand*, *ListCommand*, etc.).**
+ ***list*: prints the list of items on the screen;**
+ ***view*: opens an item using the native operating system application (see the Desktop class);**
+ ***report*: creates (and opens) an HTML report representing the content of the catalog. Use a template engine such as FreeMarker or Velocity, in order to create the HTML report.**

Interfața *Command* are metoda *implementCommand*.

Clasele *AddCommand* (adăugarea unui item în catalog), *SaveCommand* (salvarea catalogului într-o locație dată), *LoadCommand* (încărcarea unui catalog dintr-o locație dată), *ViewCommand* (deschiderea tuturor obiectelor din catalog cu o aplicație specifică dispozitivului), *ListCommand* (afișarea informațiilor obiectelor din catalog), *ReportCommand* implementează interfața *Command* și suprascriu metoda acesteia.

Am folosit FreeMarker pentru a crea raportul HTML.