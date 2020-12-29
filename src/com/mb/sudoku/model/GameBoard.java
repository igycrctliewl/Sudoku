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
	private List<Group> groups;
	public List<Group> getGroups() {
		return this.groups;
	}

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
		// TODO: Consider whether this method should detect and populate any missing cells in the game board
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

		this.groups = new ArrayList<>();
		groups.addAll( rows );
		groups.addAll( columns );
		groups.addAll( sectors );
		groups.addAll( diags );
	}

	private void populateRows() {
		for( int i = 0; i < 9; i++ ) {
			Group row = getRow( i );
			this.rows.add( row );
		}
	}
	private void populateColumns() {
		for( int i = 0; i < 9; i++ ) {
			Group col = getColumn( i );
			this.columns.add( col );
		}
	}
	private void populateSectors() {
		for( int i = 0; i < 9; i++ ) {
			Group sect = getSector( i );
			this.sectors.add( sect );
		}
	}
	private void populateDiagonals() {
		this.diags.add( this.getDiagonal(0) );
		this.diags.add( this.getDiagonal(1) );
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
		Cell[] cells = new Cell[9];
		int sectorRow = ( secNum / 3 );
		int sectorCol = ( secNum % 3 );
		int baseRow = sectorRow * 3;
		int baseCol = sectorCol * 3;
		int i = 0;

		for( int j = 0; j < 3; j++ ) {
			for( int k = 0; k < 3; k++ ) {
				Cell c = this.gridBoard[ baseRow + j ][ baseCol + k ];
				cells[i++] = c;
			}
		}
		return new Group( cells );
	}

	/**
	 * For Sudoku-X puzzles, the up and down diagonal lines
	 * @param xNum <li>0 - from top left descending
	 * <li>1 - from bottom left ascending
	 * @return Group representing one of the diagonal lines
	 */
	public Group getDiagonal( int xNum ) {
		int startRow;
		int startCol;
		int step;

		if( xNum == 0 ) {
			startRow = 0;
			startCol = 0;
			step = +1;
		} else {
			startRow = 8;
			startCol = 0;
			step = -1;
		}

		Cell[] cells = new Cell[9];
		for( int row = startRow, col = startCol; col < 9; row += step, col++ ) {
			cells[ col ] = this.gridBoard[ row ][ col ];
		}
		return new Group( cells );
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
			sb.append( row.toString() ).append( System.lineSeparator() );
		}
		return sb.toString();
	}


	public static void main( String[] args ) {
		GameBoard gb = new GameBoard();
		Group g1 = gb.getColumn( 0 );
		System.out.println( g1 );
	}
}
