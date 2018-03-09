package route;

import java.io.*;
import java.util.*;

public class util {

    /**
     * from -> to 1:n
     */
    private static HashMap<String, HashSet<String>> graph = new HashMap<>();
    private static HashSet<String> been = new HashSet<>();
    static ArrayList<String> PathMarker = new ArrayList<>();
    static ArrayList<String> thePath = new ArrayList<>();

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
        PathMarker.clear();
        thePath.clear();
    }

    static void UI(int maxStops) throws IOException {
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

            String temp = "";
            GetPath(inFrom, inTo, maxStops);
            if (thePath.isEmpty()) {
                temp = "No route can be found within " + maxStops + " stops!";
            } else {
                for (int i = 0; i < thePath.size(); i++) {
                    if (i == thePath.size() - 1) {
                        temp += thePath.get(i);
                    } else {
                        temp += thePath.get(i) + "->";
                    }
                }
            }
            System.out.println(temp);
//            int stps = GetStops(inFrom, inTo);
//            String temp = "";
//            if (stps == -1) {
//                temp = "Impossible to get there! ";
//            } else if (stps == 0) {
//                temp = "Non-stop flights to get there!";
//            } else {
//                temp = "Have to make " + stps + " stop(s) to get there!";
//            }
//            System.out.println(temp);
        }
    }

    /**
     * Find the shortest path between From and To, 
     * @param from
     * @param to
     * @param maxLength find the routes without making more than the number of stops. 
     */
    static void GetPath(String from, String to, int maxLength) {
        if (been.contains(from) || !graph.containsKey(from) || PathMarker.size() > maxLength) {
            return;
        }
        been.add(from);
        PathMarker.add(from);
        if (graph.get(from).contains(to)) {
            PathMarker.add(to);
            if (thePath.isEmpty() || PathMarker.size() < thePath.size()) {
                thePath = (ArrayList<String>) PathMarker.clone();
            }
            PathMarker.remove(to);
        } else {
            graph.get(from).forEach(t -> GetPath(t, to, maxLength));
        }
        been.remove(from);
        PathMarker.remove(from);
    }
}
