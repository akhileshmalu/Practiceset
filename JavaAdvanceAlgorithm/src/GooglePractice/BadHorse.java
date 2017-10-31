package GooglePractice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: Akhilesh Maloo
 * @date: 10/17/17.
 */
public class BadHorse {

    private int V;
    private int[][] adjacencyMatrix;
    private HashMap<String, Integer> members = new HashMap<>();

    public void createGraph(Scanner in) {

        int rivalries = Integer.parseInt(in.nextLine());
        String[] pair = new String[rivalries];

        //assign all unique members
        for (int k = 0; k < rivalries; k++) {
            pair[k] = in.nextLine();
           for(String name : (pair[k]).split(" ")) {
               if(!members.containsKey(name))
                   members.put(name,members.size());
           }
        }

        V = members.size();
        adjacencyMatrix = new int[V][V];

        for (int k = 0; k < rivalries; k++) {
            String[] riv = pair[k].split(" ");
            addEdge(riv[0],riv[1]);
        }
    }

    public void addEdge(String first, String sec) {
        adjacencyMatrix[members.get(first)][members.get(sec)] = 1;
        adjacencyMatrix[members.get(sec)][members.get(first)] = 1;
    }

    public boolean isBiPartite() {

        int[] color = new int[V];

        for(int i = 0; i < V; i++)
            color[i] = -1;

        for (int i = 0; i< V; i++) {
            if(color[i] == -1) {
                if(!biPartiteUtil(i,color))
                    return false;
            }
        }
        return true;

    }


    public boolean biPartiteUtil(int src, int[] colors) {

        colors[src] = 1;

        LinkedList<Integer> q = new LinkedList<>();

        q.add(src);

        while(!q.isEmpty()) {

            int u = q.getFirst();
            q.pop();

            if(adjacencyMatrix[u][u] == 1) {
                return false;
            }

            for (int v=0; v< V; v++) {

                if(adjacencyMatrix[u][v] == 1 && colors[v] == -1) {
                    colors[v] = 1-colors[u];
                    q.push(v);
                } else if(adjacencyMatrix[u][v] == 1 && colors[v] == colors[u])
                    return false;

            }
        }
        return true;

    }




    public static void showConflict(int i, Scanner in) {
        // Start your code of problem from here
        HashSet<String> g1 = new HashSet<>();
        HashSet<String> g2 = new HashSet<>();
        HashMap<String, HashSet<String>> gang = new HashMap<>();

        int rivalries = Integer.parseInt(in.nextLine());
        boolean fight = false;
        String[] pairs = new String[rivalries];
        HashMap<String, Integer> weakPair = new HashMap<>();

        //separating input process so that reiteration is possible
        for (int k = 0; k < pairs.length; k++) {
            pairs[k] = in.nextLine();
        }
        int k = 0;


        while (rivalries > 0) {

            String[] rivals = pairs[k++].split(" ");

            for (int m = 0; m < rivals.length; m++) {

                String first = rivals[m];
                String second = rivals[(m == 0) ? 1 : 0];

                if (!gang.containsKey(first)) {

                    //weak pair; would require extra attention to deal
                    if (k != 1 && !g1.contains(first) && !g2.contains(first) && !g1.contains(second) && !g2.contains(second)) {
                        weakPair.put(first, k - 1);
                    }

                    if (!g1.contains(second)) {
                        g1.add(first);
                        gang.put(first, g1);
                    } else if (!g2.contains(second)) {
                        g2.add(first);
                        gang.put(first, g2);
                    }


                } else {
                    if (gang.get(first).contains(second)) {
                        if (weakPair.containsKey(second)) {
                            String[] splitter = pairs[weakPair.get(second)].split(" ");
                            pairs[weakPair.get(second)] = splitter[1] + " " + splitter[0];

                            //exchange items
                            HashSet<String> g12 = gang.get(splitter[1]);
                            HashSet<String> g13 = gang.get(splitter[0]);

                            g12.add(splitter[0]);
                            g13.add(splitter[1]);
                            g12.remove(splitter[1]);
                            g13.remove(splitter[0]);

                            gang.put(splitter[1], g13);
                            gang.put(splitter[0], g12);
                            weakPair.remove(second);

                            rivalries = pairs.length + 1;
                            k = 0;
                            break;


                        } else if (weakPair.containsKey(first)) {
                            String[] splitter = pairs[weakPair.get(first)].split(" ");
                            pairs[weakPair.get(first)] = splitter[1] + " " + splitter[0];

                            HashSet<String> g12 = gang.get(splitter[1]);
                            HashSet<String> g13 = gang.get(splitter[0]);

                            g12.add(splitter[0]);
                            g13.add(splitter[1]);
                            g12.remove(splitter[1]);
                            g13.remove(splitter[0]);

                            gang.put(splitter[1], g13);
                            gang.put(splitter[0], g12);
                            weakPair.remove(first);

                            rivalries = pairs.length + 1;
                            k = 0;
                            break;


                        } else {
                            fight = true;
                            break;
                        }

                    }
                }

            }

            rivalries--;
        }
        System.out.print("Case #" + i + ": ");
        System.out.println((fight) ? "No" : "Yes");

    }

    public static void main(String[] args) {

        BadHorse bh = new BadHorse();

        Scanner in = new Scanner(System.in);
        int tests = Integer.parseInt(in.nextLine());

        for (int i = 1; i <= tests; i++) {

            bh.createGraph(in);
            System.out.print("Case #" + i + ": ");
            System.out.println(bh.isBiPartite() ? "Yes" : "No");
//            showConflict(i,in);
        }

        in.close();

    }
}

