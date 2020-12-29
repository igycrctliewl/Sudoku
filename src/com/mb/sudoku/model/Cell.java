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
	private static final Character[] ALL_CHARS = {'1','2','3','4','5','6','7','8','9'};

	private Set<Character> values;
	private Character solvedValue;
	
	/**
	 * This constructor creates a solved Cell with the provided value
	 */
	public Cell( Character value ) {
		this();
		if( value.equals('.') ) {
			// do nothing
		} else {
			this.setSolvedValue( value );
		}
	}
	
	
	/**
	 * The no-argument constructor creates a new unsolved Cell with all possible values.
	 */
	public Cell() {
		this.values = new HashSet<Character>( Arrays.asList( ALL_CHARS ) );
		this.solvedValue = null;
	}
	
	/**
	 * Eliminate a value from the list of possible values for this Cell.
	 * If the Cell has already been solved, always return false.
	 * If after removing a value the Cell is solved, call setSolvedValue
	 * @param remove the value to remove
	 * @return true if a value was removed, false if nothing was removed or this Cell is already solved
	 */
	public boolean removeValue( Character remove ) {
		if( this.isSolved() ) {
			return false;
		} else {
			// TODO: if the Cell has been solved, call the method to mark the Cell "solved"
			return this.values.remove( remove );
		}
	}


	public Character getSolvedValue() {
		if( this.solvedValue == null ) {
			return '.';
		} else {
			return this.solvedValue;
		}
	}

	/**
	 * Set the solved value for this Cell and also set the solved flag to true.
	 * @param solvedValue the solved value for this Cell
	 */
	private void setSolvedValue( Character solvedValue ) {
		this.values = null;
		this.solvedValue = solvedValue;
	}
	
	
	/**
	 * Return the value for the solved flag for this Cell
	 * @return true if the Cell has been solved, otherwise false
	 */
	public boolean isSolved() {
		return ! ( solvedValue == null );
	}
	
	/**
	 * Present this Cell current solved value as a String.  This will either be the genuine
	 * solved value or a period "." representing an unsolved value.
	 */
	public String toString() {
		if( this.isSolved() ) {
			return "solved: " + this.solvedValue.toString();
		} else {
			return "possibly " + values.toString();
		}
	}
	
	
	
	public static void main(String[] args) {
		System.out.println( "Cell.main()" );
		Cell c = new Cell();
		System.out.println( c.removeValue( '3' ) );
		System.out.println( c );

		Cell b = new Cell( '5' );
		System.out.println( b );
	}

}
