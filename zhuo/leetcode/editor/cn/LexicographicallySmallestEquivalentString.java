//给出长度相同的两个字符串s1 和 s2 ，还有一个字符串 baseStr 。 
//
// 其中 s1[i] 和 s2[i] 是一组等价字符。 
//
// 
// 举个例子，如果 s1 = "abc" 且 s2 = "cde"，那么就有 'a' == 'c', 'b' == 'd', 'c' == 'e'。 
// 
//
// 等价字符遵循任何等价关系的一般规则： 
//
// 
// 自反性 ：'a' == 'a' 
// 对称性 ：'a' == 'b' 则必定有 'b' == 'a' 
// 传递性 ：'a' == 'b' 且 'b' == 'c' 就表明 'a' == 'c' 
// 
//
// 例如， s1 = "abc" 和 s2 = "cde" 的等价信息和之前的例子一样，那么 baseStr = "eed" , "acd" 或 "aab"，
//这三个字符串都是等价的，而 "aab" 是 baseStr 的按字典序最小的等价字符串 
//
// 利用 s1 和 s2 的等价信息，找出并返回 baseStr 的按字典序排列最小的等价字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "parker", s2 = "morris", baseStr = "parser"
//输出："makkek"
//解释：根据 A 和 B 中的等价信息，我们可以将这些字符分为 [m,p], [a,o], [k,r,s], [e,i] 共 4 组。每组中的字符都是等价的，
//并按字典序排列。所以答案是 "makkek"。
// 
//
// 示例 2： 
//
// 
//输入：s1 = "hello", s2 = "world", baseStr = "hold"
//输出："hdld"
//解释：根据 A 和 B 中的等价信息，我们可以将这些字符分为 [h,w], [d,e,o], [l,r] 共 3 组。所以只有 S 中的第二个字符 'o' 
//变成 'd'，最后答案为 "hdld"。
// 
//
// 示例 3： 
//
// 
//输入：s1 = "leetcode", s2 = "programs", baseStr = "sourcecode"
//输出："aauaaaaada"
//解释：我们可以把 A 和 B 中的等价字符分为 [a,o,e,r,s,c], [l,p], [g,t] 和 [d,m] 共 4 组，因此 S 中除了 
//'u' 和 'd' 之外的所有字母都转化成了 'a'，最后答案为 "aauaaaaada"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length, baseStr <= 1000 
// s1.length == s2.length 
// 字符串s1, s2, and baseStr 仅由从 'a' 到 'z' 的小写英文字母组成。 
// 
//
// Related Topics 并查集 字符串 👍 60 👎 0


package leetcode.editor.cn;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * 按字典序排列最小的等效字符串
 * @author zhuo
 * @date 2025-06-05 09:04:21
 */
public class LexicographicallySmallestEquivalentString {
	
	public static void main(String[] args) {
		Solution solution = new LexicographicallySmallestEquivalentString().new Solution();
		System.out.println(solution.smallestEquivalentString("gmerjboftfnqseogigpdnlocmmhskigdtednfnjtlcrdpcjkbj", "fnnafafhqkitbcdlkpiloiienikjiikdfcafisejgeldprcmhd", "ezrqfyguivmybqcsvibuvtajdvamcdjpmgcbvieegpyzdcypcx"));
	}
	
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		//官方题解
		public String smallestEquivalentString(String s1, String s2, String baseStr) {
			UnionFind uf = new UnionFind(26);
			for (int i = 0; i < s1.length(); i++) {
				uf.unite(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
			}
			
			StringBuilder sb = new StringBuilder();
			for (char c : baseStr.toCharArray()) {
				sb.append((char) ('a' + uf.find(c - 'a')));
			}
			return sb.toString();
		}
		
		public String smallestEquivalentString2(String s1, String s2, String baseStr) {
			TreeSet<Character> characters = new TreeSet<>();
//			Set<Character> group = new TreeSet<>();
			ArrayList<Set<Character>> list = new ArrayList<>();
			for (int i = 0; i < s1.length(); i++) {
				char c1 = s1.charAt(i);
				char c2 = s2.charAt(i);
				if (characters.contains(c1) || characters.contains(c2)) {
					boolean flag = false;
					int index1 = -1;
					for (int j = 0; j < list.size(); j++) {
						Set<Character> set = list.get(j);
						if (set.contains(c1) || set.contains(c2)) {
							if (!flag) {
								set.add(c1);
								set.add(c2);
								flag = true;
								index1 = j;
							} else {
								//合并两个set
								set.addAll(list.get(index1));
								list.remove(index1);
							}
						}
					}
				} else {
					TreeSet<Character> tempGroup = new TreeSet<>();
					tempGroup.add(c1);
					tempGroup.add(c2);
					list.add(tempGroup);
				}
				characters.add(c1);
				characters.add(c2);
			}
			StringBuilder sb = new StringBuilder();
			for (char c : baseStr.toCharArray()) {
				if (characters.contains(c)) {
					for (Set<Character> set : list) {
						if (set.contains(c)) {
							//取第一个元素
							sb.append(set.stream().findFirst().get());
							break;
						}
					}
				} else {
					sb.append(c);
				}
			}
			
			return sb.toString();
		}
	}
	
	//leetcode submit region end(Prohibit modification and deletion)
	class UnionFind {
		int[] parent;
		
		UnionFind(int n) {
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
		}
		
		int find(int x) {
			if (parent[x] != x) {
				parent[x] = find(parent[x]);
			}
			return parent[x];
		}
		
		void unite(int x, int y) {
			x = find(x);
			y = find(y);
			if (x == y) return;
			if (x > y) {
				int temp = x;
				x = y;
				y = temp;
			}
			// 总是让字典序更小的作为集合代表字符
			parent[y] = x;
		}
	}
	
	
}