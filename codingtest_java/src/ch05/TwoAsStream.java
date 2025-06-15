package ch05;

import java.util.Arrays;

public class TwoAsStream {

    public static int[] solution(int[] arr) {
        Integer[] result = Arrays.stream(arr)
                .boxed()  // box primitive array into wrapper
                .distinct()    // remove duplicates
                .toArray(Integer[]::new);

        // descending order
        Arrays.sort(result, (a, b) -> b - a);

        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}
