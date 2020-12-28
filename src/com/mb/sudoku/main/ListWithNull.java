package com.mb.sudoku.main;

import java.util.ArrayList;
import java.util.List;

public class ListWithNull {
	public static void main( String[] args ) {
		List<String> list = new ArrayList<>();
		String empty = null;
		
		list.add( empty );
		list.add( empty );
		
		System.out.println( list.size() );
		// I didn't expect that.  The add() method added a new String each time with null value.
		// The result was list contained two String objects with value null
	}
}
