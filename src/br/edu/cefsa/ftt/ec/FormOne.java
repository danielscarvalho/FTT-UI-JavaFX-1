package br.edu.cefsa.ftt.ec;

import java.awt.TextArea;
import java.util.Date;

import javafx.application.*;
import javafx.*;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//Fonte: https://docs.oracle.com/javase/8/javafx/get-started-tutorial/form.htm#BABDDGEE

public class FormOne extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Login form - JavaFX");
        
		GridPane grid = new GridPane();
		
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25)); //top, right, bottom, left

		Scene scene = new Scene(grid, 300, 275);
		primaryStage.setScene(scene);
		
		
		Text scenetitle = new Text("Welcome");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1); //row col indexes (start at ZERO)

		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);

		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);

		PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 1, 2);
		
		final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
		
		Button btn = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {
		    	actiontarget.setFill(Color.FIREBRICK);
		    	actiontarget.setText("Sign in button pressed");
		    	System.out.println("Button pressed " + new Date());
		    }
		});
		
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	} //main

}
