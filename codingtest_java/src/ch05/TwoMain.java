package ch05;

import java.util.Arrays;

public class TwoMain {
    public static void main(String[] args) {
        int[] input = {2, 1, 1, -1, 3, 2, 5, 4};
        System.out.println(Arrays.toString(TwoAsStream.solution(input)));
        System.out.println(Arrays.toString(TwoAsTreeSet.solution(input)));

    }

}
