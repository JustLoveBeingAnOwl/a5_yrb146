package application.view;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainView {

    private Label timeRemainingLabel;
    private Label scoreLabel;
    private ImageView[] imageViews;
    private Image moleImage;

    public void setTimeRemainingLabel(Label label) {
        this.timeRemainingLabel = label;
    }

    public void setScoreLabel(Label label) {
        this.scoreLabel = label;
    }

    public void setImageViews(ImageView... views) {
        this.imageViews = views;
    }

    public void setMoleImage(Image img) {
        this.moleImage = img;
    }

    public Image getMoleImage() {
        return moleImage;
    }

    public void displayTimeRemaining(String time) {
        Platform.runLater(() -> {
            if (timeRemainingLabel != null) {
                timeRemainingLabel.setText(time);
            }
        });
    }

    public void displayScore(String score) {
        Platform.runLater(() -> {
            if (scoreLabel != null) {
                scoreLabel.setText(score);
            }
        });
    }

    public void displayImage(int index, Image img) {
        Platform.runLater(() -> {
            if (imageViews != null && index >= 0 && index < imageViews.length) {
                imageViews[index].setImage(img);
            }
        });
    }

    public ImageView getImageView(int index) {
        if (imageViews != null && index >= 0 && index < imageViews.length) {
            return imageViews[index];
        }
        return null;
    }

    public void hideAllMoles() {
        Platform.runLater(() -> {
            if (imageViews != null) {
                for (ImageView iv : imageViews) {
                    if (iv != null) iv.setImage(null);
                }
            }
        });
    }
}
