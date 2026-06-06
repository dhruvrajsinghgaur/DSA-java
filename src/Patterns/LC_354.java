package Patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        List<Integer> lis = new ArrayList<>();

        for (int i = 0; i < envelopes.length; i++) {
            int h = envelopes[i][1];
            if (lis.isEmpty() || h > lis.getLast()) lis.add(h);
            else {
                int index = binarySearch(lis, h);
                lis.set(index, h);
            }
        }
        return  lis.size();
    }
    public int binarySearch(List<Integer> lis, int value) {
        int left = 0;
        int right = lis.size() - 1;

        while(left <= right) {
            int mid = left + (right - left)/2;

            if (lis.get(mid) == value) return mid;

            else if (lis.get(mid) < value) left = mid + 1;

            else right = mid - 1;
        }
        return left;
    }

    void main(String[] args) {

        int[][] envelopes = {
                {5,4},
                {6,4},
                {6,7},
                {2,3}
        };
        System.out.println(maxEnvelopes(envelopes));
    }
}
