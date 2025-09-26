class Solution {

    private static int[] parent;

    private static int find(int x){
        int root = parent[x];
        // find root
        if(root != x){
            root = find(parent[root]);
        }
        parent[x] = root;     // path compression
        return root;
    }

    // passed args are already given as roots
    private static void union(int xRoot, int yRoot){
        parent[xRoot] = yRoot;
    }

    // edges length = n. nodes 1 ~ n.
    public int[] findRedundantConnection(int[][] edges) {
        // 1-based arr
        parent = new int[edges.length + 1];

        // init set
        for(int i = 0; i < parent.length; i++){
            // 1-based node numbers
            parent[i] = i;
        }

        int[] result = new int[2];

        for(int[] edge : edges){
            int parentRoot = find(edge[0]);
            int childRoot = find(edge[1]);

            // union nodes if roots are unlike
            if(parentRoot != childRoot){
                union(childRoot, parentRoot);
            // is a redundant connection if roots are identical
            } else{
                result = edge;
            }
        }

        return result;
    }
}