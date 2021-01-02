package com.mb.sudoku.engine;

import java.util.Collection;

import com.mb.sudoku.model.Cell;
import com.mb.sudoku.model.Group;

public class Solver {

	public static boolean runSolverEngine( Collection<Group> groups ) {
		boolean result = false;
		for( Group group : groups ) {
			result = result | removeSolved( group );
			result = result | findSingle( group );
		}

		// 
		return result;
	}


	/** Scan this Group to look for any Cell whose value has been solved
	 * and remove that value from other unsolved cells.
	 * @return true if this Group was changed by the call, false if no changes
	 */
	private static boolean removeSolved( Group group ) {
		boolean result = false;
		
		for( Cell cell : group.getCells() ) {
			if( cell.isSolved() ) {
				for( Cell otherCell : group.getCells() ) {
					if( cell == otherCell ) {
						// do nothing
					} else {
						result = result | otherCell.removeValue( cell.getSolvedValue() );
						// System.out.println( otherCell );
					}
				}
			}
		}
		return result;
	}


	/**
	 * Scan this Group to find any unsolved value which occurs only once in all the cells.
	 * If found, declare this value the solved value.
	 * @return true if this Group was changed by the call, false if no changes
	 */
	
	private static boolean findSingle( Group group ) {
		boolean result = false;
		Cell potential = null;
		
		for( int a = 1; a <= 9; a++ ) {
			Character charA = String.valueOf( a ).charAt(0);

			// Count the occurrences of charA in this Group
			int count = 0;
			for( Cell cell : group.getCells() ) {
				if( cell.contains( charA ) ) {
					count++;
					potential = cell;
				}
			}

			// if there was only one occurrence, solve that cell for that value
			if( ! potential.isSolved() && count == 1 ) {
				potential.setSolvedValue( charA );
				result = true;
			}
		}
		return result;
	}


	/**
	 * Test whether this Group contains a valid solution.
	 * @return true if this Group is solved, false if not solved or not valid.
	 */
	public static boolean isValid( Group group ) {
		StringBuilder line = new StringBuilder();
		
		for( Cell cell : group.getCells() ) {
			if( cell.isSolved() ) {
				line.append( cell.getSolvedValue() );
			} else {
				return false;
			}
		}

		/* TODO: I guess I know what I was trying to do here, but this
		 * method seems unfocused.  Is it trying to find solved groups
		 * or is it trying to find invalid groups?  I think it should be
		 * one or the other.
		 * Perhaps this is more correctly a property of Group?
		 */
		for( int a = 1; a <= 9; a++ ) {
			Character charA = String.valueOf( a ).charAt(0);
			if( line.toString().contains( new StringBuilder( charA ) ) ) {
				// it should contain each charA
			} else {
				return false;
			}
		}

		// if we got this far, all criteria were satisfied
		return true;
	}

}