//n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。 
//
// 你需要按照以下要求，给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 相邻两个孩子评分更高的孩子会获得更多的糖果。 
// 
//
// 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。 
//
// 
//
// 示例 1： 
//
// 
//输入：ratings = [1,0,2]
//输出：5
//解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2： 
//
// 
//输入：ratings = [1,2,2]
//输出：4
//解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。 
//
// 
//
// 提示： 
//
// 
// n == ratings.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= ratings[i] <= 2 * 10⁴ 
// 
//
// Related Topics 贪心 数组 👍 1663 👎 0


package leetcode.editor.cn;

/**
 * 分发糖果
 * @author zhuo
 * @date 2025-06-02 09:05:01
 */
public class Candy {
	
	public static void main(String[] args) {
		Solution solution = new Candy().new Solution();
		System.out.println(solution.candy(new int[]{1, 3, 2, 2, 1}));
	}
	
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int candy(int[] ratings) {
			int[] candy = new int[ratings.length];
			int sum = 0;
			candy[0] = 1;
			// 从左往右遍历一遍，从右往左遍历一遍，取最大值, 保证相邻的两个孩子评分更高的孩子会获得更多的糖果。
			for (int i = 1; i < ratings.length; i++) {
				if (ratings[i] > ratings[i - 1]) {
					candy[i] = candy[i - 1] + 1;
				} else {
					candy[i] = 1;
				}
			}
			// 从右往左遍历一遍，取最大值, 保证相邻的两个孩子评分更高的孩子会获得更多的糖果。
			for (int i = ratings.length - 2; i >= 0; i--) {
				if (ratings[i] > ratings[i + 1]) {
					candy[i] = Math.max(candy[i], candy[i + 1] + 1);
				}
			}
			for (int i : candy) {
				sum += i;
			}
			return sum;
			
		}
		
		public int candy1(int[] ratings) {
			//错误解法        System.out.println(solution.candy1(new int[]{1, 3, 2, 2, 1}));
			int sum = 0;
			int minIndex = 0;
			for (int i = 0; i < ratings.length; i++) {
				if (ratings[i] < ratings[minIndex]) {
					minIndex = i;
				}
			}
			int left = minIndex - 1;
			int right = minIndex + 1;
			int[] candy = new int[ratings.length];
			candy[minIndex] = 1;
			while (left >= 0 || right <= ratings.length - 1) {
				
				
				if (left != -1) {
					if (ratings[left] > ratings[left + 1]) {
						candy[left] = candy[left + 1] + 1;
					} else {
						candy[left] = 1;
					}
					left--;
				}
				if (right != ratings.length) {
					if (ratings[right] > ratings[right - 1]) {
						candy[right] = candy[right - 1] + 1;
					} else {
						candy[right] = 1;
					}
					right++;
				}
			}
			for (int i : candy) {
				sum += i;
			}
			return sum;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}