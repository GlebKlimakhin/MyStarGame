package com.gb.game;

import com.badlogic.gdx.Game;
import com.gb.game.screen.MenuScreen;

public class StarGame extends Game {

	@Override
	public void create () {
		setScreen(new MenuScreen());
	}


}
