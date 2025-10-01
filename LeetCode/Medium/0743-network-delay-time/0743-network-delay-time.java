class Solution {
    private class Node{
        int dest;
        int cost;

        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        // init minCost arr
        final int INF = 987654321;
        int[] minCost = new int[n + 1];     // 1-based arr
        Arrays.fill(minCost, INF);
        minCost[k] = 0;     // set starting node cost

        // K: src node number, V: list<node>
        Map<Integer, List<Node>> map = new HashMap<>();
        // time[src, dest, cost]
        for(int[] time : times){
            List<Node> list = map.getOrDefault(time[0], new ArrayList<>());
            list.add(new Node(time[1], time[2]));
            map.put(time[0], list);
        }

        Deque<int[]> q = new ArrayDeque<>();
        List<Node> startingAdjNodes = map.getOrDefault(k, new ArrayList<>());
        // fast return
        if(startingAdjNodes.isEmpty()){
            return -1;
        }

        // init q
        for(Node node : startingAdjNodes){
            q.addLast(new int[]{node.dest, node.cost});    // int[dest no, cost]
        }

        while(!q.isEmpty()){
            int[] arr = q.pollFirst();
            int now = arr[0];
            int cost = arr[1];
            if(cost < minCost[now]){
                minCost[now] = cost;
            }
            if(map.containsKey(now)){
                for(Node next : map.get(now)){
                    if(next.cost + minCost[now] < minCost[next.dest]){
                        q.addLast(new int[]{next.dest, next.cost + minCost[now]});
                    }
                }
            }
        }

        int result = 0;
        for(int i = 1; i < n + 1; i++){
            // if any val is INF, cannot visit all nodes
            if(minCost[i] == INF){
                return -1;
            }
            // the max cost required to reach any node will be the minimum time
            result = Math.max(result, minCost[i]);
        }

        return result;
    }
}