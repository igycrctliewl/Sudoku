package com.mb.sudoku.main;

import com.mb.sudoku.engine.Solver;
import com.mb.sudoku.model.Cell;
import com.mb.sudoku.model.GameBoard;
import com.mb.sudoku.model.Group;


public class Test {
	public static void main( String[] args) {
		String testData = "7....234.....9..5.2...6.....29.....7...2.3...1.....68.....1...3.6..3.....754....9";
		GameBoard board = new GameBoard();
		board.setSudokuXPuzzle( true );

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
		// System.out.println( board );

		Group g = board.getDiagonal( 1 );
		System.out.println( g );

		boolean engineWorking = true;
		while( engineWorking ) {
			engineWorking = Solver.runSolverEngine( board.getGroups() );
		}

		g = board.getDiagonal( 1 );
		System.out.println( g );

		System.out.println( board );
	}

}
