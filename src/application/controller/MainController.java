package application.controller;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;

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

    @FXML
    public void initialize() {

        mainView = new MainView();

        mainView.setScoreLabel(scoreLabel);
        mainView.setTimeRemainingLabel(timeRemainingLabel);

        mainView.setImageViews(imageView0, imageView1, imageView2, imageView3, imageView4);

        mainView.setMoleImage(new Image("/application/mole-1.png"));

        imageView0.setUserData(0);
        imageView1.setUserData(1);
        imageView2.setUserData(2);
        imageView3.setUserData(3);
        imageView4.setUserData(4);

        Border border = new Border(new BorderStroke(
            Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2)
        ));

        pane0.setBorder(border);
        pane1.setBorder(border);
        pane2.setBorder(border);
        pane3.setBorder(border);
        pane4.setBorder(border);

        game = new WhackAMole(mainView);
    }

    @FXML
    public void startButtonAction(ActionEvent event){
        game.startGame();
    }

    @FXML
    public void imageViewAction(Event event){
        ImageView iv = (ImageView) event.getSource();
        int index = (int) iv.getUserData();
        game.whackMole(index);
    }
}
