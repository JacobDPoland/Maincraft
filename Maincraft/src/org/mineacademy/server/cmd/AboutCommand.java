package org.mineacademy.server.cmd;

public class AboutCommand extends Command {

	protected AboutCommand() {
		super("about");
	}

	@Override
	public void execute(String[] args) {
		System.out.println("This server is running Maincraft 1.0.0");
		System.out.println("This server is a part of Java Masterclass");
	}
}
