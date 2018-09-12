package com.mb.sudoku.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The Cell class represents a single cell of the Sudoku game board.  Each row, column or sector of the
 * game board contains nine cells.  A Cell that has been solved has one and only one value.  A Cell that
 * has not been solved may have many possible values.
 * @author mikebro
 *
 */
public class Cell {

	private boolean solved;
	private Set<Character> values;
	private char solvedValue;
	
	/**
	 * This constructor creates a solved Cell with the provided value
	 */
	public Cell( char value ) {
		this.setSolvedValue( value );
	}
	
	
	/**
	 * The no-argument constructor creates a new unsolved Cell with all possible values.
	 */
	public Cell() {
		this.setSolved( false );
		this.values = new HashSet<Character>( Arrays.asList( ALL_CHARS ) );
		this.solvedValue = '.';
	}
	
	/**
	 * Eliminate a value from the list of possible values for this Cell.
	 * If the Cell has already been solved, always return false.
	 * @param remove the value to remove
	 * @return true if a value was removed, false if nothing was removed or this Cell is already solved
	 */
	public boolean removeValue( char remove ) {
		if( this.isSolved() ) {
			return false;
		} else {
			return this.values.remove( remove );			
		}
	}
	
	/**
	 * Set the solved value for this Cell and also set the solved flag to true.
	 * @param solvedValue the solved value for this Cell
	 */
	public void setSolvedValue( char solvedValue ) {
		// TODO: this feels like it should not be a public method
		// perhaps the solved value should only be set when there is 
		// a single value remaining in this.values
		this.values = null;
		this.solvedValue = solvedValue;
		this.setSolved( true );
	}
	
	/**
	 * Set the value for the solved flag for this Cell
	 * @param solved
	 */
	public void setSolved( boolean solved ) {
		this.solved = solved;
	}
	
	/**
	 * Return the value for the solved flag for this Cell
	 * @return true if the Cell has been solved, otherwise false
	 */
	public boolean isSolved() {
		return solved;
	}
	
	/**
	 * Present this Cell current solved value as a String.  This will either be the genuine
	 * solved value or a period "." representing an unsolved value.
	 */
	public String toString() {
		return Character.toString( this.solvedValue );
	}
	
	
	private static final Character[] ALL_CHARS = {'1','2','3','4','5','6','7','8','9'};
	
	public static void main(String[] args) {
		System.out.println( "Cell.main()" );
		Cell c = new Cell();
		System.out.println( c.removeValue( '3' ) );
		System.out.println( c );
	}

}
