import java.util.*;

class Solution {
    
    private static class Info{
        int sheep, wolf, number;
        Set<Integer> choices;   // 현재 노드에서 다음으로 이동 가능한 노드들
        
        Info(int sheep, int wolf, int number, Set<Integer> choices){
            this.sheep = sheep;
            this.wolf = wolf;
            this.number = number;
            this.choices = choices;   
        }
    }
    
    public static int solution(int[] info, int[][] edges) {
        int answer = 1;
        Deque<Info> q = new ArrayDeque<>();
        
        // 0번 = root
        List<Integer>[] tree = new List[info.length];
        for(int i = 0; i < tree.length; i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            int parent = edge[0];
            tree[parent].add(edge[1]);
        }
        
        q.addLast(new Info(1, 0, 0, new HashSet<>()));

        while(!q.isEmpty()){
            Info current = q.pollFirst();
            answer = Math.max(current.sheep, answer);
            current.choices.addAll(tree[current.number]);
            
            for(int next : current.choices){
                Set<Integer> updatedChoices = new HashSet<>(current.choices);
                updatedChoices.remove(next);
                
                // wolf인 경우 이동 가능한지 먼저 확인
                if(info[next] == 1 && current.sheep != current.wolf + 1){
                    q.addLast(new Info(current.sheep, current.wolf + 1, next, updatedChoices));
                } else if(info[next] == 0){
                    q.addLast(new Info(current.sheep + 1, current.wolf, next, updatedChoices));
                }
            }
        }
        
        return answer;
    }
    
    
}