# Quizder Android Quiz Game App

## App Description

It is a simple quiz game app with some extra features like Undo , Skip and Reset.
This Quiz app has multiple True False based Questions to be answered by User.

## App Interface 

This app has One *Main Activity*. There is also a landscape variant of the Main Activity layout.

The layout contains a *TextView* Component containing the Questions.
To answer the questions there is two Clickable *Buttons* ,one is "True" and another one is "False" .
At the bottom of the layout there is a *Progress Bar* to show the progress of the answered Questions.
On the *Progress Bar* there is also a *TextView* to Score of the user which shows that how many number of questions did the user get right among the total number of Questions.

There is also three Extra Buttons between the Question *TextView* and the Answer Buttons to *Undo* , *Skip*  & *Reset* the Questions respectively.

## How to Use

User will have to answer the questions by just clicking the "True" or "False" button.

##### Initial Screen : 								<img src=".\Screenshots\Initial.png" alt="Initial" style="zoom: 15%;" />

> If the answer is correct user will get one point added to their score and a short pop-up message will be shown containing the message "You got it"

<img src=".\Screenshots\Right.png" alt="Right" style="zoom: 15%;" />



> if the answer is wrong then no points will be given and a  short pop-up message will be shown containing the message "Wrong" and the next question will be shown.

<img src=".\Screenshots\Wrong.png" alt="Wrong" style="zoom: 15%;" />

> **Undo** : If the user want to undo the previous question and want reattempt it then he/she can press the "Undo" Button. After pressing the button a  short pop-up message will be shown containing the message "Undo"  and the previous question will be shown to user to reattempt.

<img src=".\Screenshots\Undo.png" alt="Undo" style="zoom: 15%;" />

> **Skip** : If the user want to skip the current question then he/she can press the "Skip" Button. After pressing the button the next question will be shown and a short pop-up message will appear containing the message "Skipped".

<img src=".\Screenshots\Skip.png" alt="Skip" style="zoom: 15%;" />

> **Reset** : If the user want reset the game then he/she can press the "Reset" Button.  After pressing the button all the progress of the components will return to their initial position and a short pop-up message will appear containing the message "Reset".

<img src=".\Screenshots\Reset.png" alt="Reset" style="zoom: 15%;" />

> **Game Over** : After attempting all the questions the game will eventually come to an end and an Alert Dialog Box will appear containing the Score of the user with two options to Reset the game or to close app. 

<img src=".\Screenshots\Game Over.png" alt="Game Over" style="zoom: 15%;" />

## Emulator Configuration

### Hardware :  

- Name :  Pixel 2 XL
- Screen Size : 6.0"
- Resolution :  1440 x 2880
- Density : 560 dpi

### System Image :

- API Level : 28
- ABI : x86
- Target : Android 8.0

For further details mail at officialdroyder@gmail.com