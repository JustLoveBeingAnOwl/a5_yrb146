package application.model;

import java.util.Random;
import application.view.MainView;

public class WhackAMole {

    private MainView mainView;
    private CountDownTimer timer;
    private Mole[] moles;
    private Thread[] moleThreads;
    private boolean[] exposed;
    private Random rand;
    private int totalScore;
    private boolean gameIsOver = true;

    public long[] exposureStart;

    public WhackAMole(MainView mainView) {
        this.mainView = mainView;
        this.moles = new Mole[5];
        this.moleThreads = new Thread[5];
        this.exposed = new boolean[5];
        this.exposureStart = new long[5];
        this.totalScore = 0;
        this.rand = new Random();
    }

    public void startGame() {

        if (!gameIsOver) return;   

        gameIsOver = false;
        totalScore = 0;
        mainView.displayScore("0");
    mainView.displayTimeRemaining("30");

        timer = new CountDownTimer(this, mainView);
        Thread timerThread = new Thread(timer);
        timerThread.setDaemon(true);
        timerThread.start();

        for (int i = 0; i < 5; i++) {
            exposed[i] = false;
            exposureStart[i] = 0;

            moles[i] = new Mole(this, mainView, mainView.getMoleImage(), i);
            moleThreads[i] = new Thread(moles[i]);
            moleThreads[i].setDaemon(true);
            moleThreads[i].start();
        }
    }


    public void endGame() {
        gameIsOver = true;

        for (int i = 0; i < 5; i++) {
            if (moleThreads[i] != null && moleThreads[i].isAlive()) {
                moleThreads[i].interrupt();
            }
        }
    }

    public synchronized boolean gameOver() {
        return gameIsOver;
    }


    public synchronized void updateScore(int elapsed) {
        if (elapsed < 500) totalScore += 100;
        else if (elapsed < 1000) totalScore += 50;
        else totalScore += 10;

        mainView.displayScore(String.valueOf(totalScore));
    }


    public void setExposed(int index, boolean isExposed) {
        exposed[index] = isExposed;

        if (isExposed)
            mainView.displayImage(index, mainView.getMoleImage());
        else
            mainView.displayImage(index, null);
    }


    public void whackMole(int index) {
        if (index < 0 || index >= 5) return;

        if (exposed[index]) {
            if (moleThreads[index] != null)
                moleThreads[index].interrupt();
        }
    }
}
