package org.mineacademy.server;

public class Utils {


	public static final int COMPLEX_NUMBER;

	static {
		System.out.println("Static{} has been called!");

		int someCalculation = (int) Math.sin(2424.2);

		COMPLEX_NUMBER = someCalculation;
	}

}
