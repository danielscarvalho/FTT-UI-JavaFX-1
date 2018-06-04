package br.edu.cefsa.ftt.ec;

import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
Fonte:

http://www.java2s.com/Tutorials/Java/JavaFX/0560__JavaFX_Menu.htm
http://code.makery.ch/blog/javafx-dialogs-official/

*/

public class FormMenuDialog extends Application {

  @Override
  public void start(Stage primaryStage) {
    BorderPane root = new BorderPane();
    Scene scene = new Scene(root, 300, 250, Color.WHITE);

    MenuBar menuBar = new MenuBar();
    menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
    root.setTop(menuBar);

    Menu fileMenu = new Menu("File");
    
    MenuItem exitMenuItem = new MenuItem("Exit");
    MenuItem infoMenuItem = new MenuItem("Info");
    MenuItem optionsMenuItem = new MenuItem("Options");

    fileMenu.getItems().add(infoMenuItem);
    fileMenu.getItems().add(optionsMenuItem);
    fileMenu.getItems().add(exitMenuItem);

    infoMenuItem.setOnAction(actionEvent -> showInfo());  
    optionsMenuItem.setOnAction(actionEvent -> showOptions());  
    exitMenuItem.setOnAction(actionEvent -> Platform.exit());

    menuBar.getMenus().addAll(fileMenu);

    primaryStage.setTitle("Menu & Dialog Test!! - JavaFX");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  private void showInfo() {
	  System.out.println("Info...");
	  
	  Alert alert = new Alert(AlertType.INFORMATION);
	  alert.setTitle("Information Dialog");
	  alert.setHeaderText("Look, an Information Dialog");
	  alert.setContentText("I have a great message for you!");

	  alert.showAndWait();
  }
  
  private void showOptions() {
	  System.out.println("Options...");
	  
	  Alert alert = new Alert(AlertType.CONFIRMATION);
	  alert.setTitle("Confirmation Dialog with Custom Actions");
	  alert.setHeaderText("Look, a Confirmation Dialog with Custom Actions");
	  alert.setContentText("Choose your option.");

	  ButtonType buttonTypeOne = new ButtonType("One");
	  ButtonType buttonTypeTwo = new ButtonType("Two");
	  ButtonType buttonTypeThree = new ButtonType("Three");
	  ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

	  alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);

	  Optional<ButtonType> result = alert.showAndWait();
	  
	  if (result.get() == buttonTypeOne){
	      System.out.println("user chose \"One\"");
	  } else if (result.get() == buttonTypeTwo) {
		  System.out.println("user chose \"Two\"");
	  } else if (result.get() == buttonTypeThree) {
		  System.out.println("user chose \"Three\"");
	  } else {
		  System.out.println("user chose CANCEL or closed the dialog");
	  }
  }
  
  
  
  public static void main(String[] args) {
    launch(args);
  }
}