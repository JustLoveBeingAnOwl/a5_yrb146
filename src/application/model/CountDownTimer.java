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
		
	}

}
