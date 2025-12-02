package application.model;

import application.view.MainView;

/**
 * The CountDownTimer class stores a timer that counts down from 30 seconds,
 * using its own thread to run().
 */
public class CountDownTimer implements Runnable {
	WhackAMole game;
	MainView mainView;
	int durationsSeconds;
	
	/**
	 * Constructor
	 * Takes game and mainView
	 * 
	 * @param game
	 * @param mainView
	 */
	public CountDownTimer(WhackAMole game, MainView mainView) {
		this.game = game;
		this.mainView = mainView;
	}
	
	/**
	 * Setter method for the local game instance
	 * 
	 * @param game
	 */
	public void setGame(WhackAMole game) {
		this.game = game;
	}
	
	/**
	 * Setter method for the local MainView
	 * 
	 * @param mainView
	 */
	public void setMainView(MainView mainView) {
		this.mainView = mainView;
	}

	/**
	 * The run method for the CountDownTimer.
	 * Operates in its own thread, and once 30 seconds are up calls the endGame() method in the WhackAMole class.
	 */
	@Override
	public synchronized void run() {
		durationsSeconds = 30;
		while(durationsSeconds > 0 && !Thread.currentThread().isInterrupted()) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
			
			durationsSeconds--;
			mainView.displayTimeRemaining(String.valueOf(durationsSeconds));
		}
		
		game.endGame();
	}

}
