//给你一个字符串 word 和一个整数 numFriends。 
//
// Alice 正在为她的 numFriends 位朋友组织一个游戏。游戏分为多个回合，在每一回合中： 
//
// 
// word 被分割成 numFriends 个 非空 字符串，且该分割方式与之前的任意回合所采用的都 不完全相同 。 
// 所有分割出的字符串都会被放入一个盒子中。 
// 
//
// 在所有回合结束后，找出盒子中 字典序最大的 字符串。 
//
// 
//
// 示例 1： 
//
// 
// 输入: word = "dbca", numFriends = 2 
// 
//
// 输出: "dbc" 
//
// 解释: 
//
// 所有可能的分割方式为： 
//
// 
// "d" 和 "bca"。 
// "db" 和 "ca"。 
// "dbc" 和 "a"。 
// 
//
// 示例 2： 
//
// 
// 输入: word = "gggg", numFriends = 4 
// 
//
// 输出: "g" 
//
// 解释: 
//
// 唯一可能的分割方式为："g", "g", "g", 和 "g"。 
//
// 
//
// 提示: 
//
// 
// 1 <= word.length <= 5 * 10³ 
// word 仅由小写英文字母组成。 
// 1 <= numFriends <= word.length 
// 
//
// Related Topics 双指针 字符串 枚举 👍 19 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 从盒子中找出字典序最大的字符串 I
 * @author zhuo
 * @date 2025-06-04 11:58:53
 */
public class FindTheLexicographicallyLargestStringFromTheBoxI {
	
	public static void main(String[] args) {
		Solution solution = new FindTheLexicographicallyLargestStringFromTheBoxI().new Solution();
		System.out.println(solution.answerString("bif", 2));
	}
	
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public String answerString(String word, int numFriends) {
			if (numFriends == 1) {
				return word;
			}
			char[] chars = word.toCharArray();
			char maxChar = chars[0];
			int wl = word.length();
			int size = wl - numFriends + 1;
			String rs = "";
			for (int i = 0; i < chars.length; i++) {
				int min = Math.min(i + size, wl);
				String substring = word.substring(i, min);
				if (chars[i] > maxChar) {
					rs = substring;
					maxChar = chars[i];
				} else if (chars[i] == maxChar) {
					rs = rs.compareTo(substring) > 0 ? rs : substring;
				}
			}
			return rs;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}