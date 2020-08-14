package in.samratc.main.topInterviewQuesLeetcode;
//https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
public class RotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1, pivot = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] > nums[n-1])
                l = mid + 1;
            else{
                pivot = mid;
                r = mid - 1;
            }
        }
        l = pivot; r = n - 1 + pivot;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid % n] < target)
                l = mid + 1;
            else if(nums[mid % n] > target)
                r = mid - 1;
            else
                return mid % n;
        }
        return -1;
    }
}