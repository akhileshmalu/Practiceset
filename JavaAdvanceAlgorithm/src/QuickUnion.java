/**
 * @author: Akhilesh Maloo
 * @date: 8/30/17.
 *
 * Union Find Algorithm in efficiency {Path Compression}
 *
 * Comparison:  Pushing     Find      Union
 *  Quick-Find       n        n           1
 *  Quick-Union      n        n           n (worst case one sided tree)
 *  WeighQU with PC  n      log n       log n
 *
 */
public class QuickUnion {

    private int[] nodes = new int[10];

    private int[] sizeTree = new int[10];

    public QuickUnion(int n) {
        for(int i=0; i<n; i++) {
            this.nodes[i] = i;
            this.sizeTree[i] = 1;
        }
    }

    /*
     * Quick-Find
    public boolean isConnected(int firstNode, int secNode) {
          return (this.nodes[firstNode] == this.nodes[secNode]);
    }

    public void union(int firstNode, int secNode ) {
        int check = this.nodes[firstNode];
        for(int i=0; i< this.nodes.length; i++) {
            if(this.nodes[i] == check) {
                this.nodes[i] = secNode;
            }
        }
    }
     */

    /** Data Structure : Array with Tree; node contains other containing node number
    * Quick-Union
    public boolean isConnected(int firstNode, int secNode) {

        return (root(this.nodes[firstNode]) == root(this.nodes[secNode]));
    }

    public int root(int node) {
        while(this.nodes[node] != node) {
            node = this.nodes[node];
        }
        return node;
    }

    public void union(int firstNode, int secNode) {
        this.nodes[root(this.nodes[firstNode])] = root(this.nodes[secNode]);

    }
    */

    // Data Structure : Array with Tree; node contains other containing node number
    // Weighted-QUnion with Path Compression
    public boolean isConnected(int firstNode, int secNode) {

        return (root(this.nodes[firstNode]) == root(this.nodes[secNode]));
    }

    public int root(int node) {
        while(this.nodes[node] != node) {

            this.nodes[node] = this.nodes[this.nodes[node]];    //path compression
            node = this.nodes[node];
        }
        return node;
    }

    public void union(int firstNode, int secNode) {
        int rootA = root(this.nodes[firstNode]);
        int rootB = root(this.nodes[secNode]);

        // Balancing the tree depending upon is size of root
        if(sizeTree[rootA] > sizeTree[rootB]) {
            this.nodes[rootB] = rootA;
            sizeTree[rootA] += sizeTree[rootB];
        } else {
            this.nodes[rootA] = rootB;
            sizeTree[rootB] += sizeTree[rootA];
        }

    }


    public static void main(String[] args) {

        QuickUnion qu = new QuickUnion(9);

        qu.union(2,3);

        for (int node: qu.nodes) {
            System.out.print(node+" ");

        }
        System.out.println();

        qu.union(3,4);
        qu.union(4,5);
        qu.union(3,0);
        qu.union(7,2);
//        qu.union(2,5);
        for (int node: qu.nodes) {
            System.out.print(node+" ");

        }
        System.out.println(qu.isConnected(0,5));

    }

}
