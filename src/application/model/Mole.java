package application.model;

import java.util.*;
import application.view.MainView;
import javafx.scene.image.*;

public class Mole implements Runnable {
	WhackAMole game;
	MainView mainView;
	Image moleImage;
	int index;
	Random rand;

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
		// TODO Auto-generated method stub
		
	}
}
