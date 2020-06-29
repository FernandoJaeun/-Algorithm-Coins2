package Coin2;

import java.util.Scanner;

public class Coin2 {

	static Scanner scanner = new Scanner(System.in);
	private static int n;
	private static int k;
	private static int result;
	private static int[] coins;

	public static void main(String[] args) {
		System.out.print("동전의 개수를 입력하세요 : ");
		n = setValue();

		System.out.println("동전의 가치를 입력하세요 : ");
		coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = setValue();
		}
		coins = getSortInDescendingOrder(coins);

		System.out.print("동전 가치의 합을 입력하세요 : ");
		k = setValue();

		System.out.println(getMinimum(coins, k));
	}

//	값을 지정하는 메소드
	public static int setValue() {

		return scanner.nextInt();
	}

//  배열을 내림차순으로 정렬하는 메소드
	public static int[] getSortInDescendingOrder(int[] arr) {
		int swap = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					swap = arr[i];
					arr[i] = arr[j];
					arr[j] = swap;
				}
			}
		}
		return arr;
	}

//	최소 개수를 산출하는 메소드
	public static int getMinimum(int[] arr, int value) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (value >= arr[i]) {
				value -= arr[i];
				count++;
				i--;
			}
		}
		return count;
	}
}
