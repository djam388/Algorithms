package java_algorithms;

/**
 * You are given an array of integers nums. Return the length of the longest subarray of nums which is either
 * strictly increasing or strictly decreasing.
 * <p>
 * Example 1:
 * Input: nums = [1,4,3,3,2]
 * Output: 2
 * Explanation:
 * The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].
 * The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].
 * Hence, we return 2.
 * <p>
 * Example 2:
 * Input: nums = [3,3,3,3]
 * Output: 1
 * Explanation:
 * The strictly increasing subarrays of nums are [3], [3], [3], and [3].
 * The strictly decreasing subarrays of nums are [3], [3], [3], and [3].
 * Hence, we return 1.
 * <p>
 * Example 3:
 * Input: nums = [3,2,1]
 * Output: 3
 * Explanation:
 * The strictly increasing subarrays of nums are [3], [2], and [1].
 * The strictly decreasing subarrays of nums are [3], [2], [1], [3,2], [2,1], and [3,2,1].
 * Hence, we return 3.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 50
 * 1 <= nums[i] <= 50
 */
public class Homework6_2 {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 1) return 1;  // If there's only one element, return 1.

        int maxLen = 1;  // At least one element, hence start with 1.
        int currLen = 1;  // Current length of the monotonic subarray.
        Boolean increasing = null;  // Track direction of the subarray: null (not set), true (increasing), false (decreasing).

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {  // Current number is greater than the previous one.
                if (increasing == null || increasing) {  // If increasing or direction not set yet.
                    currLen++;  // Extend the subarray.
                    increasing = true;  // Confirm it's increasing.
                } else {
                    maxLen = Math.max(maxLen, currLen);  // Update maximum length found.
                    currLen = 2;  // Restart counting as new subarray starts.
                    increasing = true;  // Change direction to increasing.
                }
            } else if (nums[i] < nums[i - 1]) {  // Current number is less than the previous one.
                if (increasing == null || !increasing) {  // If decreasing or direction not set yet.
                    currLen++;  // Extend the subarray.
                    increasing = false;  // Confirm it's decreasing.
                } else {
                    maxLen = Math.max(maxLen, currLen);  // Update maximum length found.
                    currLen = 2;  // Restart counting as new subarray starts.
                    increasing = false;  // Change direction to decreasing.
                }
            } else {  // Current number is equal to the previous one.
                maxLen = Math.max(maxLen, currLen);  // Update maximum length found so far.
                currLen = 1;  // Reset, as equal values do not contribute to strictly increasing or decreasing.
                increasing = null;  // Reset the direction.
            }
        }

        return Math.max(maxLen, currLen);  // Return the maximum of maxLen or the last counted currLen.
    }
}
