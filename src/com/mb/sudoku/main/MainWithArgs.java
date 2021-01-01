package com.mb.sudoku.main;

public class MainWithArgs {
	public static void main( String[] args) {
		for( String s : args ) {
			System.out.println( s );
			switch( s ) {
			case "X":
				System.out.println( "Sudoku-X puzzle" );
				break;
			case "TEST":
				System.out.println( "Product testing activated" );
				break;
			}
				
		}
	}

}
