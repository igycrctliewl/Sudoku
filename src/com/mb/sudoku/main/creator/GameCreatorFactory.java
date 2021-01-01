package com.mb.sudoku.main.creator;

import com.mb.sudoku.main.GameSettings;

public class GameCreatorFactory {
	public static GameCreator getGameCreator() {
		if( GameSettings.getProperties().isTestingMode() ) {
			return new TestGameCreator();
		}
		return new StdinGameCreator();
	}
}
