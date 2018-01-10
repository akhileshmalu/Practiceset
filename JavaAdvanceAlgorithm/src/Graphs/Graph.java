package Graphs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: Akhilesh Maloo
 * @date: 10/15/17.
 */
public class Graph {

    private int V;
    LinkedList<Integer> adjacency[];

    Graph(int vertex) {
        this.V = vertex;
        adjacency = new LinkedList[vertex];

        for (int i = 0; i < vertex; ++i)
            adjacency[i] = new LinkedList();
    }


    public void addEdge(int source, int destination) {
        // add edge
        adjacency[source].add(destination);
    }

    /*
    public static void printGraph(Node node) {
        for (int i = 0; i < node.id; i++) {
            System.out.println("Adjacency List of Vertex " + i);
            System.out.print(" Head ");

            for (Integer val : node.adjacency[i]) {
                System.out.print(" -> " + val);
            }
            System.out.println();
        }
    }*/

    /*public static boolean depthFirstSearch(Node node, int source, int dest) {


        HashSet<Integer> visited = new HashSet<>();


        return hasPathDFS(node.adjacency[source], source, dest, visited);


    }

    private static boolean hasPathDFS(LinkedList adj, int source, int dest, HashSet<Integer> visited) {
        if (visited.contains(source)) {
            return false;
        }

        visited.add(source);

        if (source == dest) {
            return true;
        }


        for (int i = 0; i < adj.size(); i++) {
            if (hasPathDFS(head.adjacency[i], adj.getFirst(), dest, visited)) {

            }
        }


    }
    */


    /**
     * If there is any Path from src node to dest node using DFS
     * @param src
     * @param dest
     * @return
     */
    public boolean hasPath(int src, int dest) {
        boolean visited[] = new boolean[V];

        return DFSUtilPath(src, dest, visited);
    }

    public boolean DFSUtilPath(int src, int dest, boolean[] visited) {
        if (visited[src])
            return false;

        visited[src] = true;
        if (src == dest) {
            return true;
        }
        Iterator<Integer> i = adjacency[src].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                if(DFSUtilPath(n, dest, visited)) return true;
        }

        return false;

    }

    /**
     * DFS Driver method
     * @param v
     */
    void DFS(int v) {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        for (int i = 0; i < V; ++i)
            if (!visited[i])
                DFSUtil(i, visited);
    }
    /**
     * Traverse Depth First Search
     * @param v
     * @param visited
     */
    void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adjacency[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }


    public static void main(String[] args) {

        Graph g = new Graph(4);

        g.addEdge(0, 2);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
//        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal " +
                "(starting from vertex 2)");

        System.out.println(g.hasPath(2, 3));
//        g.DFS(2);

    }

}
