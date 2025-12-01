package application.view;

import javafx.scene.control.*;
import javafx.scene.image.*;

public class MainView {
	private Label timeRemainingLabel;
	private Label scoreLabel;
	private ImageView[] imageViews;
	
	public void displayTimeRemaining(String time) {
		timeRemainingLabel.setText(time);
	}
	
	public void displayLabel(String score) {
		scoreLabel.setText(score);
	}
	
	public void displayImage(int index, Image image) {
		imageViews[index].setImage(image);
	}
}
