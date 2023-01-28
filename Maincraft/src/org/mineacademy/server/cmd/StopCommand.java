package org.mineacademy.server.cmd;

import org.mineacademy.server.MaincraftServer;

public class StopCommand extends Command {

	protected StopCommand() {
		super("stop");
	}

	@Override
	public void execute(String[] args) {
		System.out.println("Stopping the server ..");

		MaincraftServer.getInstance().stop();
	}
}
