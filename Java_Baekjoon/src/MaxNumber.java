/*Need Refactoring*/

import java.util.*;

public class MaxNumber {

	public static void main(String[] args) {
		int[] test_case = {3, 30, 34, 5, 9};
		int[] test_case1 = {6, 10, 2};
		int[] test_case2 = {0, 0, 0};
		System.out.println(Solution(test_case));
		System.out.println(Solution(test_case1));
		System.out.println(Solution(test_case2));

	}
	
	public static boolean MaxNumber(String pivot, String element) {
		if (pivot.length() == element.length()) {
			return Integer.parseInt(pivot) <= Integer.parseInt(element);
		} else {
			return Integer.parseInt(pivot + element) <= Integer.parseInt(element + pivot);
		}
	}
	
	public static ArrayList<String> QuickSort(ArrayList<String> arr) {
		if (arr.size() <= 1) {
			return arr;
		} else {
			String pivot = arr.get(0);
			ArrayList<String> front = new ArrayList<String>();
			ArrayList<String> end = new ArrayList<String>();
			ArrayList<String> result = new ArrayList<String>();
			for (String a : arr.subList(1, arr.size())) {
				if (MaxNumber(pivot, a)) {
					front.add(a);
				}else {
					end.add(a);
				}
			}	
				front = QuickSort(front);
				end = QuickSort(end);
				front.add(pivot); // ArrayList append
				front.addAll(end);
				return front;
		}
	}
	
	public static String Solution(int[] numbers) {
		String answer = "";
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int n : numbers) {
			set.add(n);
		}
		if (set.size() == 1) {
			return "0";
		} else {
			ArrayList<String> conv_string = new ArrayList<String>();
			for (int a :numbers) {
				conv_string.add(Integer.toString(a));
			}
			conv_string = QuickSort(conv_string);
			answer = String.join("",conv_string); // Array to String
			return answer;
		} 
		
		
	}

}
