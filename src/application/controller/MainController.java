package application.controller;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import application.model.*;
import application.view.*;

/**
 * MainController class for the program.
 */
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
	
	/**
	 * Initialization method sets up borders for the panes, sets and passes an array of the imageViews,
	 * and creates and sets up mainView and WhackAMole instances 
	 */
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
		
		mainView = new MainView();
		mainView.setImageViews(views);
		mainView.setMoleImage(moleImage);
		mainView.setScoreLabel(scoreLabel);
		mainView.setTimeRemainingLabel(timeRemainingLabel);
		game = new WhackAMole(mainView);
	}
	
	/**
	 * FXML action method for the start button.
	 * Simply calls startGame() to start the game.
	 * 
	 * @param event
	 */
	@FXML
	public void startButtonAction(ActionEvent event ){
		game.startGame();
	}

	/**
	 * FXML event button for when someone clicks on a mole's space.
	 * gets the source, gets the user data, and then passes it to a call of the whackMole() method.
	 * 
	 * @param event
	 */
	@FXML
	public void imageViewAction(Event event){
		ImageView image = (ImageView) event.getSource();
		int index = (int) image.getUserData();
		game.whackMole(index);
	}
}
