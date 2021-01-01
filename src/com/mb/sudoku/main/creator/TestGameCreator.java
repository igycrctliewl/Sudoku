package com.mb.sudoku.main.creator;

import com.mb.sudoku.model.Cell;
import com.mb.sudoku.model.GameBoard;


public class TestGameCreator implements GameCreator {
	private static String testData = "7....234.....9..5.2...6.....29.....7...2.3...1.....68.....1...3.6..3.....754....9";

	@Override
	public GameBoard createGame() {
		GameBoard board = new GameBoard();

		int j = 0;
		for( int i = 0; i < 9; i++ ) {
			String line = testData.substring( (i * 9), ((i * 9) + 9) );

			Cell[] row = new Cell[9];
			for( int k = 0; k < 9; k++ ) {
				row[k] = new Cell( line.toCharArray()[k] );
			}

			board.addBoardRow( j++, row );
		}

		board.initialize();
		return board;

	}

}