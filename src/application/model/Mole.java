package application.model;

import java.util.*;
import application.view.MainView;
import javafx.application.Platform;
import javafx.scene.image.*;

/**
 * Mole.java implements runnable in order to have a mole actively detecting if/when it is clicked
 * so it can adjust its display accordingly.
 */
public class Mole implements Runnable {
	private WhackAMole game;
	private MainView mainView;
	private Image moleImage;
	private int index;
	private Random rand;
	private long exposureStart; //variable to determine when exposure begins.

	/**
	 * Constructor for Mole.java
	 * 
	 * @param game
	 * @param mainView
	 * @param moleImage
	 * @param index
	 * @param rand
	 */
	public Mole(WhackAMole game, MainView mainView, Image moleImage, int index, Random rand) {
		this.game = game;
		this.mainView = mainView;
		this.moleImage = moleImage;
		this.index = index;
		this.rand = rand;
	}
	
	//Note, none of the setter/getter methods are used.
	//But they were added just in case they were needed.
	
	/**
	 * setter method for the WhackAMole game variable.
	 * 
	 * @param game
	 */
	public void setGame(WhackAMole game) {
		this.game = game;
	}
	/**
	 * Setter for the associated mainView
	 * @param mainView
	 */
	public void setMainView(MainView mainView) {
		this.mainView = mainView;
	}
	/**
	 * setter for the associated moleImage
	 * @param moleImage
	 */
	public void setMoleImage(Image moleImage) {
		this.moleImage = moleImage;
	}
	/**
	 * setter for the mole's index
	 * 
	 * @param index
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	
	/**
	 * getter for the mole's index
	 * @return
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * Run() method that's synchronized. It uses the sleep method
	 * in terms of milliseconds to see how long a mole will be present
	 * and also tracks how long a mole is exposed for the sake of determining point allocation.
	 */
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
