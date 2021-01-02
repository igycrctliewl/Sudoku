package com.mb.sudoku.main.creator;

import java.io.IOException;

import com.mb.sudoku.model.Cell;
import com.mb.sudoku.model.GameBoard;

/**
 * An implementation of GameCreator to allow the user to input a game from the console Stdin
 * @author mikebro
 *
 */
public class StdinGameCreator implements GameCreator {

	@Override
	public GameBoard createGame() {
		byte[] bytes = new byte[9];
		GameBoard board = new GameBoard();

		int j = 0;
		while( true ) {

			try {
				int i = System.in.read( bytes );
				if( i < 9 ) {
					break;
				}
				// purge the rest of the input
				System.in.skip( 999 );
			} catch( IOException ioe ) {
				ioe.printStackTrace();
			}

			String line = new String( bytes );
			Cell[] row = new Cell[9];
			for( int i = 0; i < 9; i++ ) {
				row[i] = new Cell( line.toCharArray()[i] );
			}

			board.addBoardRow( j++, row );
		}

		board.initialize();
		return board;
	}

}
