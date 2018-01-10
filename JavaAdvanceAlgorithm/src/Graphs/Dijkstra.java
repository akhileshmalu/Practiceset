package Graphs;

import java.util.Arrays;

/**
 * @author: Akhilesh Maloo
 * @date: 11/2/17.
 */
public class Dijkstra {

    public static final int V = 9;


    public int minDistance( int[] dist, boolean[] vis) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = 0; i<V; i++){
            if(!vis[i] && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public int[] shortestPath(int[][] graph, int srcIndex){

        int[] shtDis = new int[V];
        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++)
            shtDis[i] = Integer.MAX_VALUE;

        // distance to itself is zero
        shtDis[srcIndex] = 0;

        for(int u = 0; u < V; u++) {

            int minIndex = minDistance(shtDis, visited);
            visited[minIndex] = true;

            for(int i = 0; i< V; i++){

                if(!visited[i] && graph[minIndex][i] > 0 && shtDis[minIndex] + graph[minIndex][i] < shtDis[i] ) {
                    //shtDis[i] = Math.min(shtDis[i], shtDis[minIndex] + graph[minIndex][i]);
                    shtDis[i] = shtDis[minIndex] + graph[minIndex][i];
                }
            }
        }


        Arrays.stream(shtDis).forEach(t -> {System.out.print(t + " ");});
        return shtDis;


    }



    public static void main(String[] args) {

        Dijkstra dk = new Dijkstra();

        int[][] graph = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };


        dk.shortestPath(graph,0);


    }
}
