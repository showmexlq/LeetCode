//某班级考试成绩按非严格递增顺序记录于整数数组 scores，请返回目标成绩 target 的出现次数。 
//
// 
//
// 示例 1： 
//
// 
//输入: scores = [2, 2, 3, 4, 4, 4, 5, 6, 6, 8], target = 4
//输出: 3 
//
// 示例 2： 
//
// 
//输入: scores = [1, 2, 3, 5, 7, 9], target = 6
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= scores.length <= 10⁵ 
// -10⁹ <= scores[i] <= 10⁹ 
// scores 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode.cn/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
//
// 
//
// Related Topics 数组 二分查找 👍 464 👎 0


package leetcode.editor.cn;

/**
 * 统计目标成绩的出现次数
 * @author zhuo
 * @date 2026-06-22 06:38:58
 */
public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
	
	public static void main(String[] args) {
		Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
	}
	
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int countTarget(int[] scores, int target) {
			int res = 0;
			for (int score : scores) {
				if (score > target) {
					break;
				} else if (score == target) {
					res++;
				}
			}
			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}