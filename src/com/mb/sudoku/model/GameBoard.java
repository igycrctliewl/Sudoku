package com.mb.sudoku.model;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

	private Cell[][] gridBoard;
	private List<Group> rows;
	private List<Group> columns;
	private List<Group> sectors;
	private boolean sudokuXPuzzle;
	private List<Group> diags;


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
		this.rows = new ArrayList<>();
		populateRows();
		this.columns = new ArrayList<>();
		populateColumns();
		this.sectors = new ArrayList<>();
		populateSectors();
		this.diags = new ArrayList<>();
		if( this.isSudokuXPuzzle() ) {
			populateDiagonals();
		}
	}

	private void populateRows() {
		for( int i = 0; i < 9; i++ ) {
			Group row = getRow( i );
			this.rows.add( row );
		}
	}
	private void populateColumns() {
		
	}
	private void populateSectors() {
		
	}
	private void populateDiagonals() {
		
	}


	public Group getRow( int rowNum ) {
		Group row = new Group( this.gridBoard[rowNum] );
		return row;
	}
	
	public Group getColumn( int colNum ) {
		Cell[] cells = new Cell[9];
		for( int i = 0; i < 9; i++ ) {
			cells[i] = this.gridBoard[i][colNum];
		}
		return new Group( cells );
	}

	public Group getSector( int secNum ) {
		return null;
	}

	/**
	 * For Sudoku-X puzzles, the up and down diagonal lines
	 * @param xNum <li>0 - from top left descending
	 * <li>1 - from bottom left ascending
	 * @return Group representing one of the diagonal lines
	 */
	public Group getDiagonal( int xNum ) {
		if( this.isSudokuXPuzzle() ) {
			//calculate the diagonal
			return null;
		} else {
			return null;
		}
	}

	public void setSudokuXPuzzle( boolean newValue ) {
		this.sudokuXPuzzle = newValue;
	}

	public boolean isSudokuXPuzzle() {
		return this.sudokuXPuzzle;
	}


	public String toString() {
		StringBuilder sb = new StringBuilder();
		for( Group row : rows ) {
			sb.append( row.toString() );
		}
		return sb.toString();
	}


	public static void main( String[] args ) {
		GameBoard gb = new GameBoard();
		Group g1 = gb.getColumn( 0 );
		System.out.println( g1 );
	}
}
