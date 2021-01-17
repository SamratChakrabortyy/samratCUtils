package in.samratc.main.intuit;

public class FirstMissingPosetive {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 1;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            while(nums[i] >= 1 && nums[i] <= n && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] != i+1)
                return i+1;
        }
        return n+1;
    }

    public static  void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}
