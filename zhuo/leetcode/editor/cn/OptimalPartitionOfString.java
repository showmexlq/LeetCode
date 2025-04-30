//给你一个字符串 s ，请你将该字符串划分成一个或多个 子字符串 ，并满足每个子字符串中的字符都是 唯一 的。也就是说，在单个子字符串中，字母的出现次数都不超
//过 一次 。 
//
// 满足题目要求的情况下，返回 最少 需要划分多少个子字符串。 
//
// 注意，划分后，原字符串中的每个字符都应该恰好属于一个子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abacaba"
//输出：4
//解释：
//两种可行的划分方法分别是 ("a","ba","cab","a") 和 ("ab","a","ca","ba") 。
//可以证明最少需要划分 4 个子字符串。
// 
//
// 示例 2： 
//
// 
//输入：s = "ssssss"
//输出：6
//解释：
//只存在一种可行的划分方法 ("s","s","s","s","s","s") 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 字符串 👍 37 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 子字符串的最优划分
 * @author zhuo
 * @date 2025-04-29 14:01:49
 */
public class OptimalPartitionOfString {
	
	public static void main(String[] args) {
		Solution solution = new OptimalPartitionOfString().new Solution();
		System.out.println(solution.partitionString("abacaba"));
	}
	
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int partitionString(String s) {
			Set<Character> set = new HashSet<>();
			int count = 0;
			for (char c : s.toCharArray()) {
				if (set.contains(c)) {
					System.out.println(Arrays.toString(set.toArray()));
					set.clear();
					count++;
				}
				set.add(c);
			}
			return count + 1;
		}
	}
}