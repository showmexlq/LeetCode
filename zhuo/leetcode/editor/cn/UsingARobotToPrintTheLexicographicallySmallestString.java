//给你一个字符串 s 和一个机器人，机器人当前有一个空字符串 t 。执行以下操作之一，直到 s 和 t 都变成空字符串：
//
//
// 删除字符串 s 的 第一个 字符，并将该字符给机器人。机器人把这个字符添加到 t 的尾部。
// 删除字符串 t 的 最后一个 字符，并将该字符给机器人。机器人将该字符写到纸上。
//
//
// 请你返回纸上能写出的字典序最小的字符串。
//
//
//
// 示例 1：
//
// 输入：s = "zza"
//输出："azz"
//解释：用 p 表示写出来的字符串。
//一开始，p="" ，s="zza" ，t="" 。
//执行第一个操作三次，得到 p="" ，s="" ，t="zza" 。
//执行第二个操作三次，得到 p="azz" ，s="" ，t="" 。
//
//
// 示例 2：
//
// 输入：s = "bac"
//输出："abc"
//解释：用 p 表示写出来的字符串。
//执行第一个操作两次，得到 p="" ，s="c" ，t="ba" 。
//执行第二个操作两次，得到 p="ab" ，s="c" ，t="" 。
//执行第一个操作，得到 p="ab" ，s="" ，t="c" 。
//执行第二个操作，得到 p="abc" ，s="" ，t="" 。
//
//
// 示例 3：
//
// 输入：s = "bdda"
//输出："addb"
//解释：用 p 表示写出来的字符串。
//一开始，p="" ，s="bdda" ，t="" 。
//执行第一个操作四次，得到 p="" ，s="" ，t="bdda" 。
//执行第二个操作四次，得到 p="addb" ，s="" ，t="" 。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁵
// s 只包含小写英文字母。
//
//
// Related Topics 栈 贪心 哈希表 字符串 👍 73 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 使用机器人打印字典序最小的字符串
 * @author zhuo
 * @date 2025-06-06 07:34:47
 */
public class UsingARobotToPrintTheLexicographicallySmallestString {
	
	public static void main(String[] args) {
		Solution solution = new UsingARobotToPrintTheLexicographicallySmallestString().new Solution();
		System.out.println(solution.robotWithString("bbydizfve"));
//        hdgsafjhbda        sjhsgdh
	
	}
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		//不会，用的官方题解
		public String robotWithString(String s) {
			// 记录每个字符出现的次数
			int[] count = new int[26];
			for (int i = 0; i < s.length(); i++) {
				count[s.charAt(i) - 'a']++;
			}
			// 栈用于存储待打印的字符
			Stack<Character> stack = new Stack<>();
			StringBuilder sb = new StringBuilder();
			char minChar = 'a';
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				// 将当前字符入栈
				stack.push(c);
				// 更新最小字符
				minChar = (char) Math.min(minChar, c);
				// 减少当前字符的出现次数
				count[c - 'a']--;
				// 当最小字符的出现次数为0时，更新最小字符
				while (minChar != 'z' && count[ minChar- 'a'] == 0) {
					minChar++;
				}
				// 当栈顶字符小于等于最小字符时，将栈顶字符出栈并打印
				while (!stack.isEmpty() && stack.peek() <= minChar) {
					sb.append(stack.pop());
				}
	
			}
			
			return sb.toString();
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}