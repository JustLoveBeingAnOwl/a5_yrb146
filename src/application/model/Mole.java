package application.model;

import java.util.*;
import application.view.MainView;
import javafx.application.Platform;
import javafx.scene.image.*;

public class Mole implements Runnable {
	private WhackAMole game;
	private MainView mainView;
	private Image moleImage;
	private int index;
	private Random rand;
	private long exposureStart; //variable to determine when exposure begins.

	public Mole(WhackAMole game, MainView mainView, Image moleImage, int index, Random rand) {
		this.game = game;
		this.mainView = mainView;
		this.moleImage = moleImage;
		this.index = index;
		this.rand = rand;
	}
	
	public void setGame(WhackAMole game) {
		this.game = game;
	}
	public void setMainView(MainView mainView) {
		this.mainView = mainView;
	}
	public void setMoleImage(Image moleImage) {
		this.moleImage = moleImage;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
	
	@Override
	public synchronized void run() {
		while (!game.gameOver()) {
		    try {
		        // hide mole
		        game.setExposed(index, false);
		        Platform.runLater(() -> mainView.displayImage(index, null));
		        Thread.sleep(2000 + rand.nextInt(3001));

		        // show mole
		        exposureStart = System.currentTimeMillis();
		        game.setExposed(index, true);
		        Platform.runLater(() -> mainView.displayImage(index, moleImage));
		        Thread.sleep(1000 + rand.nextInt(1001));

		        // if not interrupted, hide again.
		        game.setExposed(index, false);

		    } catch (InterruptedException e) {
		        if (game.gameOver()) return; // game ended

		        long elapsed = System.currentTimeMillis() - exposureStart;
		        game.updateScore((int) elapsed);

		        game.setExposed(index, false);
		    }
		}
	}
}
