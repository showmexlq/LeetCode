//在一排多米诺骨牌中，tops[i] 和 bottoms[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。（一个多米诺是两个从 1 到 6 的数字同列
//平铺形成的 —— 该平铺的每一半上都有一个数字。） 
//
// 我们可以旋转第 i 张多米诺，使得 tops[i] 和 bottoms[i] 的值交换。 
//
// 返回能使 tops 中所有值或者 bottoms 中所有值都相同的最小旋转次数。 
//
// 如果无法做到，返回 -1. 
//
// 
//
// 示例 1： 
// 
// 
//输入：tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
//输出：2
//解释： 
//图一表示：在我们旋转之前， tops 和 bottoms 给出的多米诺牌。 
//如果我们旋转第二个和第四个多米诺骨牌，我们可以使上面一行中的每个值都等于 2，如图二所示。 
// 
//
// 示例 2： 
//
// 
//输入：tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
//输出：-1
//解释： 在这种情况下，不可能旋转多米诺牌使一行的值相等。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= tops.length <= 2 * 10⁴ 
// bottoms.length == tops.length 
// 1 <= tops[i], bottoms[i] <= 6 
// 
//
// Related Topics 贪心 数组 👍 147 👎 0


package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 行相等的最少多米诺旋转
 * @author zhuo
 * @date 2025-05-03 14:40:36
 */
public class MinimumDominoRotationsForEqualRow {
	
	public static void main(String[] args) {
		Solution solution = new MinimumDominoRotationsForEqualRow().new Solution();
		System.out.println(solution.minDominoRotations(new int[]{2, 2, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}));
	}
	
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int minDominoRotations(int[] tops, int[] bottoms) {
			int length = tops.length;
			int count = 0;
			int same = 0;
			Map<Integer, Integer> treeMap = new HashMap<>();
			for (int i = 0; i < length; i++) {
				treeMap.put(tops[i], treeMap.getOrDefault(tops[i], 0) + 1);
				treeMap.put(bottoms[i], treeMap.getOrDefault(bottoms[i], 0) + 1);
			}
			int maxFreq = 0;
			int maxNum = 0;
			for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
				if (entry.getValue() > maxFreq) {
					maxFreq = entry.getValue();
					maxNum = entry.getKey();
				}
			}
			
			if (maxFreq < length) {
				return -1;
			}
			for (int i = 0; i < length; i++) {
				int top = tops[i];
				int bottom = bottoms[i];
				if (top != maxNum && bottom != maxNum) {
					return -1;
				} else if (top == maxNum && bottom == maxNum) {
					same++;
				} else if (top == maxNum) {
					count++;
				}
			}
			return Math.min(count, length - count - same);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}