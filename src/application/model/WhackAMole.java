package application.model;

import java.util.*;
import application.view.MainView;
import javafx.application.Platform;

public class WhackAMole {
	private MainView mainView;
	private CountDownTimer timer;
	private Mole[] moles;
	private Thread[] moleThreads;
	private boolean[] exposed;
	private Random rand;
	private int totalScore;
	private boolean gameIsOver = true; //there is no game at start, so default to gameOver
	
	/**
	 * Constructor for WhackAMole.java
	 * 
	 * @param mainView
	 * @param moleImage
	 */
	public WhackAMole(MainView mainView) {
		this.mainView = mainView;
		this.moles = new Mole[5];
		this.moleThreads = new Thread[5];
		this.exposed = new boolean[5];
		this.totalScore = 0;
		this.rand = new Random();
	}

	/**
	 * Start game method starts a new game by setting gameIsOver to false and totalScore to 0.
	 * It then creates a new timer, new threads for the timer, fills the array with newly-created moles
	 * (and starts the associated threads) and also defaults the exposed array to false.
	 */
	public void startGame(){
		if(gameIsOver) {
			gameIsOver = false;
			totalScore = 0;
			
			timer = new CountDownTimer(this, mainView); //timer will always be 30 seconds
			Thread timerThread = new Thread(timer);
			timerThread.setDaemon(true);
			timerThread.start();
			
			for(int i = 0; i<5;i++) {
				moles[i] = new Mole(this, mainView, mainView.getMoleImage(), i, rand);
				moleThreads[i] = new Thread(moles[i]);
				moleThreads[i].setDaemon(true);
				moleThreads[i].start();
			}
			Arrays.fill(exposed, false);
		}
	}

	
	/**
	 * this ends the game once the countdown timer reaches 0.
	 * it is called in the CountDownTimer's run() method. 
	 */
	public void endGame(){
		gameIsOver = true;
		for(int i = 0; i < 5; i++) {
			if(moleThreads[i] != null && moleThreads[i].isAlive()) {
				moleThreads[i].interrupt();
			}
		}
	}

	/**
	 * a sort of getter method to see if game is over.
	 * used in mole as a means of checking what caused a run to end.
	 * 
	 * @return
	 */
	public boolean gameOver(){
		return gameIsOver;
	}

	/**
	 * Updates score based on how many milliseconds it took to click on a mole.
	 * <500 adds 100 points.
	 * <1000 adds 50 points.
	 * anything slower only adds 10.
	 * unless the mole disappeared already.
	 * 
	 * @param elap
	 */
	public synchronized void updateScore(int elap){
		if(elap < 500) {
			totalScore += 100;
		}
		else if(elap < 1000) {
			totalScore += 50;
		}
		else {
			totalScore += 10;
		}
		
		Platform.runLater(() -> mainView.displayScoreLabel(String.valueOf(totalScore)));
	} 
	
	/**
	 * sets the status for a mole's associated exposed status
	 * as used in mole.java
	 * 
	 * @param index
	 * @param expsd
	 */
	public void setExposed(int index, boolean expsd) {
		exposed[index] = expsd;
	}
	
	/**
	 * the actual method for when a mole is whacked, 
	 * interrupts the mole thread based on exposure status.
	 * 
	 * @param index
	 */
	public void whackMole(int index) {
		if(exposed[index]) {
			if(moleThreads[index] != null) {
				moleThreads[index].interrupt();
			}
		}
	}
}
