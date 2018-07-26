package com.mb.sudoku.main;

import java.io.BufferedReader;
import java.io.IOException;


public class Main {
	public static void main( String[] args) {
		byte[] bytes = new byte[9];
		try {
			int i = System.in.read( bytes );
			int j = System.in.
			System.out.println( i );
		} catch( IOException ioe ) {
			ioe.printStackTrace();
		}
		
		for( byte b : bytes ) {
			String s = Byte.toString( b );
			System.out.println( s );
		}
	}

}
