package application.model;

import application.view.MainView;

public class CountDownTimer implements Runnable {
	WhackAMole game;
	MainView mainView;
	int DurationsSeconds;
	
	public CountDownTimer(WhackAMole game, MainView mainView) {
		this.game = game;
		this.mainView = mainView;
	}

	@Override
	public synchronized void run() {
		DurationsSeconds = 30;
		while(DurationsSeconds > 0 && !Thread.currentThread().isInterrupted()) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
			
			DurationsSeconds--;
			mainView.displayTimeRemaining(String.valueOf(DurationsSeconds));
		}
		
		game.endGame();
	}

}
