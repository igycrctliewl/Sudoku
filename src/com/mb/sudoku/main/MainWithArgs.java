package com.mb.sudoku.main;

import com.mb.sudoku.main.creator.GameCreator;
import com.mb.sudoku.main.creator.GameCreatorFactory;
import com.mb.sudoku.model.GameBoard;

public class MainWithArgs {

	public static void main( String[] args) {
		GameSettings props = GameSettings.getProperties();
		for( String s : args ) {
			switch( s ) {
			case "X":
				props.setSudokuXGame( true );
				break;
			case "TEST":
				props.setTestingMode( true );
				break;
			}
		}

		GameCreator creator = GameCreatorFactory.getGameCreator();
		GameBoard gameBoard = creator.createGame();
	}

}
