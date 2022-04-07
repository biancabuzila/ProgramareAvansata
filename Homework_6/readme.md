### Homework 6

**Create the object oriented model. Initialize the game by generating random sticks and place them on the board. Implement either direct or retained mode for drawing the game board.**

În clasa *DrawingPanel* am adăugat metodele *paintSticks* care desenează în mod aleatoriu linii pe tabla de joc și *paintStones* care desenează în mod aleatoriu buline albastre și roșii.

Am creat clasa *Game* care are ca proprietăți:
+ *board* - un graf ce are ca noduri perechi de întregi ce reprezintă linia și coloana pe care se află o bulină
+ *coloredStones* - o listă de triplete de întregi (primii 2 reprezintă linia și coloana pe care se află bulina, iar al treilea reprezintă culoarea, 0 pentru albastru și 1 pentru roșu).

În momentul în care sunt desenate aleator liniile și bulinele, ele sunt salvate în clasa *Game*.

Nu am reușit să implementez propriu-zis jocul.