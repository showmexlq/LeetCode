//给你一个由 正 整数组成的数组 nums 。 
//
// 如果数组中的某个子数组满足下述条件，则称之为 完全子数组 ： 
//
// 
// 子数组中 不同 元素的数目等于整个数组不同元素的数目。 
// 
//
// 返回数组中 完全子数组 的数目。 
//
// 子数组 是数组中的一个连续非空序列。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,3,1,2,2]
//输出：4
//解释：完全子数组有：[1,3,1,2]、[1,3,1,2,2]、[3,1,2] 和 [3,1,2,2] 。
// 
//
// 示例 2： 
//
// 输入：nums = [5,5,5,5]
//输出：10
//解释：数组仅由整数 5 组成，所以任意子数组都满足完全子数组的条件。子数组的总数为 10 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 2000 
// 
//
// Related Topics 数组 哈希表 滑动窗口 👍 68 👎 0


package leetcode.editor.cn;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.*;

/**
 * 统计完全子数组的数目
 * @author zhuo
 * @date 2025-04-24 10:34:09
 */
public class CountCompleteSubarraysInAnArray {
	
	public static void main(String[] args) {
		Solution solution = new CountCompleteSubarraysInAnArray().new Solution();
		System.out.println(solution.countCompleteSubarrays(new int[]{1, 3, 1, 2, 2}));
	}
	
	class Solution {
		// 计算数组中完全子数组的数量
		//TODO 官方解法,待完成
		public int countCompleteSubarrays(int[] nums) {
			// 初始化结果
			int res = 0;
			// 使用哈希表记录每个元素出现的次数
			Map<Integer, Integer> cnt = new HashMap<>();
			// 获取数组的长度
			int n = nums.length;
			// 初始化右指针
			int right = 0;
			// 获取数组中不同元素的个数
			int distinct = new HashSet<>(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new))).size();
			
			// 遍历数组
			for (int left = 0; left < n; left++) {
				// 如果左指针大于0，则将左指针指向的元素从哈希表中移除
				if (left > 0) {
					int remove = nums[left - 1];
					cnt.put(remove, cnt.get(remove) - 1);
					// 如果哈希表中该元素的个数为0，则将其移除
					if (cnt.get(remove) == 0) {
						cnt.remove(remove);
					}
				}
				// 当右指针小于数组长度且哈希表中不同元素的个数小于数组中不同元素的个数时，将右指针指向的元素加入哈希表
				while (right < n && cnt.size() < distinct) {
					int add = nums[right];
					cnt.put(add, cnt.getOrDefault(add, 0) + 1);
					right++;
				}
				// 如果哈希表中不同元素的个数等于数组中不同元素的个数，则将结果加上数组长度减去右指针加1
				if (cnt.size() == distinct) {
					res += (n - right + 1);
				}
			}
			return res;
		}
	}
}