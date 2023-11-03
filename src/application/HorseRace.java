package application;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.util.Duration;
import javafx.scene.ParallelCamera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class HorseRace extends Application {
	private int racers;
	
	@Override
	public void start(Stage primaryStage) {
		StackPane stackPane = new StackPane();
		
		Button button = new Button("Start");
		Image image = new Image(HorseRace.class.getResourceAsStream("horseRacing.png"));
		
		ImageView[] horse = new ImageView[10];
		for (int x = 0; x < horse.length; x++) {
			ImageView racerView = new ImageView(image);
	        horse[x] = racerView;
			horse[x].setFitHeight(55);
			horse[x].setFitWidth(55);
		}
		
		Image image4 = new Image(HorseRace.class.getResourceAsStream("sky2.jpg"));
		ImageView imageView4 = new ImageView(image4);
		imageView4.setFitHeight(450);
		stackPane.getChildren().add(imageView4);
		stackPane.setAlignment(imageView4, Pos.TOP_CENTER);
		
		Label label = new Label("Horse Race");
		label.setPadding(new Insets(50));
		label.getStyleClass().add("label-title");
		
		Label label2 = new Label("How many racers?");
		label2.getStyleClass().add("label-2");
		
		Image image2 = new Image(HorseRace.class.getResourceAsStream("crowd.jpeg"));
		ImageView imageView2 = new ImageView(image2);
		imageView2.setFitHeight(550);
		imageView2.setFitWidth(150);
		stackPane.getChildren().add(imageView2);
		stackPane.setAlignment(imageView2, Pos.BOTTOM_LEFT);
		
		Image image3 = new Image(HorseRace.class.getResourceAsStream("crowd2.jpeg"));
		ImageView imageView3 = new ImageView(image3);
		imageView3.setFitHeight(550);
		imageView3.setFitWidth(150);
		
		DropShadow borderGlow = new DropShadow();
		borderGlow.setColor(Color.BLACK);
		borderGlow.setWidth(50);
		borderGlow.setHeight(50);
		imageView2.setEffect(borderGlow);
		imageView3.setEffect(borderGlow);
		
		Image image5 = new Image(HorseRace.class.getResourceAsStream("finishLine.jpeg"));
		ImageView imageView5 = new ImageView(image5);
		imageView5.setFitHeight(550);
		imageView5.setFitWidth(100);
		
		HBox hbox = new HBox(100, imageView5, imageView3);
		stackPane.getChildren().add(hbox);
		hbox.setAlignment(Pos.BOTTOM_RIGHT);
		
		
		ChoiceBox<Integer> choiceBox = new ChoiceBox<>(); 
		choiceBox.getItems().addAll(2, 3, 4, 5, 6, 7, 8, 9, 10);
		choiceBox.getStyleClass().add("label-choice");
		
		HBox hbox2 = new HBox(30, choiceBox, button);
		hbox2.setAlignment(Pos.TOP_CENTER);
		
		StackPane[] stack = new StackPane[10];
		Line[] line = new Line[10];
		for (int y = 0; y < stack.length; y++) {
			stack[y] = new StackPane();
			line[y] = new Line(-400, 0, 400, 0);
			stack[y].getChildren().add(line[y]);
			stack[y].getChildren().add(horse[y]);
		}
		
		line[0].setStroke(Color.RED);
		line[1].setStroke(Color.ORANGE);
		line[2].setStroke(Color.YELLOW);
		line[3].setStroke(Color.GREEN);
		line[4].setStroke(Color.BLUE);
		line[5].setStroke(Color.INDIGO);
		line[6].setStroke(Color.VIOLET);
		line[7].setStroke(Color.WHITE);
		line[8].setStroke(Color.BLACK);
		line[9].setStroke(Color.BROWN);
		
		TranslateTransition tTransition = new TranslateTransition(new Duration(10000));
		tTransition.setNode(horse[0]);
		//tTransition.setNode(horse2);
		//tTransition.setNode(horse3);
		//tTransition.setNode(horse4);
		//tTransition.setNode(horse5);
		//tTransition.setNode(horse6);
		//tTransition.setNode(horse7);
		//tTransition.setNode(horse8);
		//tTransition.setNode(horse9);
		//tTransition.setNode(horse10);
		tTransition.setFromX(-400.0);
		tTransition.setToX(400.0);
		TranslateTransition tTransition2 = new TranslateTransition(new Duration(500));
		tTransition2.setNode(horse[0]);
		//tTransition2.setNode(horse2);
		//tTransition2.setNode(horse3);
		//tTransition2.setNode(horse4);
		//tTransition2.setNode(horse5);
		//tTransition2.setNode(horse6);
		//tTransition2.setNode(horse7);
		//tTransition2.setNode(horse8);
		//tTransition2.setNode(horse9);
		//tTransition2.setNode(horse10);
		tTransition2.setFromY(-10.0); 
		tTransition2.setToY(10.0);
		tTransition2.setAutoReverse(true);
		tTransition2.setCycleCount(20);
		ParallelTransition pTransition = new ParallelTransition(button);
		pTransition.getChildren().addAll(tTransition, tTransition2);
		button.setOnAction(event -> {
			pTransition.play();
		});
		
		BorderPane borderPane = new BorderPane();
		stackPane.getChildren().add(borderPane);
		stackPane.setAlignment(borderPane, Pos.CENTER);
		choiceBox.setOnAction(event -> {
			racers = choiceBox.getValue();
			
			VBox vbox2 = new VBox();
			
			switch (racers) {
			case 10:
				vbox2.getChildren().add(stack[0]);
			case 9:
				vbox2.getChildren().add(stack[1]);
			case 8:
				vbox2.getChildren().add(stack[2]);
			case 7:
				vbox2.getChildren().add(stack[3]);
			case 6:
				vbox2.getChildren().add(stack[4]);
			case 5:
				vbox2.getChildren().add(stack[5]);
			case 4:
				vbox2.getChildren().add(stack[6]);
			case 3:
				vbox2.getChildren().add(stack[7]);
			case 2:
				vbox2.getChildren().add(stack[8]);
				vbox2.getChildren().add(stack[9]);
				break;
			}
			vbox2.setAlignment(Pos.BOTTOM_CENTER);
			borderPane.setCenter(vbox2);
		});
		
		VBox titleVBox = new VBox(20, label, label2, hbox2);
		stackPane.getChildren().add(titleVBox);
		titleVBox.setAlignment(Pos.TOP_CENTER);
		
		Scene scene = new Scene(stackPane);
		scene.getStylesheets().add("HorseRace.css");
		primaryStage.setTitle("Horse Race");
		primaryStage.setScene(scene);
		primaryStage.setFullScreen(true);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

