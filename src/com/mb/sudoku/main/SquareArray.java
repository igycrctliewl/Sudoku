package com.mb.sudoku.main;

import java.io.IOException;

import com.mb.sudoku.model.Cell;

/*
 * experimental class for studying 9x9 array
 * 
 */
public class SquareArray {
	
	public static void main( String[] args) {

		byte[][] square = new byte[9][];
		byte[] bytes = new byte[9];
		
		try {
			int i = System.in.read( bytes );
			System.out.println( i );
		} catch( IOException ioe ) {
			ioe.printStackTrace();
		}
		
		square[0] = bytes;
		square[1] = bytes;
		
		String line = new String( bytes );
		Cell[] row = new Cell[9];
		for( int i = 0; i < 9; i++ ) {
			row[i] = new Cell( line.toCharArray()[i] );
		}
		
		System.out.println( line );
		
	}

}
