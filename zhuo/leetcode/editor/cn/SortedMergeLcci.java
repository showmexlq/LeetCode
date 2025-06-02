//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。 
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。 
//
// 示例： 
//
// 
//输入：
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出： [1,2,2,3,5,6] 
//
// 说明： 
//
// 
// A.length == n + m 
// 
//
// Related Topics 数组 双指针 排序 👍 184 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 合并排序的数组
 * @author zhuo
 * @date 2025-04-30 13:55:24
 */
public class SortedMergeLcci {
	
	public static void main(String[] args) {
		Solution solution = new SortedMergeLcci().new Solution();
		int[] a = {1};
		solution.merge(a, 1, new int[]{}, 0);
		System.out.println(Arrays.toString(a));
		int[] b = {2, 0};
		solution.merge(b, 1, new int[]{1}, 1);
		System.out.println(Arrays.toString(b));
	}
	
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public void merge(int[] A, int m, int[] B, int n) {
			int pa = m - 1, pb = n - 1;
			int tail = m + n - 1;
			int cur;
			while (pa >= 0 || pb >= 0) {
				if (pa == -1) {
					cur = B[pb--];
				} else if (pb == -1) {
					cur = A[pa--];
				} else if (A[pa] > B[pb]) {
					cur = A[pa--];
				} else {
					cur = B[pb--];
				}
				A[tail--] = cur;
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}