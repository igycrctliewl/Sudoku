package com.mb.sudoku.model;

import java.util.Arrays;
import java.util.List;

/**
 * Group is the superclass for Row Column and Sector
 * @author mikebro
 *
 */
public class Group {

	private Cell[] cells;
	public List<Cell> getCells() {
		return Arrays.asList( cells );
	}

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


	public String toString() {
		StringBuilder sb = new StringBuilder();
		for( Cell cell : this.cells ) {
			sb.append( cell.getSolvedValue() );
		}
		return sb.toString();
	}

}
