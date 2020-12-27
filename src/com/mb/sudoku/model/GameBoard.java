package com.mb.sudoku.model;

public class GameBoard {

	private Cell[][] gridBoard;
	private Cell[][] rows;
	private Cell[][] columns;
	private Cell[][] sectors;
	private Cell[][] diags;


	public GameBoard() {
		gridBoard = new Cell[9][9];
		for( int row = 0; row < 9; row++ ) {
			for( int col = 0; col < 9; col++ ) {
				this.gridBoard[row][col] = new Cell();
			}
		}
	}
	
	public boolean addBoardRow( int rowNum, Cell[] cells ) {
		this.gridBoard[rowNum] = cells;
		return true;
	}

	/**
	 * Call this method after building the gridBoard.  This will initialize
	 * all the rows, columns, and sectors for the puzzle.
	 */
	public void initialize() {
		this.rows = this.gridBoard;
		this.columns = null;
		this.sectors = null;
		this.diags = null;
	}

	public Group getRow( int rowNum ) {
		Group row = new Group( this.rows[rowNum] );
		return row;
	}
	
	public Group getColumn( int colNum ) {
		return null;
	}
	
	public Group getSector( int secNum ) {
		return null;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for( Cell[] row : rows ) {
			for( Cell cell : row ) {
				sb.append( cell.getSolvedValue() );
			}
			sb.append( System.lineSeparator() );
		}
		return sb.toString();
	}


	public static void main( String[] args ) {
		GameBoard gb = new GameBoard();
		System.out.println( gb );
		Group g1 = gb.getRow( 0 );
		System.out.println( g1 );
	}
}
