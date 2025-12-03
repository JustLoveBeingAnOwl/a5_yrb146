package application.view;

import javafx.scene.control.*;
import javafx.scene.image.*;

public class MainView {
	private Label timeRemainingLabel;
	private Label scoreLabel;
	private ImageView[] imageViews;
	private Image moleImage;
	
	public void setTimeRemainingLabel(Label timeRemainingLabel) {
		this.timeRemainingLabel = timeRemainingLabel;
	}
	
	public void setScoreLabel(Label scoreLabel) {
		this.scoreLabel = scoreLabel;
	}
	
	public void setImageViews(ImageView... imageViews ) {
		this.imageViews = imageViews;
	}
	
	public void displayTimeRemaining(String time) {
		timeRemainingLabel.setText("Time Remaining:	"+time);
	}
	
	public void displayScoreLabel(String score) {
		scoreLabel.setText("Score:	"+score);
	}
	
	public void displayImage(int index, Image image) {
		imageViews[index].setImage(image);
	}
	
	public ImageView getImageView(int index) {
		return imageViews[index];
	}
	
	public Image getMoleImage() {
		return moleImage;
	}

	public void setMoleImage(Image image) {
		this.moleImage = image;
	}
}
