//给你一个字符串 s，找到 s 中最长的 回文 子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 7676 👎 0


package leetcode.editor.cn;

/**
 * 最长回文子串
 * @author zhuo
 * @date 2025-04-30 10:21:30
 */
public class LongestPalindromicSubstring {
	
	public static void main(String[] args) {
		Solution solution = new LongestPalindromicSubstring().new Solution();
		System.out.println(solution.longestPalindrome("xaabacxcabaaxcabaax"));
	}
	
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
        //暴力解法未完成
		public String longestPalindrome2(String s) {
			String res = "";
			int max = 0;
			char[] ca = s.toCharArray();
			for (int i = 0; i < ca.length; i++) {
				int l = i, r = s.length() - 1;
				int cur = 0;
                //下面是判断回文的方法，从两边往中间判断，如果两边的字符相等，就继续往中间判断，如果不相等，就把l和r都往中间移动一位，然后继续判断
                //中间应该还有一层循环。
				while (l < r) {
					if (ca[l] == ca[r]) {
						cur += 2;
						l++;
						r--;
					} else {
						cur = 0;
						if (l == i) {
							r--;
						} else {
							l = i;
                            r=Math.min(r+1, s.length()-1);
						}
					}
				}
				if (l == r) {
					cur++;
				}
				if (cur > max) {
					max = cur;
					res = s.substring(i, i + cur);
				}
			}
			return res;
		}
		
		// 中心扩展法
		public String longestPalindrome(String s) {
			String res = "";
			int max = 0;
			char[] ca = s.toCharArray();
			for (int i = 0; i < ca.length; i++) {
				// 中心扩展法，分别处理奇数长度和偶数长度的回文
				String odd = expandAroundCenter(s, i, i); // 奇数长度
				String even = expandAroundCenter(s, i, i + 1); // 偶数长度
				
				// 更新最长回文子串
				if (odd.length() > max) {
					max = odd.length();
					res = odd;
				}
				if (even.length() > max) {
					max = even.length();
					res = even;
				}
			}
			return res;
		}
		
		private String expandAroundCenter(String s, int left, int right) {
			// 从中心向两边扩展，判断是否为回文子串
            // 注意边界条件，避免越界
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}
			// 返回当前回文子串
			return s.substring(left + 1, right);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}