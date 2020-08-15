package in.samratc.main.topInterviewQuesLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length, sum = 0;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < n - 2; i++){
            if( i == 0 || nums[i] != nums[i - 1]){
                int lo = i + 1, hi = n - 1;
                while(lo < hi){
                    int curr = nums[i] + nums[lo] + nums[hi];
                    if(curr == sum){
                        ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while(lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while(lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++; hi--;
                    } else if(curr < sum)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        return ans;
    }

	/*						 0		1		2		3		4		5
				nums 		-4 		-1		-1		0		1		2
				i		lo		hi		curr
				1		4		3		0

				ans = [
							[-1, -1, 2],
							[-1, 0, 1]
						]
	*/
}
