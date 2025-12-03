package application.view;

import javafx.scene.control.*;
import javafx.scene.image.*;

public class MainView {
	private Label timeRemainingLabel;
	private Label scoreLabel;
	private ImageView[] imageViews;
	
	public void setTimeRemainingLabel(Label timeRemainingLabel) {
		this.timeRemainingLabel = timeRemainingLabel;
	}
	
	public void setScoreLabel(Label scoreLabel) {
		this.scoreLabel = scoreLabel;
	}
	
	public void displayTimeRemaining(String time) {
		timeRemainingLabel.setText("Time Remaining:	"+time);
	}
	
	public void displayLabel(String score) {
		scoreLabel.setText("Score:	"+score);
	}
	
	public void displayImage(int index, Image image) {
		imageViews[index].setImage(image);
	}
}
