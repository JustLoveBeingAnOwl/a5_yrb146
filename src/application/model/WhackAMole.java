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
		moles = new Mole[5];
		moleThreads = new Thread[5];
		totalScore = 0;
	}

	public void startGame(){
		
	}

	public void endGame(){
		
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
