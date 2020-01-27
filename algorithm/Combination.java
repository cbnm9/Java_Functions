package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Combination {

	// nCr (n개 중 r개를 선택하는 조합) 을 구하는 함수
	// 출처 : https://www.baeldung.com/java-combinations-algorithm
	public static List<int[]> get_combinations(int n, int r) {
		// 모든 combination 을 담을 리스트
		List<int[]> combinations = new ArrayList<>();
		// 각 combination 은 0 ~ (n - 1) 의 값을 가지는 r 개의 숫자 조합
		int[] combination = new int[r];

		// initialize with lowest lexicographic combination
		// 가장 낮은 숫자 조합의 combination 만들기
		// lexicographic : 사전 식 (구글 번역기)
		for (int i = 0; i < r; i++) {
			combination[i] = i;
		}

		// combination 의 가장 마지막 값이 n 보다 작은 동안 반복
		while (combination[r - 1] < n) {
			// 현재 만들어져 있는 combination 을 리스트에 추가
			combinations.add(combination.clone());

			// generate next combination in lexicographic order
			// 다음 순서의 combination 만들기
			// 먼저 t 변수를 통해 현재 combination 의 마지막 값을 가리키기
			int t = r - 1;
			// t가 0이 아니고 combination[t] 가 n - r + t 와 같다면 t 감소
			// n - r + t 는 combination 의 t 자리에서 가질 수 있는 최대 값
			// 즉, 이미 최대값을 가졌다면 t 를 그 이전을 가리키게 수정하기
			while (t != 0 && combination[t] == n - r + t) {
				t--;
			}
			// 위에서 설정된 t 위치의 combination 값 하나 증가시키기
			// 즉, t 위치의 combination 값이 최대가 될 때 까지 증가하게 됨
			// 이때 위치 t 는 마지막 위치에서부터 하나씩 앞으로 이동
			// 이로인해 생성되는 combinations 는 정렬된 순서를 가지게 생성됨
			combination[t]++;
			// (t + 1 ~ 마지막) combination 값을 이전 위치의 combination 값에 1을 더한 값으로 대체
			// t 위치의 값이 증가되었을 때 t + 1 위치의 값은 t 위치의 값 보다 커야한다(중복을 허용하지 않음)
			// 이러한 (x 위치의 값) < (x + 1 위치의 값) 은 combination 내 모든 위치에서 적용된다.
			for (int i = t + 1; i < r; i++) {
				combination[i] = combination[i - 1] + 1;
			}
		}

		// 만들어진 combination 리스트 반환
		return combinations;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		List<int[]> combinations = get_combinations(N, R);
		for (int[] combination : combinations) {
			bw.write(Arrays.toString(combination) + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
