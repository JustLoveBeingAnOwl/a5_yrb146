package application.view;

import javafx.scene.control.*;
import javafx.scene.image.*;

/**
 * MainView manages the view and labels of the program.
 * Did not find a need to have a constructor, insead solely using setter methods.
 * though a constructor could've been nice to only use one method, and setters could've been a backup. Oh well.
 */
public class MainView {
	private Label timeRemainingLabel;
	private Label scoreLabel;
	private ImageView[] imageViews;
	private Image moleImage;
	
	/**
	 * Setter method for the timeRemaining label.
	 * @param timeRemainingLabel
	 */
	public void setTimeRemainingLabel(Label timeRemainingLabel) {
		this.timeRemainingLabel = timeRemainingLabel;
	}
	
	/**
	 * setter method for the score label
	 * 
	 * @param scoreLabel
	 */
	public void setScoreLabel(Label scoreLabel) {
		this.scoreLabel = scoreLabel;
	}
	
	/**
	 * Setter method for the imageViews array.
	 * 
	 * @param imageViews
	 */
	public void setImageViews(ImageView... imageViews ) {
		this.imageViews = imageViews;
	}
	
	/**
	 * Changes the display text for the time remaining label.
	 * @param time
	 */
	public void displayTimeRemaining(String time) {
		timeRemainingLabel.setText(time);
	}
	
	/**
	 * changes the display text for the score label.
	 * @param score
	 */
	public void displayScoreLabel(String score) {
		scoreLabel.setText(score);
	}
	
	/**
	 * Changes the image display at a particular label.
	 * 
	 * @param index
	 * @param image
	 */
	public void displayImage(int index, Image image) {
		imageViews[index].setImage(image);
	}
	
	/**
	 * getter method for an imageView.
	 * unused.
	 * @param index
	 * @return
	 */
	public ImageView getImageView(int index) {
		return imageViews[index];
	}
	
	/**
	 * Setter method for the moleImage.
	 * @param image
	 */
	public void setMoleImage(Image image) {
		this.moleImage = image;
	}
	
	/**
	 * Getter method for a mole's image.
	 * used in WhackAMole.java for the creation of moles.
	 * @return
	 */
	public Image getMoleImage() {
		return moleImage;
	}
}
