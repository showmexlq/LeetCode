//给你一个整数数组 nums 和一个 正整数 k 。 
//
// 请你统计有多少满足 「 nums 中的 最大 元素」至少出现 k 次的子数组，并返回满足这一条件的子数组的数目。 
//
// 子数组是数组中的一个连续元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,2,3,3], k = 2
//输出：6
//解释：包含元素 3 至少 2 次的子数组为：[1,3,2,3]、[1,3,2,3,3]、[3,2,3]、[3,2,3,3]、[2,3,3] 和 [3,3] 
//。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,4,2,1], k = 3
//输出：0
//解释：没有子数组包含元素 4 至少 3 次。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 1 <= k <= 10⁵ 
// 
//
// Related Topics 数组 滑动窗口 👍 66 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 统计最大元素出现至少 K 次的子数组
 * @author zhuo
 * @date 2025-04-29 09:00:06
 */
public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
	
	public static void main(String[] args) {
		Solution solution = new CountSubarraysWhereMaxElementAppearsAtLeastKTimes().new Solution();
		solution.countSubarrays(new int[]{1, 3, 2, 3, 3}, 2);
		solution.countSubarrays(new int[]{1, 4, 2, 1}, 3);
	}
	
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public long countSubarrays2(int[] nums, int k) {
			long count = 0;
			int l = 0, r = 0;
			//计算数组中最大元素
			int max = 0;
			for (int num : nums) {
				if (num > max) {
					max = num;
				}
			}
			//当前窗口内数量
			int current = 0;
			int length = nums.length;
			while (l < length) {
				while (r < length) {
					if (nums[r] == max) {
						current += 1;
					}
					if (current >= k) {
						count += length - r;
						break;
					}
					r++;
				}
				
				if (nums[l] == max) {
					current -= 1;
				}
				if (r < length && nums[r] == max) {
					current -= 1;
				} else {
					break;
				}
				l++;
//                if (l== r) {
//                    break;
//                }
			}
			return count;
		}
		
		
		//官方题解
		public long countSubarrays(int[] nums, int k) {
			int mx = Arrays.stream(nums).max().getAsInt();
			long ans = 0;
			int cnt = 0, left = 0;
			for (int x : nums) {
				if (x == mx) {
					cnt++;
				}
				while (cnt == k) {
					if (nums[left] == mx) {
						cnt--;
					}
					left++;
				}
				ans += left;
			}
			return ans;
		}
		
	}
//leetcode submit region end(Prohibit modification and deletion)

}