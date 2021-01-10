package in.samratc.main.session2;

public class MedianOfTwoSortedArray {
    public static void main(String... args){
		System.out.println(new MedianOfTwoSortedArray().findMedianSortedArrays(new int[]{}, new int[]{}));
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double ans = 0;
		int n = nums1.length, m = nums2.length, med1 = (n + m) / 2, med2 = med1 - 1, i = 0, j = 0, k = 0;
		boolean isEven = ((n + m) & 1) == 0;
		while(i < n && j < m){
			int curr = 0;
			if(nums1[i] < nums2[j]){
				curr = nums1[i];
				i++;
			} else {
				curr = nums2[j];
				j++;
			}
			if(isEven && k == med2)
				ans += curr;
			if(k == med1){
				ans += curr;
				break;
			}
			k++;
		}
		return isEven ? ans / 2.0 : ans;
    }
}