public class Splitarray {
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 10, 8};
        int m = 2; // Number of subarrays
        int result = Split(arr, m);
        System.out.println("Minimum largest subarray sum: " + result);
    }
    static int Split(int[] arr, int m){
        int start =0;
        int end =0;
        for(int num : arr){
            start = Math.max(start,num);
            end += num;
        }
        while (start<end){
            int mid = start + (end - start)/2;
            int sum =0;
            int subarrays = 1;
            for(int num : arr){
                if(sum+num >mid){
                
                    sum = num;
                    subarrays++;

                }
                else{
                    sum+= num;
                }
            }
            if(subarrays > m){
                start = mid + 1; // We need a larger maximum subarray sum
            } else {
                end = mid; // We can try to minimize the maximum subarray sum
            }
        }

    return end;}
}
