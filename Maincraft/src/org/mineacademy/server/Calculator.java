package org.mineacademy.server;

import java.util.Scanner;

/**
 * A simple 4 operation calculator
 *
 * @author MineAcademy
 */
public class Calculator {

	public static void main(String[] args) {
		Calculator calc = new Calculator();

		calc.listen();
	}

	private void listen() {
		System.out.println("Calculator started.");

		Scanner scanner = new Scanner(System.in);

		while (true) {

			// save the command read
			String command = "";

			// print info message
			System.out.println("Please enter the operation, e.g.: 1 + 2 (space separated)");

			// wait for command
			command = scanner.nextLine();

			// stop the loop if exit
			if (command.equals("exit"))
				break;

			String[] args = command.split(" ");

			if (args.length != 3) {
				System.out.println("Invalid syntax.");

				continue;
			}

			double firstNumber, secondNumber;

			try {
				firstNumber = Double.parseDouble(args[0]);
				secondNumber = Double.parseDouble(args[2]);

			} catch (NumberFormatException ex) {
				System.out.println("Please type both numbers as whole numbers, space separated");

				continue;
			}

			command = args[1];

			if (command.equals("+"))
				System.out.println("Result: " + (firstNumber + secondNumber));

			else if (command.equals("-"))
				System.out.println("Result: " + (firstNumber - secondNumber));

			else if (command.equals("/"))
				System.out.println("Result: " + (firstNumber / secondNumber));

			else if (command.equals("*"))
				System.out.println("Result: " + (firstNumber * secondNumber));

			else {
				System.out.println("Invalid operator: " + command);

				// Do not increase mode if invalid operator, simply repeat this loop
				continue;
			}

			// blank line
			System.out.println();

		}

		System.out.println("Calculator quit. Good bye.");
	}

}
