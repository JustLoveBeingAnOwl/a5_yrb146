package application.model;

import java.util.*;
import application.view.MainView;

public class WhackAMole {
	private MainView mainView;
	private CountDownTimer timer;
	private Mole[] moles;
	private Thread[] moleThreads;
	private boolean[] exposed;
	private Random rand;
	private int totalScore;
	private boolean gameIsOver = true; //there is no game at start, so default to gameOver
	
	public WhackAMole(MainView mainView) {
		this.mainView = mainView;
		this.moles = new Mole[5];
		this.moleThreads = new Thread[5];
		this.exposed = new boolean[5];
		this.totalScore = 0;
		this.rand = new Random();
	}

	public void startGame(){
		if(gameIsOver) {
			gameIsOver = true;
			totalScore = 0;
			
			timer = new CountDownTimer(this, mainView); //timer will always be 30 seconds
			Thread timerThread = new Thread(timer);
			timerThread.setDaemon(true);
			timerThread.start();
			
			for(int i = 0; i<5;i++) {
				moles[i] = new Mole(this, mainView, mainView.getMoleImage(), i);
			}
		}
	}

	
	/**
	 * this ends the game once the countdown timer reaches 0.
	 * it is called in the CountDownTimer's run() method. 
	 */
	public void endGame(){
		gameIsOver = true;
		for(int i = 0; i < 5; i++) {
			
		}
	}

	public void gameOver(){
		
	}

	public void updateScore(){
		
	}
	
	public void setExposed(int index, boolean expsd) {
		
	}
	
	public synchronized void updateScore(int responseTimeMillis) {
		
	}
	
	public void whackMole(int index) {
		
	}
}
