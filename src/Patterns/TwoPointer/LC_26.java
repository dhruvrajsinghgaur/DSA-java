package Patterns.TwoPointer;

public class LC_26 {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        int index = 1;
        while (right < nums.length){
            if (nums[left] == nums[right]){
                right++;
            }
            else {
                nums[index] = nums[right];
                index++;
                left = right;
                right = left + 1;
            }
        }
        return index;
    }

    void main(){
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));
    }
}
