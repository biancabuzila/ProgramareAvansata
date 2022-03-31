### Laborator 6 - Compulsory

**The *main frame* of the application.**

Clasa *MainFrame* extinde *JFrame* și are ca proprietăți *configPanel* de tip *ConfigPanel*, *controlPanel* de tip *ControlPanel* și *canvas* de tip *DrawingPanel*. Metodele sunt:
+ constructor - apelează metoda superclasei și *init*
+ *init* - creează și adaugă componentele în frame
+ getter pentru *configPanel*

**A *configuration panel* for introducing parameters regarding the grid size and a button for creating a new game. The panel must be placed at the top part of the frame. The panel must contain at least one label and one input component.**

Clasa *ConfigPanel* extinde *JPanel* și are ca proprietăți *frame* de tip *MainFrame*, *label* de tip *JLabel*, *spinnerRows* și *spinnerCols* de tip *JSpinner*, *rows* și *cols* de tip int. Metodele sunt:
+ constructor pentru *frame*
+ *init* - creează și adaugă label-ul, spinnerele și butonul *Create*
+ *createGame* - redesenează componenta *canvas* după noile valori pentru linii și coloane
+ gettere și settere pentru *rows* și *cols*

**A *canvas* (*drawing panel*) for drawing the board. Draw the grid lines according to the values specified in the config panel. This panel must be placed in the center part of the frame.**

Clasa *DrawingPanel* extinde *JPanel* și are ca proprietăți *frame* de tip *MainFrame*, *canvasWidth*, *canvasHeight*, *rows*, *cols*, *boardWidth*, *boardHeight*, *cellWidth*, *cellHeight*, *padX*, *padY* și *stoneSize* de tip int. Metodele sunt:
+ constructor pentru *frame*
+ *paintComponent* - desenează componenta
+ *init* - calculează valorile pentru proprietăți
+ *paintGrid* - desenează grid-ul jocului

**A *control panel* for managing the game. This panel will contain the buttons: Load, Save, Exit ,etc. and it will be placed at the bottom part of the frame.**

Clasa *ControlPanel* extinde *JFrame* și are ca proprietăți *frame* de tip *MainFrame*, *loadBtn*, *saveBtn* și *exitBtn* de tip *JButton*. Metodele sunt:
+ constructor pentru *frame* ce apelează *init*
+ *init* - creează și adaugă butoanele
+ *exitGame* - se iese din joc dacă este apăsat butonul *Exit*