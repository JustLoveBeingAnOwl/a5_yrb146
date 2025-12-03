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
		Pane[] panes = {pane0, pane1, pane2, pane3, pane4};
		for(Pane p : panes) {
			p.setStyle("-fx-border-color: black; -fx-border-width: 2;");
		}
		
		ImageView[] views = {imageView0, imageView1, imageView2, imageView3, imageView4};
		int i = 0;
		for(ImageView v : views) {
			v.setUserData(i);
			i++;
		}
		
		Image moleImage = new Image(getClass().getResourceAsStream("/application/mole-1.png"));
		Image blank = null;
		
		MainView view = new MainView(timeRemainingLabel, scoreLabel, views);
		game = new WhackAMole(view, moleImage, blank);
	}
	public void startButtonAction(){
		game.startGame();
	}

	public void imageViewAction(){
		ImageView image = (ImageView)e.getSource();
		int ind = (int) image.getUserData();
		game.whackMole(ind);
	}
}
