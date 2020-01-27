import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Arrays_func {
	public static void print(String v) {
		System.out.println(v);
	}

	public static void print(int v) {
		System.out.println(v);
	}

	public static void print(List<Integer> l) {
		System.out.print("[ ");
		for (int i = 0; i < l.size(); i++) {
			System.out.print(l.get(i) + " ");
		}
		System.out.println("]");
	}

	public static void print(int[] arr) {
		System.out.print("[ ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("]");
	}

	public static void main(String args[]) throws Exception {
		int[] arr = { 1, 2, 4, 5, 6, 9 };

		// 이진탐색, 해당 값이 있는 인덱스 반환, 없는 값의 경우 음수 반환
		print(Arrays.binarySearch(arr, 6));
		print(Arrays.binarySearch(arr, 7));

		// 배열 복사
		// 1. 더 길게 복사, Default 값으로 채워짐
		print(Arrays.copyOf(arr, 10));

		// 2. 더 짧게 복사, 뒤에 값들은 제거됨
		print(Arrays.copyOf(arr, 3));

		// 배열 복사, 파이썬의 [a:b], 인덱스 b는 제외
		print(Arrays.copyOfRange(arr, 1, 4));

		// 배열을 문자열로 [1, 2, 3, 4] 형식 유지
		print(Arrays.toString(arr));

		// 여러 데이터들을 리스트로
		print(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

		// 배열을 특정 데이터로 채우기
		Arrays.fill(arr, 0);
		print(arr);

		// 정렬
		arr = new int[] { 1, 5, 2, 8, 4, 2 };

		Arrays.sort(arr);
		print(arr);

		// 특정 부분만 정렬 (arr, 1, 4) -> 4번 원소는 제외
		arr = new int[] { 1, 5, 2, 8, 4, 2 };

		Arrays.sort(arr, 1, 4);
		print(arr);

		// Comparator 를 사용한 내림차순 정렬
		// 1. int 배열을 Integer 배열로
		Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		// 2. 내림차순 정렬, Comparator 를 implements 한 클래스를 구현해서도 사용 가능
		Arrays.sort(arr2, Comparator.reverseOrder());
		// 3. Integer 배열을 다시 int 배열로 바꾸기
		arr = Arrays.stream(arr2).mapToInt(Integer::intValue).toArray();
		print(arr);
	}
}