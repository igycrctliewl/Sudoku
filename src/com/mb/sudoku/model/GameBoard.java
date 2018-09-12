package com.mb.sudoku.model;

public class GameBoard {

	private Cell[][] gridBoard;
	
	public GameBoard() {
		gridBoard = new Cell[9][9];
		for( int row = 0; row < 9; row++ ) {
			for( int col = 0; col < 9; col++ ) {
				this.gridBoard[row][col] = new Cell();
			}
		}
	}
	
	public Group getRow( int rowNum ) {
		Group row = new Group( gridBoard[rowNum][0], 
				gridBoard[rowNum][1], 
				gridBoard[rowNum][2], 
				gridBoard[rowNum][3], 
				gridBoard[rowNum][4], 
				gridBoard[rowNum][5], 
				gridBoard[rowNum][6], 
				gridBoard[rowNum][7], 
				gridBoard[rowNum][8] );
		return row;
	}
	
	public Group getColumn( int colNum ) {
		return null;
	}
	
	public Group getSector( int secNum ) {
		return null;
	}
	
	public static void main( String[] args ) {
		GameBoard gb = new GameBoard();
		System.out.println( gb );
		Group g1 = gb.getRow( 0 );
		System.out.println( g1 );
	}
}
