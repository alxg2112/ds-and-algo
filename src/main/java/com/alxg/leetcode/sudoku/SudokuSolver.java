package com.alxg.leetcode.sudoku;

import java.util.Arrays;

public class SudokuSolver {

	private static char EMPTY_CELL = '.';
	private static int BOARD_SIZE = 9;
	private static int SQUARE_SIZE = 3;

	public void solveSudoku(char[][] board) {
		int[][] intBoard = toIntBoard(board);

		solveSudoku(intBoard);
		copy(intBoard, board);
	}

	private boolean solveSudoku(int[][] intBoard) {
		int[] firstEmptyCellCoordinates = getFirstEmptyCellCoordinates(intBoard);
		if (firstEmptyCellCoordinates == null) {
			return true;
		}

		int rowIndex = firstEmptyCellCoordinates[0];
		int columnIndex = firstEmptyCellCoordinates[1];

		for (int candidate = 1; candidate <= BOARD_SIZE; candidate++) {
			if (constraintsSatisfied(intBoard, rowIndex, columnIndex, candidate)) {
				intBoard[rowIndex][columnIndex] = candidate;

				if (solveSudoku(intBoard)) {
					return true;
				} else {
					intBoard[rowIndex][columnIndex] = 0;
				}
			}
		}

		return false;
	}

	private boolean constraintsSatisfied(int[][] intBoard, int rowIndex, int columnIndex, int candidate) {
		return rowConstraintSatisfied(intBoard, rowIndex, columnIndex, candidate)
				&& columnConstraintSatisfied(intBoard, rowIndex, columnIndex, candidate)
				&& squareConstraintSatisfied(intBoard, rowIndex, columnIndex, candidate);
	}

	private boolean rowConstraintSatisfied(int[][] intBoard, int rowIndex, int columnIndex, int candidate) {
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (i == rowIndex) continue;
			int currentCell = intBoard[i][columnIndex];
			if (currentCell == candidate) {
				return false;
			}
		}
		return true;
	}

	private boolean columnConstraintSatisfied(int[][] intBoard, int rowIndex, int columnIndex, int candidate) {
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (i == columnIndex) continue;
			int currentCell = intBoard[rowIndex][i];
			if (currentCell == candidate) {
				return false;
			}
		}
		return true;
	}

	private boolean squareConstraintSatisfied(int[][] intBoard, int rowIndex, int columnIndex, int candidate) {
		int rowOffset = rowIndex - (rowIndex % SQUARE_SIZE);
		int columnOffset = columnIndex - (columnIndex % SQUARE_SIZE);
		for (int i = rowOffset; i < rowOffset + SQUARE_SIZE; i++) {
			for (int j = columnOffset; j < columnOffset + SQUARE_SIZE; j++) {
				if (i == rowIndex && j == columnIndex) continue;
				int currentCell = intBoard[i][j];
				if (currentCell == candidate) {
					return false;
				}
			}
		}
		return true;
	}

	private void copy(int[][] intBoard, char[][] board) {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = Character.forDigit(intBoard[i][j], 10);
			}
		}
	}

	private int[] getFirstEmptyCellCoordinates(int[][] intBoard) {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (intBoard[i][j] == 0) {
					return new int[]{i, j};
				}
			}
		}
		return null;
	}

	private int[][] toIntBoard(char[][] board) {
		int[][] intBoard = new int[BOARD_SIZE][BOARD_SIZE];

		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				intBoard[i][j] = board[i][j] == EMPTY_CELL
						? 0
						: Character.getNumericValue(board[i][j]);
			}
		}

		return intBoard;
	}

	public static void main(String[] args) {
		char[][] board = new char[][]{
				{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		};
		new SudokuSolver().solveSudoku(board);
		Arrays.stream(board).forEach(row -> System.out.println(Arrays.toString(row) + '\n'));
	}
}
