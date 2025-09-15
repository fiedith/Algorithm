class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // early returns
        if(hand.length % groupSize != 0){
            return false;
        }

        if(groupSize == 1){
            return true;
        }

        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : hand){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // for all nums in hand, 
        for(int num : hand){
            // if num quantity > 0, set that num as the starting num of straight (num ~ num + groupSize-1)
            if(map.get(num) > 0){
                for(int i = num; i < num + groupSize; i++){
                    // if any following nums' quantity = 0, straight is impossible
                    if(map.getOrDefault(i, 0) == 0){
                        return false;
                    }
                    // else, reduce the quantity
                    map.put(i, map.get(i) - 1);
                }
            }
        }

        // if not returned in loop, true
        return true;
    }
}