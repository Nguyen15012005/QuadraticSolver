package main;

import javax.swing.SwingUtilities;

import entity.QuadraticSolver;

public class Main {
	public static void main(String[] args) {
		QuadraticSolver quadraticSolver = new QuadraticSolver();
		SwingUtilities.invokeLater(() -> new QuadraticSolver().setVisible(true));
	}
}
