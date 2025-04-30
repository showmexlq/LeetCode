//给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。 
//
// 炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，其中 bombs[i] = [xi, yi, ri] 。xi 和 yi 表示第 i 个炸弹的 
//X 和 Y 坐标，ri 表示爆炸范围的 半径 。 
//
// 你需要选择引爆 一个 炸弹。当这个炸弹被引爆时，所有 在它爆炸范围内的炸弹都会被引爆，这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。 
//
// 给你数组 bombs ，请你返回在引爆 一个 炸弹的前提下，最多 能引爆的炸弹数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：bombs = [[2,1,3],[6,1,4]]
//输出：2
//解释：
//上图展示了 2 个炸弹的位置和爆炸范围。
//如果我们引爆左边的炸弹，右边的炸弹不会被影响。
//但如果我们引爆右边的炸弹，两个炸弹都会爆炸。
//所以最多能引爆的炸弹数目是 max(1, 2) = 2 。
// 
//
// 示例 2： 
//
// 
//
// 输入：bombs = [[1,1,5],[10,10,5]]
//输出：1
//解释：
//引爆任意一个炸弹都不会引爆另一个炸弹。所以最多能引爆的炸弹数目为 1 。
// 
//
// 示例 3： 
//
// 
//
// 输入：bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
//输出：5
//解释：
//最佳引爆炸弹为炸弹 0 ，因为：
//- 炸弹 0 引爆炸弹 1 和 2 。红色圆表示炸弹 0 的爆炸范围。
//- 炸弹 2 引爆炸弹 3 。蓝色圆表示炸弹 2 的爆炸范围。
//- 炸弹 3 引爆炸弹 4 。绿色圆表示炸弹 3 的爆炸范围。
//所以总共有 5 个炸弹被引爆。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= bombs.length <= 100 
// bombs[i].length == 3 
// 1 <= xi, yi, ri <= 10⁵ 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 几何 数组 数学 👍 116 👎 0


package leetcode.editor.cn;

import com.sun.xml.internal.ws.server.ServerRtException;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 引爆最多的炸弹
 * @author zhuo
 * @date 2025-04-23 10:51:32
 */
public class DetonateTheMaximumBombs {
	
	public static void main(String[] args) {
		Solution solution = new DetonateTheMaximumBombs().new Solution();
		//[1,1,100000],[100000,100000,1]
		System.out.println(solution.maximumDetonation(new int[][]{{1, 1, 100000}, {100000, 100000, 1}}));
		System.out.println(solution.maximumDetonation(new int[][]{{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}}));
	}
	
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int maximumDetonation(int[][] bombs) {
			int length = bombs.length;
			boolean[][] explodedView = new boolean[length][length];
			int max = 1;
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					if (i != j) {
						long dx = bombs[j][0] - bombs[i][0];
						long dy = bombs[j][1] - bombs[i][1];
						long dr = bombs[i][2];
						explodedView[i][j] = dx * dx + dy * dy <= dr * dr;
					}
				}
			}
			for (int i = 0; i < length; i++) {
				boolean[] visited = new boolean[length];
				max = Math.max(max, dfsStack(explodedView, i, visited));
			}
			
			return max;
		}
		
		/**
		 * DFS
		 * @param explodedView 爆炸视图
		 * @param i 我
		 * @param visited 访问
		 * @return int
		 */
		public int dfs(boolean[][] explodedView, int i, boolean[] visited) {
			int count = 1;
			visited[i] = true;
			boolean[] booleans = explodedView[i];
			for (int j = 0; j < booleans.length; j++) {
				if (booleans[j] && !visited[j]) {
					count += dfs(explodedView, j, visited);
				}
			}
			return count;
		}
		
		public int bfs(boolean[][] explodedView, int i, boolean[] visited) {
			int count = 0;
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(i);
			visited[i] = true;
			while (!queue.isEmpty()) {
				Integer poll = queue.poll();
				count++;
				for (int j = 0; j < explodedView[0].length; j++) {
					if (explodedView[poll][j] && !visited[j]) {
						queue.offer(j);
						visited[j] = true;
					}
					
				}
			}
			
			return count;
		}
		
		public int dfsStack(boolean[][] explodedView, int i, boolean[] visited) {
			int count = 0;
			visited[i] = true;
			Stack<Integer> stack = new Stack<>();
			stack.push(i);
			visited[i] = true;
			while (!stack.isEmpty()) {
				Integer poll = stack.pop();
				count++;
				for (int j = 0; j < explodedView[0].length; j++) {
					if (explodedView[poll][j] && !visited[j]) {
						stack.push(j);
						visited[j] = true;
					}
					
				}
			}
			
			return count;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}