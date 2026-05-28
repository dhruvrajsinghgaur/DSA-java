package Patterns.TwoPointer;
import java.util.*;

public class LC_15 {
    // bruteForce sol. gives TLE on leetCode.
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        Set<List<Integer>> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (i == j || j == k || k == i) continue;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);

                        Collections.sort(temp);

                        hash.add(temp);
                    }
                }
            }
        }
        answers.addAll(hash);
        return answers;
    }

    public static List<List<Integer>> threeSum2(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> answers = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    Collections.sort(temp);
                    set.add(temp);
                    left++;
                    right--;
                }

                else if (sum < 0){
                    left++;
                }
                else if (sum > 0){
                    right--;
                }
            }
        }
        answers.addAll(set);
        return answers;
    }


        public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> answers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    answers.add(temp);
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }

                else if (sum < 0){
                    left++;
                }
                else if (sum > 0){
                    right--;
                }
            }
        }
        return answers;
    }

    public void twoSum(int[] nums){
        for (int i = 0; i < nums.length; i++) {

        }
    }
    public static void main(String[] args){
        int[] arr = {-100,-70,-60,110,120,130,160};
        System.out.println(threeSum(arr));
    }
// Time Complexity: O(n²) — outer loop O(n) × two pointer O(n)
// Space Complexity: O(1) — no extra space (threeSum)
//                  O(n) — HashSet used  (threeSum2)

}
