package ch08;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Test18 {

    public static boolean solution(int[] arr, int target) {

        int currentTarget = 0;
        Set<Integer> set = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toSet());

        for(int num : arr){
            currentTarget = target - num;
            if (set.contains(currentTarget)) {
                return true;
            }
        }

        return false;
    }

}
