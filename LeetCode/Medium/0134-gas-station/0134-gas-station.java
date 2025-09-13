class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int initTotal = 0;

        // init
        int[] data = new int[gas.length];
        for(int i = 0; i < gas.length; i++){
            data[i] = gas[i] - cost[i];
            initTotal += data[i];
        }

        // before looping through elements, guarantee the result index existance
        if(initTotal < 0){
            return -1;
        }

        int idx = 0;
        int sum = 0;
        for(int i = 0; i < gas.length; i++){
            // if moving to next idx will sum up to negative, reset starting point & sum
            if(sum + data[i] < 0){
                idx = i + 1;
                sum = 0;
            } else{
                sum += data[i];     // accumulate sum if possible
            }

        }
        
        return idx;
    }
}