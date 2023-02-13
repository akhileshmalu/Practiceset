package Graphs;

import java.util.*;

/**
 * @author: Akhilesh Maloo
 * @date: 10/15/17.
 */
public class Graph {

    private int V;
    LinkedList<Integer>[] adjacency;

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
     *
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
                if (DFSUtilPath(n, dest, visited)) return true;
        }

        return false;

    }

    /**
     * DFS Driver method
     *
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
     *
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


    boolean detectCycle(int k) {

        return detectCyCleDFS(k, new HashSet<Integer>(), new HashSet<Integer>());
    }

    boolean detectCyCleDFS(int k, HashSet<Integer> visited, HashSet<Integer> current) {

        visited.add(k);
        current.add(k);

        for (int i = 0; i < adjacency[k].size(); i++) {

            int tmp = adjacency[k].get(i);
            if(!visited.contains(tmp) && detectCyCleDFS(tmp, visited, current)) {
                return true;
            } else {
                if(current.contains(tmp))
                    return true;
            }

        }
        current.remove(k);
        return false;
    }

    /**
     * for clone graph purpose
     */
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
      }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        return helper(node, new HashMap<Integer, UndirectedGraphNode>());
    }
    public UndirectedGraphNode helper(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
        if(map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node.label, clone);
        for(int i = 0; i < node.neighbors.size(); i++) {
            clone.neighbors.add(helper(node.neighbors.get(i), map));
        }
        return clone;
    }


    private int maxDiffer() {

        HashSet<Integer> visited = new HashSet<>();
        int pot = 0;

        for (int i = 0; i < V; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            pot = Math.max(pot, dfs(i, min, max, 0, visited));
        }

        return pot;
    }

    private int dfs(int n, int min, int max, int pot, HashSet<Integer> visited) {

        if(visited.contains(n))
            return pot;

        visited.add(n);
        min = Math.min(min,n);
        max = Math.max(max,n);
        pot = max - min;

        for(int i = 0; i < adjacency[n].size(); i++) {
            if(!visited.contains(adjacency[n].get(i))) {
                pot = Math.max(pot, dfs(adjacency[n].get(i), min, max, pot, visited));
            }
        }
        return pot;

    }


    public static void main(String[] args) {

        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
//        g.addEdge(3, 4);
        g.addEdge(4, 3);


        ;

        System.out.println(g.hasPath2(0, 3));
        //
        // 0 -> 1 -> (2)
        // 0 - 1 - 3 - 4
    }

    boolean hasPath2(int src, int dest) {
        LinkedList<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        q.add(src);
        visited[src] = true;

        Iterator<Integer> iterator = q.iterator();
        while(iterator.hasNext()) {
            Integer pop = q.poll();
            if(pop != null && pop == dest) {
                return true;
            }
            for (Integer con : adjacency[pop]) {
                if(!visited[con]) {
                    q.add(con);
                }
            }
        }
        return false;
    }

    boolean DFS2(int src, int dest, boolean[] visited) {
        visited[src] = true;
        if(src == dest) {
            return true;
        }
        for (Integer con : adjacency[src]) {
            if(!visited[con] && DFS2(con, dest, visited)) {
                return true;
            }
        }
        return false;
    }




}
