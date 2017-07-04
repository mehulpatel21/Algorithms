package interview_questions;

/*
 * Author: Mehul Patel
 * Date: 07/03/2017
 * Code Test:FENICS Cities Connected exercise.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * Problem Statement:
 * Connected Cities
--------------------------------
	Suppose you are given a text file containing pairs of city names, one pair per line, with the names on each line separated by a comma.
	The file might look something like:
	
	Philadelphia, Pittsburgh
	Boston, New York
	Philadelphia, New York
	Los Angeles, San Diego
	New York, Croton-Harmon
	St. Petersburg, Tampa
	
	Each line of the file indicates that it is possible to travel between the two cities named. (More formally, if we think of the cities as nodes
	in a graph, each line of the file specifies an edge between two nodes.) In the example above it is possible to travel between Boston and
	New York, and also between New York and Philadelphia and between Philadelphia and Pittsburgh, so it follows that Boston and
	Pittsburgh are connected. On the other hand, there is no path between Boston and Tampa, so they are not connected.
	
	Write a Java (or C++) program, called "Connected" that reads in such a file and outputs whether two specified cities are connected.
	
	The program will be invoked from the command line as:
	java Connected <filename> <cityname1> <cityname2>
	and will output a single line stating "yes" or "no"
 */

/*
 * Test: Program arguments passed at run configuration, Java 8 compiler:
 * "/Users/Leo/ProgrammingPractice/src/graph_algorithms/input.txt" "New York" Pittsburgh
 */

public class Connected {

	public static void main(String[] args) {
		if (args == null || args.length != 3) {
			System.out.println("Please check your arguments passed to this program!");
			System.exit(1);
		} else {
			String filename = args[0];
			String city1 = args[1];
			String city2 = args[2];

			try {
				Map<String, Set<String>> cityNodeMap = fileParse(filename);
				boolean result = isConnected(cityNodeMap, city1, city2);
				showResult(result);
				System.exit(0);
			} catch (Exception e) {
				String message = e.getMessage();
				System.err.println("Error Occurred..." + message);
				e.printStackTrace();
				System.exit(2);
			}
		}
	}

	/*
	 * Keys in the map are the total cities available. Value is a set of cities that each city is connected to. Basically node connection.
	 * If there is a key-value pair that exists, then those cities are connected. This is a bidirectional relation in an undirected graph.
	 */
	/*
	 * @param: String filename
	 * @return: Map<String, Set<String>> cityNodeMap
	 */
	private static Map<String, Set<String>> fileParse(String filename) throws IOException {
		Map<String, Set<String>> cityNodeMap = new HashMap<String, Set<String>>();

		BufferedReader bufferedReader = null;
		try {
			// File reader connection opened
			Reader fileReader = new FileReader(filename);
			bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			
			// Iterating through line by line
			while (line != null && !line.isEmpty()) {
				String[] cities = line.split(",");
				String firstCity = cities[0].trim();
				String secondCity = cities[1].trim();
				
				Set<String> firstCityConnections = getCityConnections(cityNodeMap, firstCity);
				Set<String> secondCityConnections = getCityConnections(cityNodeMap, secondCity);
				firstCityConnections.add(secondCity);
				secondCityConnections.add(firstCity);

				line = bufferedReader.readLine();
			}
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
		return cityNodeMap;
	}

	/*
	 * @param: Map<String, Set<String>> map, String city
	 * @return: Set<String>
	 */
	private static Set<String> getCityConnections(Map<String, Set<String>> map, String city) {
		if (!map.containsKey(city)) {
			map.put(city, new HashSet<String>());
		}
		return map.get(city);
	}
	
	/*
	 * @param: Map<String, Set<String>>, String
	 * @return: boolean - isConnected
	 */
	private static boolean isConnected(Map<String, Set<String>> cityNodeMap, String city1, String city2) {
		boolean isFound = city1.equals(city2);
		if (cityNodeMap.containsKey(city1) && cityNodeMap.containsKey(city2)) {
			// BFS with queue to find shortest path between two cities
			Queue<String> citiesToVisit = new LinkedList<String>();

			// Track already visited city nodes to avoid cycle in BFS
			Set<String> visitedCities = new HashSet<String>();

			citiesToVisit.add(city1);

			while (!citiesToVisit.isEmpty() && !isFound) {
				String city = citiesToVisit.poll();
				isFound = city.equals(city2);

				Set<String> possibleConnections = cityNodeMap.get(city);
				for (String possibleCity : possibleConnections) {
					if (!visitedCities.contains(possibleCity)) {
						citiesToVisit.add(possibleCity);
						visitedCities.add(possibleCity);
					}
				}
			}
		}
		return isFound;
	}
	
	/*
	 * @param: boolean - result
	 */
	private static void showResult(boolean result) {
		if (result) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}