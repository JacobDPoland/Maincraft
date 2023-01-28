package org.mineacademy.server.cmd;

import org.mineacademy.server.MaincraftServer;

import java.util.Scanner;

public class ConsoleReader extends Thread {

	@Override
	public void run() {
		MaincraftServer instance = MaincraftServer.getInstance();
		Scanner scanner = new Scanner(System.in);

		while (instance.isRunning()) {
			String line = scanner.nextLine();

			if (!line.isEmpty())
				instance.getCommandExecutor().schedule(line);
		}
	}
}
