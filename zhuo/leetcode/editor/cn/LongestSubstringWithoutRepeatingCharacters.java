//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 10795 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 无重复字符的最长子串
 * @author zhuo
 * @date 2025-04-29 12:18:00
 */
public class LongestSubstringWithoutRepeatingCharacters {
	
	public static void main(String[] args) {
		Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
		solution.lengthOfLongestSubstring("pwwkew");
	}
	
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int lengthOfLongestSubstring(String s) {
			int max = 0;
			HashMap<Character, Integer> chs = new HashMap<>();
			int left = 0;
			for (int i = 0; i < s.length(); i++) {
				char key = s.charAt(i);
				chs.put(key, chs.getOrDefault(key, 0) + 1);
				while (chs.get(key) > 1) {
					char keyl = s.charAt(left);
					chs.put(keyl, chs.getOrDefault(keyl, 0) - 1);
					left++;
				}
				max = Math.max(max, i - left + 1);
			}
			
			return max;
		}
	}
	
}