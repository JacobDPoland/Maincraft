package org.mineacademy.server;

import org.mineacademy.server.cmd.CommandExecutor;
import org.mineacademy.server.cmd.ConsoleReader;

public class MaincraftServer {

	public static void main(final String[] args) {
//		new MaincraftServer().start();
		new MaincraftServer().testLambda();
	}

	private static MaincraftServer instance;

	private final ConsoleReader consoleReader = new ConsoleReader();
	private final CommandExecutor commandExecutor = new CommandExecutor();

	private boolean running;

	private MaincraftServer() {
	}

	private void testLambda() {
		final Adder adder = (firstNumber, secondNumber) -> firstNumber + secondNumber;
		final Printer printer = (message) -> {
			System.out.println("You are a " + message);
		};
		printer.print("Nice Person");
	}

	public interface Adder {
		int add(int first, int second);
	}

	public interface Printer {
		void print(String message);
	}

	private void start() {
		Thread.currentThread().setName("Maincraft main thread");

		instance = this;
		running = true;

		commandExecutor.register();
		consoleReader.start();

		System.out.println("Server has started. Type your command.");

		while (running) {

			// TPS = ticks per seconds
			// /tps = 20
			// 1000 ms / 20 = 50

			try {
				Thread.sleep(50);
			} catch (final InterruptedException ex) {
				ex.printStackTrace();
			}

			commandExecutor.tick();
		}

		System.out.println("Server is stopped. Good bye.");
		System.exit(0);
	}

	public void stop() {
		running = false;
	}

	public boolean isRunning() {
		return running;
	}

	public CommandExecutor getCommandExecutor() {
		return commandExecutor;
	}

	public static MaincraftServer getInstance() {
		return instance;
	}
}
