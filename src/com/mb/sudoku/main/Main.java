package com.mb.sudoku.main;

import java.io.IOException;


public class Main {
	public static void main( String[] args) {
		byte[] bytes = new byte[9];
		try {
			int i = System.in.read( bytes );
			System.out.println( i );
		} catch( IOException ioe ) {
			ioe.printStackTrace();
		}
		
		String line = new String( bytes );
		System.out.println( line );
		
	}

}
