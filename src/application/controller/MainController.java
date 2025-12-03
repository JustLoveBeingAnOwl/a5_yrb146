package application.controller;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import application.model.*;
import application.view.*;

public class MainController {
	private WhackAMole game;
	private MainView mainView;
	@FXML private Label timeRemainingLabel;
	@FXML private Label scoreLabel;
	@FXML private ImageView imageView0;
	@FXML private ImageView imageView1;
	@FXML private ImageView imageView2;
	@FXML private ImageView imageView3;
	@FXML private ImageView imageView4;
	
	@FXML private Pane pane0;
	@FXML private Pane pane1;
	@FXML private Pane pane2;
	@FXML private Pane pane3;
	@FXML private Pane pane4;
	
	public void initialize() {
		mainView = new MainView();
		mainView.setScoreLabel(scoreLabel);
		mainView.setTimeRemainingLabel(timeRemainingLabel);
		mainView.setImageViews(imageView0, imageView1, imageView2, imageView3, imageView4);
		mainView.setMoleImage(new Image("/mole-1.png"));
		game = new WhackAMole(mainView);
	}
	
	@FXML
	public void startButtonAction(ActionEvent event){
		game.startGame();
	}
	
	@FXML
	public void imageViewAction(Event event){
		ImageView obj = (ImageView) event.getSource();
		int index = (int) obj.getUserData();
		game.whackMole(index);
	}
}
