class Solution {

    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for(int i = 0; i < position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // position DESC
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
        
        Deque<Double> stack = new ArrayDeque<>();

        stack.push((double)(target - cars[0][0]) / cars[0][1]);

        for(int i = 1; i < cars.length; i++){
            // calculate each cars' time to reach target
            double time = (double)(target - cars[i][0]) / cars[i][1];
            // only push to stack if current top time is smaller than current time
            if(time > stack.peek()){
                stack.push(time);
            }
        }

        return stack.size();
    }
}