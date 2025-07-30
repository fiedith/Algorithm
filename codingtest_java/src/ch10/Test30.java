package ch10;

import java.util.ArrayList;
import java.util.List;

public class Test30 {

    private static int[] set = new int[]{2, 1, 1, 1, 3, 3, 6, 6, 4, 6, 3, 6, 9, 9};

    // find root node
    private static int find(int x){
        int parent = set[x];
        if(parent != x){
            parent = find(parent);
        }
        set[x] = parent;    // path compression
        return parent;
    }

    private static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        set[xRoot] = yRoot;
    }

    public static Boolean[] solution(int[][] operations){
        List<Boolean> result = new ArrayList<>();
        for (int[] operation : operations) {
            switch(operation[0]){
                case 0:
                    union(operation[1], operation[2]);
                    break;
                case 1:
                    int xRoot = find(operation[1]);
                    int yRoot = find(operation[2]);
                    result.add(xRoot == yRoot);
                    break;
            }
        }

        return result.toArray(new Boolean[0]);
    }
}
