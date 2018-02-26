package route;

import java.io.*;
import java.util.*;

public class util {

    /**
     * from -> to 1:n
     */
    private static HashMap<String, HashSet<String>> graph = new HashMap<>();
    private static Queue<String> stops = new ArrayDeque<>();
    private static HashSet<String> been = new HashSet<>();

    static void readFile(String path) throws FileNotFoundException {
        Scanner s = new Scanner(new File(path));
        while (s.hasNextLine()) {
            String[] split = s.nextLine().split(",");
            if (graph.containsKey(split[1])) {
                graph.get(split[1]).add(split[2]);
            } else {
                HashSet<String> temp = new HashSet<>();
                temp.add(split[2]);
                graph.put(split[1], temp);
            }
        }
    }

    /**
     * Return how many stops have to make that gets from the one airport to the
     * other.
     *
     * @param from
     * @param to
     * @return -1 if it's impossible to get from the one airport to the other.
     */
    private static int StopsToDestination(String from, String to) {
        int count = 0;
        stops.add(from);
        while (stops.size() > 0) {
            String poll = stops.poll();
            if (been.contains(poll)) {
                continue;
            }
            been.add(poll);
            HashSet<String> get = graph.get(poll);
            if (get == null) {
                continue;
            }
            if (get.contains(to)) {
                return count;
            }
            count++;
            stops.addAll(get);
        }
        return -1;
    }

    private static void Clean() {
        stops.clear();
        been.clear();
    }

    static void UI() throws IOException {
        System.out.println("Search if it is possible to get from the one airport to the other. ");
        while (true) {
            Clean();
            System.out.println("Type in airport codes, for example, AER KZN");
            Scanner s = new Scanner(System.in);
            String inFrom = "", inTo = "";
            if (s.hasNext()) {
                inFrom = s.next();
            }
            if (s.hasNext()) {
                inTo = s.next();
            }

            int stps = StopsToDestination(inFrom, inTo);
            String temp = "";
            if (stps == -1) {
                temp = "Impossible to get there! ";
            } else if (stps == 0) {
                temp = "Non-stop flights to get there!";
            } else {
                temp = "Have to make " + stps + " stop(s) to get there!";
            }
            System.out.println(temp);
        }
    }
}
