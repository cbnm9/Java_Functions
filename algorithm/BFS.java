package algorithm;

import java.util.LinkedList;
import java.util.Queue;

/*

BFS 는 그래프의 모든 노드를을 탐색하는 알고리즘으로
한 노드의 모든 인접 노드를 탐색한 다음 다음 노드로 넘어가는 방식으로 탐색한다.

1. 모든 노드를 큐에 넣는다
2. 큐에서 노드를 하나씩 꺼내며 탐색한다
3. 이 때 큐에서 꺼낸 노드의 모든 인접노드를 큐에 넣는다

그래프를 2차원 배열로 표현하는 방법
int idx[][];

   0   1   2   3   4   5

0  0   1   1   0   1   0

1  1   0   1   0   0   1

2  1   1   0   1   1   0

3  0   0   1   0   1   1

4  1   0   1   1   0   1

5  0   1   0   1   1   0

idx[1][2] == 1 이면 1번 노드와 2번 노드는 이어져 있는 것
무방향에서는 idx[1][2] == idx[2][1]

*/

public class BFS {

	// a 는 그래프를 2차원 배열로 만든 것
	// c 는 방문 표시
	// v 는 노드 번호
	public static void bfs(int[][] a, boolean[] c, int v) {
		// 큐 생성
		Queue<Integer> q = new LinkedList<>();
		// 아래 for 문을 위해 반복 제어 변수 만들기
		int n = a.length - 1;
		// q 에 시작 노드 번호 넣기
		q.add(v);
		// 시작 노드는 q에 넣었으므로 탐색 상태를 True 로 변경
		c[v] = true;
		// q가 빌 때 까지 반복
		while (!q.isEmpty()) {
			// q에 있는 다음에 탐색할 노드번호 꺼내기
			v = q.poll();
			// 노드 번호 출력
			System.out.print(v + " ");
			// 방금 꺼낸 노드의 모든 인접노드 탐색
			for (int i = 1; i <= n; i++) {
				// 방금 꺼낸 노드의 인접노드이며, 아직 탐색하지 않았다면
				if (a[v][i] == 1 && !c[i]) {
					// 큐에 넣고, 탐색 상태를 True 로 변경
					q.add(i);
					c[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
