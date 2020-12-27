package com.mb.sudoku.model;

/**
 * Group is the superclass for Row Column and Sector
 * @author mikebro
 *
 */
public class Group {

	private Cell[] cells;
	
	public Group( Cell[] cells ) {
		this.cells = cells;
	}

	public Group( Cell c0, Cell c1, Cell c2, Cell c3, Cell c4, Cell c5, Cell c6, Cell c7, Cell c8 ) {
		this.cells = new Cell[9];
		cells[0] = c0;
		cells[1] = c1;
		cells[2] = c2;
		cells[3] = c3;
		cells[4] = c4;
		cells[5] = c5;
		cells[6] = c6;
		cells[7] = c7;
		cells[8] = c8;
	}

}
