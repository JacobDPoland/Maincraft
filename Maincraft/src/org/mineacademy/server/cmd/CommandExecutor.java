package org.mineacademy.server.cmd;

import java.util.*;

public class CommandExecutor {

	private Map<String, Command> commands = new HashMap<>();
	private List<String> pendingCommands = new ArrayList<>();

	public void register() {
		reg(new AboutCommand());
		reg(new StopCommand());
	}

	private void reg(Command command) {
		commands.put(command.getLabel(), command);
	}

	public void schedule(String line) {
		synchronized (pendingCommands) {
			pendingCommands.add(line);
		}
	}

	public void tick() {
		synchronized (pendingCommands) {
			List<String> copy = new ArrayList<>();

			copy.addAll(pendingCommands);
			pendingCommands.clear();

			for (String line : copy) {

				String[] split = line.split(" ");

				String label = split[0];
				String[] args = split.length > 1 ? Arrays.copyOfRange(split, 1, split.length) : new String[0];

				Command command = commands.get(label);

				if (command == null) {
					System.out.println("No such command '" + label + "'. Type 'stop' to exit.");

					continue;
				}

				command.execute(args);
			}
		}
	}
}
