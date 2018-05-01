package question3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class RandomNum {

	public static void main(String[] args) {
		RandomNum rand = new RandomNum();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the lowerlimit for generating 500 randum numbers\n");
		int lowerlimit = keyboard.nextInt();
		System.out.println("Enter the upper limit for generating 500 randum numbers\n");
		int upperlimit = keyboard.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i <= 500; i++) {
			// Adding 500 randomly generated numbers to arraylist
			list.add(rand.rndRange(lowerlimit, upperlimit));

		}
		System.out.println("500 Randum numbers from " + lowerlimit + " to " + upperlimit + " are:");
		System.out.println(Arrays.toString(list.toArray()));

		Set<Integer> hs = new HashSet<Integer>();
		// Adding arralylist of 500 randomly generated to a HashSet to delete duplicates
		hs.addAll(list);
		System.out.println("\nOut of these 500 randum numbers below are unique numbers in sorted order\n");
		Iterator<Integer> it = hs.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + ", ");
		}

		System.out.println("\n\nPlease enter which smallet number do you want to find?\n");
		int k = keyboard.nextInt();
		if (k == 0 || k > hs.size())
			System.out.println("Your searched for invalid index");
		else
			System.out.print(k + "th smallest element is " + kthSmallest(hs, k));

	}

	public int rndRange(int start, int finish) {

		return (new Random().nextInt(finish + 1 - start) + start);
	}

	public static int kthSmallest(Set<Integer> hs, int k) {

		ArrayList<Integer> sortedList = new ArrayList<Integer>(hs);
		Collections.sort(sortedList);
		return sortedList.get(k - 1);
	}

}
