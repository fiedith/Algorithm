class Solution {

    private static boolean isMergable(int[] triplet, int[] target){
        // if any element in triplet is larger than of target's, cannot merge
        for(int i = 0; i < 3; i++){
            if(triplet[i] > target[i]){
                return false;
            }
        }

        // if not returned above, return can merge
        return true;
    }

    public static boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] updated = new int[3];

        for(int[] triplet : triplets){
            // merge two triplets if mergable
            if(isMergable(triplet, target)){
                for(int i = 0; i < 3; i++){
                    updated[i] = Math.max(updated[i], triplet[i]);
                }

                // after merging, check if target is found
                if(Arrays.equals(target, updated)){
                    return true;
                }
            }
        }

        // if not found true above, return false
        return false;
    }
}