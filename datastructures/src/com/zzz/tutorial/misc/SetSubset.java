package com.zzz.tutorial.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Print all the possible subsets of a given set
 *
 */
public class SetSubset {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(Arrays.asList(1, 2));
		ArrayList<ArrayList<Integer>> subsets = getSubsets2(list);
		printSubsets(subsets);
	}

	private static ArrayList<ArrayList<Integer>> subSets(ArrayList<Integer> set, int index) {

		ArrayList<ArrayList<Integer>> allSubsets;
		if (index == set.size()) {
			allSubsets = new ArrayList<ArrayList<Integer>>();
			allSubsets.add(new ArrayList<Integer>()); // Blank subset
		} else {
			allSubsets = subSets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allSubsets) {
				ArrayList<Integer> newSubset = new ArrayList<Integer>();
				newSubset.addAll(subset);
				newSubset.add(item);
				moreSubsets.add(newSubset);
			}
			allSubsets.addAll(moreSubsets);

		}
		return allSubsets;
	}

	private static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		// << returns the power of 2, basically 1 << 3 will yield 8 
		int max = 1 << set.size();
		for (int i = 0; i < max; i++) {
			ArrayList<Integer> subset = new ArrayList<Integer>();
			int k = i;
			int index = 0;
			while (k > 0) {
				if ((k & 1) > 0) {
					subset.add(set.get(index));
				}
				k >>= 1;
				index++;
			}
			allsubsets.add(subset);
		}
		return allsubsets;
	}

	private static void printSubsets(ArrayList<ArrayList<Integer>> list) {

		for (ArrayList<Integer> set : list) {
			System.out.println(set);
		}
	}
}
