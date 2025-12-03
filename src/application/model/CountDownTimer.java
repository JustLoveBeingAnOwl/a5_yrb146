package application.model;

import application.view.MainView;


public class CountDownTimer implements Runnable {
    WhackAMole game;
    MainView mainView;
    int durationsSeconds;

    public CountDownTimer(WhackAMole game, MainView mainView) {
        this.game = game;
        this.mainView = mainView;
    }

    public void setGame(WhackAMole game) {
        this.game = game;
    }

    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public synchronized void run() {
        durationsSeconds = 30;
        while (durationsSeconds > 0 && !Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

            durationsSeconds--;
            mainView.displayTimeRemaining(String.valueOf(durationsSeconds));
        }

    
        game.endGame();
    }
}
