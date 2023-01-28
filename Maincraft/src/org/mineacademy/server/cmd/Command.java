package org.mineacademy.server.cmd;

public abstract class Command {

	private final String label;

	protected Command(String label) {
		this.label = label;
	}

	public abstract void execute(String[] args);

	public final String getLabel() {
		return label;
	}
}
