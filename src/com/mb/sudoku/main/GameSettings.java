package com.mb.sudoku.main;

/**
 * A class for holding the selectable game properties and methods which act on
 * those properties.
 *
 */
public class GameSettings {

	private static GameSettings properties = new GameSettings();
	public static GameSettings getProperties() {
		return GameSettings.properties;
	}


	private boolean sudokuXGame;
	private boolean testingMode;

	public boolean isSudokuXGame() {
		return sudokuXGame;
	}
	public void setSudokuXGame(boolean sudokuXGame) {
		this.sudokuXGame = sudokuXGame;
	}

	public boolean isTestingMode() {
		return testingMode;
	}
	public void setTestingMode(boolean testingMode) {
		this.testingMode = testingMode;
	}

	private GameSettings() {
		super();
	}
}
