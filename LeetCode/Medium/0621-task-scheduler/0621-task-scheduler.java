import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // max heap
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        /* queue to keep finished tasks in cooldown */
        Deque<int[]> q = new ArrayDeque<>();    // {remaining tasks, time to get back to pq}

        // map to count all task frequencies
        Map<String, Integer> countMap = new HashMap<>();
        for(char ch : tasks) {
            String s = String.valueOf(ch);
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }

        // load frequency values to pq
        for(String key : countMap.keySet()) {
            pq.add(countMap.get(key));
        }

        int time = 0;

        while(!q.isEmpty() || !pq.isEmpty() ) {
            time++;

            // if next pollable task fulfilled cooldown time, restore back to pq
            if(!q.isEmpty() && q.peekFirst()[1] == time){
                int[] polled = q.pollFirst();
                pq.add(polled[0]);
            }

            // if task exists in pq
            if(!pq.isEmpty()) {
                int task = pq.poll();
                // no need to keep all finished tasks into cooldown queue
                if(task - 1 != 0) {
                    q.addLast(new int[]{task - 1, time + n + 1});   // this task can be ran again at (time + n + 1) time
                }
                
            }
        }

        return time;
        // 1. max-heap 활용해 각 task별 frequency 저장
        // 2. 공용 time 변수 활용 (init = 0)
        // 3. 큐 활용해 <다시 heap에 저장될 작업 잔여량, 다시 heap에 저장될 time값> 저장
        // 4. init - max heap에서 값 꺼내고, <값-- (=다시 저장될 잔여량), (time값 + interval값)> 을 큐에 저장.
        // 5. 매 반복마다 time값 증가하고, 큐 바닥의 (time값 + interval값)과 비교해서 동일하면 꺼내고, 잔여량을 max heap에 저장,
        //    그리고 max heap에서 값 꺼내서 (4)를 반복.
        //    이때 큐에 꺼낸 값이 0인 경우 max heap에 저장하지 않음.
    }
}