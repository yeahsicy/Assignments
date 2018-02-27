package route;

import java.io.*;
import java.util.*;

public class util {

    /**
     * from -> to 1:n
     */
    private static HashMap<String, HashSet<String>> graph = new HashMap<>();
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

    static int GetStops(String from, String to) {
        HashSet<String> destinations = graph.get(from);
        if (destinations == null || destinations.isEmpty()) {
            return -1;
        }
        if (destinations.contains(to)) {
            return 0;
        }
        //if already been this stop, avoid doing again. 
        if (!been.add(from)) {
            return -1;
        }
        int minStop = -1;
        for (String d : destinations) {
            int Stops = GetStops(d, to);
            if (Stops == -1) {
                continue;
            }
            if (minStop < 0) {
                minStop = Stops + 1;
            } else {
                minStop = Integer.min(minStop, Stops + 1);
            }
        }
        return minStop;
    }

    private static void Clean() {
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
                inFrom = s.next().toUpperCase();
            }
            if (s.hasNext()) {
                inTo = s.next().toUpperCase();
            }

            int stps = GetStops(inFrom, inTo);
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
