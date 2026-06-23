//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 3273 👎 0


package leetcode.editor.cn;

import javax.print.DocFlavor;
import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * @author zhuo
 * @date 2026-06-22 06:44:10
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
	
	public static void main(String[] args) {
		Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
		System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 10}, 8)));
	}
	
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int[] searchRange(int[] nums, int target) {
			int[] res = new int[]{-1, -1};
			if (nums.length == 0) {
				return res;
			}
			int left = 0, right = nums.length - 1;
			while (left <= right) {
				if (nums[left] == target) {
					res[0] = left;
				}
				if (res[0] == -1) {
					left++;
				}
				if (nums[right] == target) {
					res[1] = right;
				}
				if (res[1] == -1) {
					right--;
				}
				if (res[0] != -1 && res[1] != -1) {
					break;
				}
			}
			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}