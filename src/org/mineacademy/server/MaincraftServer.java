package org.mineacademy.server;

import org.mineacademy.server.entity.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class MaincraftServer {

	public static void main(String[] args) {
		MaincraftServer server = new MaincraftServer();

//		server.testBlueprint();
//		server.testWorld();
//		server.testSet();
//		server.testUnmodifiableList();
//		server.testBlocks();
//		server.testEntities();
//		server.testSorting();
//		server.testQueue();
		server.testStorage();
	}

	private void testStorage() {
		File file = new File("names.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException ex) {
				System.err.println("Error creating file: " + file.getAbsolutePath());
				ex.printStackTrace();
			}
		}
		System.out.println(file.getAbsolutePath());

		List<String> lines = Arrays.asList("John", "Jacob", "Jingleheimershmit", "Gort");
		try {
			Files.write(file.toPath(), lines);
		} catch (IOException ex) {
			System.err.println("Error writing to file: " + file.getAbsolutePath());
			ex.printStackTrace();
		}
	}

	private void testQueue() {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(1);
		queue.add(4);
		queue.add(69);
		queue.add(420);

		while (!queue.isEmpty()) {
			System.out.println("Current line: " + queue);
			System.out.println("Now serving ticket number: " + queue.poll());
		}
	}

	private void testSorting() {
		Set<Integer> numbers = new TreeSet<>(Arrays.asList(1, 5, 353, 4, 0));
		System.out.println("Set of numbers before 2 is inserted: " + numbers);
		numbers.add(2);
		System.out.println("Set of numbers after 2 is inserted: " + numbers);
		System.out.println();  // blank line

		Map<String, Integer> sortedMap = new TreeMap<>();         // Sorts entries by key by default
		Map<String, Integer> linkedMap = new LinkedHashMap<>();  // preservers insertion order
		sortedMap.put("x", 1);
		sortedMap.put("a", 69);
		sortedMap.put("h", 42);
		System.out.println("sortedMap: " + sortedMap + '\n');

		Map<String, Integer> customSortedMap = new TreeMap<>(new Comparator<>() {
			@Override
			public int compare(String first, String second) {
//				return first.compareTo(second);
				return second.compareTo(first);
			}
		});
		customSortedMap.put("x", 1);
		customSortedMap.put("a", 69);
		customSortedMap.put("h", 42);
		System.out.println("customSortedMap: " + customSortedMap + '\n');
	}

	private void testEntities() {
		EntityRegistry entityRegistry = new EntityRegistry();

		Skeleton skeleton2 = new Skeleton("Skeleton 2", 69);

		entityRegistry.add(new Skeleton("Boner", 69));
		entityRegistry.add(skeleton2);
		entityRegistry.add(new Zombie("Hungry", 69));
		entityRegistry.add(new Player("Horny"));

		entityRegistry.remove(skeleton2);
		System.out.println(entityRegistry.getEntities());
	}

	private void testBlocks() {
		World world = new World();

		world.add(new Location(1, 2, 3), new Block("grass"));
		world.add(new Location(1, 2, 3), new Block("grass"));
		world.add(new Location(1, 2, 5), new Block("grass"));

		System.out.println(world.getBlocks());
		world.removeBlock(1, 2, 5);
		System.out.println(world.getBlocks());
	}

	private void testUnmodifiableList() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(1);
		list = Collections.unmodifiableList(list);
	}

	private void testSet() {
		Set<Integer> set = new HashSet<>();

		set.add(1);
		set.add(2);
		set.add(3);
		set.add(1);

		System.out.println(set);
	}

	private void testWorld() {
		World world = new World();
//		world.add(new Block("GRASS", 1, 1, 1));
//		world.add(new Block("GRASS", 1, 2, 1));
//		world.add(new Block("GRASS", 1, 3, 1));

		System.out.println(world.getBlocks());
	}

	private void testBlueprint() {
		Hostile hostile = new Skeleton("Skel", 20);
		System.out.println(hostile);
	}

	private void listen() {

		/*String command = "";

		Scanner scanner = new Scanner(System.in);

		System.out.println("Minecraft server loaded. Type your command.");

		while (!(command = scanner.nextLine()).equals("exit")) {

			if (command.equals("about"))
				System.out.println("Server version 1.0_theBest");

			else if (command.equals("authorname"))
				System.out.println("Matej");

			else
				System.out.println("Unknown command. Type 'exit to quit.");
		}

		System.out.println("Good bye.");*/
	}

	private void testLoops() {
		//for (int number : Arrays.asList(10, 1, 2, 3, 5))
		//	System.out.println("Number is " + number);

		//for (int number = 0; number < 10; number++) {
		//	System.out.println("Number is " + number);
		//}

		//int number = 0;
		//do {
		//	System.out.println("Number = " + number);
		//} while (number < 10);

		System.out.println("The end.");
	}

	private void testErrors() {
		Monster monster = new Skeleton("Example monster", 30);

		try {
			monster.damageTarget(20);
			System.out.println("This is called after the method");

		} catch (Exception ex) {
			ex.printStackTrace();

			System.out.println("Monster had apparently no target");

		} finally {
			System.out.println("This is called in the final block");
		}


		System.out.println("This is called at the end");

	}

}
