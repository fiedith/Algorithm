/**
 * opt: PQ + visited[]
 */
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Set<Integer> visited = new HashSet<>(); // use set to add visited nodes -> this is required to count number of nodes visited

        // K: from, V: [to, cost]
        Map<Integer, List<int[]>> map = new HashMap<>();

        // time[src node, dest node, cost]
        for(int[] time : times){
            List<int[]> list = map.getOrDefault(time[0], new ArrayList<>());
            list.add(new int[]{time[1], time[2]});
            map.put(time[0], list);
        }


        // elements: int[node no., cost]
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));     // min heap

        pq.add(new int[]{k, 0});

        int result = 0;
        while(!pq.isEmpty()){
            int[] polled = pq.poll();
            int node = polled[0];
            int cost = polled[1];
            // pq always guarantees least cost -> all visited nodes are init with shortest path
            if(visited.contains(node)){
                continue;
            }
            visited.add(node);
            result = Math.max(result, cost);

            List<int[]> adj = map.getOrDefault(node, new ArrayList<>());
            for(int[] next : adj){
                // only add unvisited adj nodes
                if(!visited.contains(next[0])){
                    pq.add(new int[]{next[0], cost + next[1]});
                }
            }
        }

        // if all nodes are visited, return result else -1
        return visited.size() == n ? result : -1;
    }
}