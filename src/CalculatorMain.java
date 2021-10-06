package Calculator;

import javax.swing.JFrame;

public class CalculatorMain {
	public static void main(String[] args) {
		Calculator main = new Calculator();
		main.setVisible(true);
		main.setSize(450, 660);
		main.setTitle("Calculator");
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}