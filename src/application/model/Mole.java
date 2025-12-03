package application.model;

import java.util.Random;

import application.view.MainView;
import javafx.scene.image.Image;


public class Mole implements Runnable {
    private WhackAMole game;
    private MainView mainView;
    private Image moleImage;
    private int index;
    private Random rand = new Random();

    public Mole(WhackAMole game, MainView mainView, Image moleImage, int index) {
        this.game = game;
        this.mainView = mainView;
        this.moleImage = moleImage;
        this.index = index;
    }

    @Override
    public void run() {
        while (!game.gameOver()) {
            try {
                game.setExposed(index, false);
                mainView.displayImage(index, null);

                Thread.sleep(2000 + rand.nextInt(3001));

                game.exposureStart[index] = System.currentTimeMillis();
                game.setExposed(index, true);
                mainView.displayImage(index, moleImage);

                Thread.sleep(1000 + rand.nextInt(1001));

                game.setExposed(index, false);
                mainView.displayImage(index, null);
            } catch (InterruptedException e) {
                if (game.gameOver()) {
                    return;
                }

                long elapsed = System.currentTimeMillis() - game.exposureStart[index];
                if (elapsed < 0) elapsed = 0;
                game.updateScore((int) elapsed);

                game.setExposed(index, false);
                mainView.displayImage(index, null);

            }
        }
    }
}
