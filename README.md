# Random Fight Game Tile-based Step by step

This is Tile-based fight game, I developed this game with using javaFx

---

### Configuration

#### 1- Create a library
* Go to File -> Project Structure -> Libraries 
<br>and add the JavaFX 15 SDK as a library to the project. Point to the lib folder of the JavaFX SDK.
#### 2- Add VM options
To solve the issue, <br> 
* click on Run -> Edit Configurations... and add these VM options:
* windows 
<br>```--module-path "\path\to\javafx-sdk-15.0.1\lib" --add-modules javafx.controls,javafx.fxml```
* linux/mac
<br>```--module-path /path/to/javafx-sdk-15.0.1/lib --add-modules javafx.controls,javafx.fxml```
#### 3- var.cfg
* This is config file of game. You can change number of  tile, player and obstacle.
---

### Executing program
run from idea after configuring. 
```
> RUN
```
### License

This project is licensed under the MIT License - see the LICENSE.md file for details
