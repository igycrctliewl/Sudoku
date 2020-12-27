package com.mb.sudoku.model;

/**
 * @deprecated I thought about changing the grid to an array of Character but I changed back to
 * an array of the custom class Cell
 * @author mikebro
 *
 */
@Deprecated
public class GameGrid {

	private Character[][] gameGrid;
	
	public GameGrid() {
		gameGrid = new Character[9][9];
		for( int row = 0; row < 9; row++ ) {
			for( int col = 0; col < 9; col++ ) {
				this.gameGrid[row][col] = null;
			}
		}
	}
	
	public Group getRow( int rowNum ) {
		Group row = null;
		return row;
	}
	
	public Group getColumn( int colNum ) {
		return null;
	}
	
	public Group getSector( int secNum ) {
		return null;
	}
	
	public static void main( String[] args ) {
		GameGrid gb = new GameGrid();
		System.out.println( gb );
		Group g1 = gb.getRow( 0 );
		System.out.println( g1 );
	}
}
