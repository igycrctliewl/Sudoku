package com.mb.sudoku.model;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

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
		this.values = new TreeSet<Character>( Arrays.asList( ALL_CHARS ) );
		this.solvedValue = null;
	}


	public boolean contains( Character ch ) {
		if( this.isSolved() ) {
			return this.solvedValue.equals( ch );
		}
		return this.values.contains( ch );
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
			boolean result = this.values.remove( remove );
			// if the Cell has been solved, call the method to mark the Cell "solved"
			if( this.values.size() == 1 ) {
				this.setSolvedValue( (Character) ((TreeSet<?>) this.values).first() );
			}
			return result;
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
	public void setSolvedValue( Character solvedValue ) {
		if( this.isSolved() ) {
			return;
		} else {
			this.values = null;
			this.solvedValue = solvedValue;
		}
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



	protected static void main(String[] args) {
		System.out.println( "Cell.main()" );
		Cell c = new Cell();
		System.out.println( c.removeValue( '3' ) );
		System.out.println( c.removeValue( '7' ) );
		System.out.println( c.removeValue( '5' ) );
		System.out.println( c.removeValue( '4' ) );
		System.out.println( c.removeValue( '1' ) );
		System.out.println( c.removeValue( '6' ) );
		System.out.println( c.removeValue( '2' ) );
		System.out.println( c.removeValue( '8' ) );
		System.out.println( c );

		Cell b = new Cell( '5' );
		System.out.println( b );
	}

}
