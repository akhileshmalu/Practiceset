package Graphs;

import javafx.util.Pair;

import java.util.*;

/**
 * @author: Akhilesh Maloo
 * @date: 5/1/20.
 */
public class LargestCommonNeighbour {

    public static void main(String args[]) {

        int[][] arr = {
                {1, 1, 1, 2, 1},
                {2, 2, 3, 2, 3},
                {1, 1, 3, 3, 3}
        } ;

        new LargestCommonNeighbour().findLargestNeighbouringColor(arr);
    }

    private void findLargestNeighbouringColor(int[][] arr) {
        Map<Integer, Integer> map = new HashMap();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        Stack<Pair<Integer, Integer>> stack = new Stack<>();

        stack.push(new Pair<>(0,0));

        while(!stack.isEmpty()) {
            Pair<Integer, Integer> pos = stack.pop();

            if(visited.contains(pos))
                continue;

            visited.add(pos);
            int next = arr[(int)pos.getKey()][(int)pos.getValue()];
            System.out.print(next + " ");

            boolean sameAsPrevItem = false;
            List<Pair<Integer, Integer>> neighbours = findNeighbours(pos, arr);
            for(Pair<Integer, Integer> neighbour : neighbours) {

                int temp = arr[(int)neighbour.getKey()][(int)neighbour.getValue()];
                if(next == temp)
                    sameAsPrevItem = true;

                if(!visited.contains(neighbour)) {
                    stack.push(neighbour);
                }
            }

            if(sameAsPrevItem) {
                map.put(next, (map.getOrDefault(next, 0) + 1));
            } else {
                map.put(next, 0);
            }
        }

        System.out.println(map);
    }

    private List<Pair<Integer, Integer>> findNeighbours(Pair pos, int[][] arr) {
        List<Pair<Integer, Integer>> result = new ArrayList<>();
        //left;
        if((int)pos.getKey() > 0) {
            result.add(new Pair((int)pos.getKey()-1, pos.getValue()));
        }
        // right
        if((int)pos.getKey() < arr.length-1) {
            result.add(new Pair((int)pos.getKey()+1, pos.getValue()));
        }

        //up;
        if((int)pos.getValue() > 0) {
            result.add(new Pair(pos.getKey(), (int)pos.getValue()-1));
        }
        // down
        if((int)pos.getValue() < arr[0].length-1) {
            result.add(new Pair(pos.getKey(), (int)pos.getValue()+1));
        }

        return result;
    }
}
