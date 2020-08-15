package in.samratc.main.topInterviewQuesLeetcode;


// https://leetcode.com/problems/sort-colors/
public class SortColors {
    public void sortColors(int[] nums) {
        int zPos = 0, oPos = 0, tPos = nums.length - 1;
        while (zPos <= oPos && oPos <= tPos) {
            if (nums[oPos] == 0) {
                if (zPos < oPos)
                    swap(nums, oPos, zPos);
                else
                    oPos++;
                zPos++;
            } else if (nums[oPos] == 2) {
                if (oPos < tPos)
                    swap(nums, oPos, tPos);
                else
                    oPos++;
                tPos--;
            } else
                oPos++;
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
